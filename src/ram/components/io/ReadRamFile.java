package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ram.components.Instruction;

public class ReadRamFile {
  private Scanner input;

  public ReadRamFile(String fileName) {
    try {
      this.input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  private String readLine() {
    if (this.input.hasNextLine()) {
      if (this.input.nextLine().startsWith("#") || this.input.nextLine().length() == 0) {
        return readLine();
      } else {
        return this.input.nextLine();
      }
    } else {
      return null;
    }
  }

  public Instruction getInstruction() {
    String line = readLine();
    if (line != null) {
      return new Instruction(line);
    } else {
      return null;
    }
  }
}
