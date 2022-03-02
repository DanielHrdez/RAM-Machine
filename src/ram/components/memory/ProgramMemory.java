package ram.components.memory;

public class ProgramMemory {
  private Instruction[] instructions;
  private int programCounter;

  public ProgramMemory(Instruction[] instructions) {
    this.instructions = instructions;
    this.programCounter = 0;
  }

  public Instruction getInstruction() {
    return instructions[programCounter++];
  }

  public void setPC(String tag) {
    for (int i = 0; i < this.instructions.length; ++i) {
      if (this.instructions[i].getTag().equals(tag)) {
        this.programCounter = i;
        return;
      }
    }
  }
}
