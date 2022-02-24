package ram.components.memory;

import ram.components.io.ReadRamFile;

public class ProgramMemory {
  private Instruction[] instructions;

  public ProgramMemory(String path) {
    ReadRamFile RamFile = new ReadRamFile(path);
    this.instructions = new Instruction[RamFile.size()];
    for (int i = 0; i < this.instructions.length; ++i) {
      instructions[i] = RamFile.getInstruction();
    }
  }

  public Instruction getInstruction(int address) {
    return instructions[address];
  }
}
