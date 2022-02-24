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
}
