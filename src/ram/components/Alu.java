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
 * Clase que escribe en un fichero de salida.
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

  public Alu(Instruction[] instructions, int[] inputTape) {
    this.dataMemory = new DataMemory();
    this.programMemory = new ProgramMemory(instructions);
    this.inputUnit = new InputUnit(inputTape);
    this.outputUnit = new OutputUnit();
  }

  public void run() {
    while (true) {
      Instruction instruction = programMemory.getInstruction();
      Opcode opcode = instruction.getOpcode();
      String operand = instruction.getOperand();
      int value;
      switch (opcode) {
        case LOAD:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
            this.dataMemory.load(value);
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.load(this.dataMemory.getReg(value));
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
            this.dataMemory.load(value);
          }
          break;
        case STORE:
          if (operand.startsWith("=")) {
            throw new Error("STORE cannot have an =operand");
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.store(value);
          } else {
            value = Integer.parseInt(operand);
            this.dataMemory.store(value);
          }
          break;
        case ADD:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
            this.dataMemory.add(value);
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.add(this.dataMemory.getReg(value));
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
            this.dataMemory.add(value);
          }
          break;
        case SUB:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
            this.dataMemory.add(-value);
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.add(-this.dataMemory.getReg(value));
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
            this.dataMemory.add(-value);
          }
          break;
        case MUL:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
            this.dataMemory.mul(value);
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.mul(this.dataMemory.getReg(value));
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
            this.dataMemory.mul(value);
          }
          break;
        case DIV:
          if (operand.startsWith("=")) {
            value = Integer.parseInt(operand.substring(1));
            this.dataMemory.mul(1 / value);
          } else if (operand.startsWith("*")) {
            value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
            this.dataMemory.mul(1 / this.dataMemory.getReg(value));
          } else {
            value = this.dataMemory.getReg(Integer.parseInt(operand));
            this.dataMemory.mul(1 / value);
          }
          break;
        case READ:
          if (operand != "0") {
            if (operand.startsWith("=")) {
              value = Integer.parseInt(operand.substring(1));
              this.dataMemory.setReg(value, this.inputUnit.read());
            } else if (operand.startsWith("*")) {
              value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
              this.dataMemory.setReg(value, this.inputUnit.read());
            } else {
              value = Integer.parseInt(operand);
              this.dataMemory.setReg(value, this.inputUnit.read());
            }
          } else throw new Error("READ cannot store to R0");
          break;
        case WRITE:
          if (!operand.equals("0")) {
            if (operand.startsWith("=")) {
              value = Integer.parseInt(operand.substring(1));
              this.outputUnit.write(value);
            } else if (operand.startsWith("*")) {
              value = this.dataMemory.getReg(Integer.parseInt(operand.substring(1)));
              this.outputUnit.write(this.dataMemory.getReg(value));
            } else {
              value = this.dataMemory.getReg(Integer.parseInt(operand));
              this.outputUnit.write(value);
            }
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
          return;
        default:
          return;
      }
    }
  }

  public int[] getOutputTape() {
    return this.outputUnit.getOutputTape();
  }
}


