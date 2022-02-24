package ram.components.memory;

public class Instruction {
  private String tag;
  private String opcode;
  private String operand;

  public Instruction(String instruction) {
    String[] tokens = instruction.split(" ");
    switch (tokens.length) {
      case 3:
        this.tag = tokens[0];
        this.opcode = tokens[1];
        this.operand = tokens[2];
        break;
      case 2:
        this.tag = "";
        this.opcode = tokens[0];
        this.operand = tokens[1];
        break;
      default:
        this.tag = "";
        this.opcode = "";
        this.operand = "";
        break;
    }
  }

  public String getTag() {
    return this.tag;
  }

  public String getOpcode() {
    return this.opcode;
  }

  public String getOperand() {
    return this.operand;
  }
}
