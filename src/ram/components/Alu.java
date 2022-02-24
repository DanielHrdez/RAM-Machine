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
      int op_int = Integer.parseInt(operandAux.substring(1));
      if (operandAux.startsWith("=")) {
        operand = op_int;
      } else if (operandAux.startsWith("*")) {
        operand = this.dataMemory.getReg(this.dataMemory.getReg(op_int));
      } else {
        operand = this.dataMemory.getReg(Integer.parseInt(operandAux));
      }
      switch (opcode) {
        case "LOAD":
          this.dataMemory.load(operand);
          break;
        case "STORE":
          this.dataMemory.store(operand);
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
          }
          break;
        case "WRITE":
          if (operand != 0) {
            this.outputUnit.write(this.dataMemory.getReg(operand));
          }
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
}
