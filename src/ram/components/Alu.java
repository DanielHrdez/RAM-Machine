/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Grado en Ingeniería Informática
 * Asignatura: Diseño y Análisis de Algoritmos
 * 
 * @author Daniel Hdez de León
 * 
 * @version 1.0.0
 * 
 * @see Alu
 * Clase que representa una ALU.
 */

package ram.components;

import ram.components.memory.DataMemory;
import ram.components.memory.ProgramMemory;
import ram.components.memory.Instruction;
import ram.components.memory.Opcode;
import ram.components.io.InputUnit;
import ram.components.io.OutputUnit;

public class Alu {
  private DataMemory dataMemory;
  private ProgramMemory programMemory;
  private InputUnit inputUnit;
  private OutputUnit outputUnit;

  /**
   * Constructor de la clase Alu.
   * 
   * @param instructions
   *         Array de instrucciones que representa la memoria de programa.
   * @param inputTape
   *        Array de bits que representa la cinta de entrada.
   */
  public Alu(Instruction[] instructions, int[] inputTape) {
    this.dataMemory = new DataMemory();
    this.programMemory = new ProgramMemory(instructions);
    this.inputUnit = new InputUnit(inputTape);
    this.outputUnit = new OutputUnit();
  }

  /**
   * Método que ejecuta la ALU.
   * 
   * @param debugMode
   *       Modo de depuración.
   */
  public void run(int debugMode) {
    int instExecuted = 0;
    while (true) {
      Instruction instruction = programMemory.getInstruction();
      Opcode opcode = instruction.getOpcode();
      String operand = instruction.getOperand();
      int value = 0, reg = 0;
      if (debugMode == 2) {
        System.out.println("Instruccion a ejecutar: " + instruction.toString());
        System.out.println("Memoria de datos: " + dataMemory.toString());
        System.out.println("Cinta de entrada: " + inputUnit.toString());
        System.out.println("Cinta de salida: " + outputUnit.toString());
        System.out.println("Press enter to continue...");
        try {
          while(true) {
            if (System.in.read() == '\n') {
              break;
            }
          }
        } catch (Exception e) {
          System.out.println("Error reading input");
        }
      }
      switch (opcode) {
        case LOAD:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            value = this.dataMemory.getReg(value);
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
          }
          this.dataMemory.load(value);
          break;
        case STORE:
          if (operand.startsWith("=")) {
            throw new Error("STORE cannot have an =operand");
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.store(value);
          } else if (operand.matches("R[0-9]+\\[.+\\]")) {
            reg = Integer.parseInt(operand.substring(1, operand.indexOf('[')));
            if (operand.matches("R[0-9]+\\[R[0-9]+\\]")) {
              value = this.dataMemory.getReg(Integer.parseInt(operand.substring(operand.indexOf('[') + 2, operand.length() - 1)));
            } else if (operand.matches("R[0-9]+\\[[0-9]+\\]")) {
              value = Integer.parseInt(operand.substring(operand.indexOf('[') + 1, operand.length() - 1));
            }
            this.dataMemory.store(reg, value);
          } else {
            value = Integer.parseInt(operand);
            this.dataMemory.store(value);
          }
          break;
        case ADD:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            value = this.dataMemory.getReg(value);
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
          }
          this.dataMemory.add(value);
          break;
        case SUB:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            value = -this.dataMemory.getReg(value);
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
          }
          this.dataMemory.add(-value);
          break;
        case MUL:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            value = this.dataMemory.getReg(value);
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
          }
          this.dataMemory.mul(value);
          break;
        case DIV:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            value = 1 / this.dataMemory.getReg(value);
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
          }
          this.dataMemory.mul(1 / value);
          break;
        case READ:
          if (operand != "0") {
            if (operand.startsWith("=")) {
              value = Integer.parseInt(operand.substring(1));
            } else if (operand.startsWith("*")) {
              value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            } else {
              value = Integer.parseInt(operand);
            }
            this.dataMemory.setReg(value, this.inputUnit.read());
          } else throw new Error("READ cannot store to R0");
          break;
        case WRITE:
          if (!operand.equals("0")) {
            if (operand.startsWith("=")) {
              value = Integer.parseInt(operand.substring(1));
            } else if (operand.startsWith("*")) {
              value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
              value = this.dataMemory.getReg(value);
            } else {
              value = this.dataMemory.getReg(Integer.parseInt(operand));
            }
            this.outputUnit.write(value);
          } else throw new Error("WRITE cannot store from R0");
          break;
        case JUMP:
          this.programMemory.setPC(operand.concat(":"));
          break;
        case JZERO:
          if (this.dataMemory.getAcc() == 0) {
            this.programMemory.setPC(operand.concat(":"));
          }
          break;
        case JGTZ:
          if (this.dataMemory.getAcc() > 0) {
            this.programMemory.setPC(operand.concat(":"));
          }
          break;
        case HALT:
        default:
          if (debugMode == 1 || debugMode == 2) {
            System.out.println("Instrucciones ejecutadas: " + instExecuted);
          }
          return;
      }
      instExecuted++;
    }
  }

  /**
   * Método que devuelve el valor de la cinta de salida.
   * @return Cinta de salida.
   */
  public int[] getOutputTape() {
    return this.outputUnit.getOutputTape();
  }
}


