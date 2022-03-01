package ram.components.memory;

public class Instruction {
  private String tag;
  private String opcode;
  private String operand;

  public Instruction(String instruction) {
    instruction = instruction.replaceAll("\\s+", " ");
    instruction = instruction.replaceAll("\\t", " ");
    String[] tokens = instruction.split(" ");
    this.tag = tokens[0];
    this.opcode = tokens[1];
    if (tokens.length > 2) this.operand = tokens[2];
    else this.operand = "";
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
