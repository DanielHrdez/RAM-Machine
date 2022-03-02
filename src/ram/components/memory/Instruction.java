package ram.components.memory;

public class Instruction {
  private String tag;
  private Opcode opcode;
  private String operand;

  public Instruction(String tag, Opcode opcode, String operand) {
    this.tag = tag;
    this.opcode = opcode;
    this.operand = operand;
  }

  public String getTag() {
    return this.tag;
  }

  public Opcode getOpcode() {
    return this.opcode;
  }

  public String getOperand() {
    return this.operand;
  }
}
