package ram;

import ram.components.Alu;
import ram.components.io.ReadInFile;
import ram.components.io.WriteOutFile;
import ram.components.io.ReadRamFile;
import ram.components.memory.Instruction;

public class Ram {
  public static void main(String[] args) {
    // Read in the input file and create the InputTape
    ReadInFile readInFile = new ReadInFile(args[1]);
    int[] inputTape = readInFile.getInputTape();

    // Read the ram file and create the instructions
    ReadRamFile readRamFile = new ReadRamFile(args[0]);
    Instruction[] instructions = readRamFile.getInstructions();

    // Create the Alu and run the Alu
    Alu alu = new Alu(instructions, inputTape);
    alu.run();

    // Write the output file
    WriteOutFile writeOutFile = new WriteOutFile(args[2]);
    writeOutFile.write(alu.getOutputTape());
  }
}