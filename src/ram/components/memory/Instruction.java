package ram.components.memory;

public class Instruction {
  private String tag;
  private String opcode;
  private String operand;

  public Instruction(String instruction) {
    instruction = instruction.replaceAll("^\\s+", "");
    instruction = instruction.replaceAll("\\t", " ");
    String[] tokens = instruction.split(" ");
    switch (tokens.length) {
      case 3:
        this.tag = tokens[0];
        this.opcode = tokens[1];
        this.operand = tokens[2];
        break;
      case 2:
        // if the first token ends with ':', its the tag
        if (tokens[0].endsWith(":")) {
          this.tag = tokens[0];
          this.opcode = tokens[1];
          this.operand = "";
        } else {
          this.tag = "";
          this.opcode = tokens[0];
          this.operand = tokens[1];
        }
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
