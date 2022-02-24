package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ram.components.memory.Instruction;

public class ReadRamFile {
  private Scanner input;

  public ReadRamFile(String fileName) {
    try {
      this.input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public Instruction[] getInstructions() {
    Instruction[] instructions = new Instruction[1024];
    for (int i = 0; input.hasNextLine(); ++i) {
      if (i >= instructions.length) {
        Instruction[] newInstructions = new Instruction[instructions.length * 2];
        System.arraycopy(instructions, 0, newInstructions, 0, instructions.length);
        instructions = newInstructions;
      }
      instructions[i] = this.getInstruction();
    }
    return instructions;
  }

  private Instruction getInstruction() {
    String line = this.readLine();
    if (line != null) {
      return new Instruction(line);
    } else {
      return null;
    }
  }

  private String readLine() {
    if (this.input.hasNextLine()) {
      String nextLine = this.input.nextLine();
      if (nextLine.startsWith("#") || nextLine.length() == 0) {
        return this.readLine();
      } else {
        return nextLine;
      }
    } else {
      return null;
    }
  }
}
