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
}
