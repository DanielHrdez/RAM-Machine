package ram.components;

import ram.components.memory.DataMemory;
import ram.components.memory.ProgramMemory;
import ram.components.memory.Instruction;
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
      String tag = instruction.getTag();
      String opcode = instruction.getOpcode().toUpperCase();
      String operandAux = instruction.getOperand();
      int operand = 0;
      if (operandAux.startsWith("=")) {
        operand = Integer.parseInt(operandAux.substring(1));
      } else if (operandAux.startsWith("*")) {
        operand = this.dataMemory.getReg(
            this.dataMemory.getReg(Integer.parseInt(operandAux.substring(1)))
        );
      } else if (isNumeric(operandAux)) {
        if (opcode.equals("READ") || opcode.equals("WRITE")) {
          operand = Integer.parseInt(operandAux);
        } else {
          operand = this.dataMemory.getReg(Integer.parseInt(operandAux));
        }
      } else tag = operandAux.concat(":");
      switch (opcode) {
        case "LOAD":
          this.dataMemory.load(operand);
          break;
        case "STORE":
          if (!operandAux.startsWith("=")) this.dataMemory.store(operand);
          else throw new Error("STORE cannot have an =operand");
          break;
        case "ADD":
          this.dataMemory.add(operand);
          break;
        case "SUB":
          this.dataMemory.add(-operand);
          break;
        case "MUL":
          this.dataMemory.mul(operand);
          break;
        case "DIV":
          this.dataMemory.mul(1 / operand);
          break;
        case "READ":
          if (operand != 0) {
            this.dataMemory.setReg(operand, this.inputUnit.read());
          } else throw new Error("READ cannot store to R0");
          break;
        case "WRITE":
          if (operand != 0) {
            this.outputUnit.write(this.dataMemory.getReg(operand));
          } else throw new Error("WRITE cannot store from R0");
          break;
        case "JUMP":
          this.programMemory.setPC(tag);
          break;
        case "JZERO":
          if (this.dataMemory.getAcc() == 0) {
            this.programMemory.setPC(tag);
          }
          break;
        case "JGTZ":
          if (this.dataMemory.getAcc() > 0) {
            this.programMemory.setPC(tag);
          }
          break;
        case "HALT":
          return;
        default:
          return;
      }
    }
  }

  public int[] getOutputTape() {
    return this.outputUnit.getOutputTape();
  }
  
  boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}


