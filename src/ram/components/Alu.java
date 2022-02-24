package ram.components;

import ram.components.memory.DataMemory;
import ram.components.memory.ProgramMemory;
import ram.components.io.ReadInFile;
import ram.components.io.WriteOutFile;

public class Alu {
  private DataMemory dataMemory;
  private ProgramMemory programMemory;

  public Alu(String dataMemoryPath, String programMemoryPath) {
    this.dataMemory = new DataMemory();
    this.programMemory = new ProgramMemory(programMemoryPath);
    ReadInFile inputFile = new ReadInFile(dataMemoryPath);
    int address = 0;
    while (inputFile.hasNext()) {
      this.dataMemory.store(address, inputFile.read());
      address++;
    }
  }
}
