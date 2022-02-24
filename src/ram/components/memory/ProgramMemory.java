package ram.components.memory;

import ram.components.Instruction;
import ram.components.io.ReadRamFile;

public class ProgramMemory {
  private Instruction[] instructions = new Instruction[1024];

  public ProgramMemory(String path) {
    ReadRamFile readRamFile = new ReadRamFile(path);
    this.instructions = new Instruction[readRamFile.size()];
    for (int i = 0; readRamFile.getInstruction() != null; ++i) {
      instructions[i] = readRamFile.getInstruction();
    }
  }

  public Instruction getInstruction(int address) {
    return instructions[address];
  }
}
