package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ram.components.memory.Instruction;

public class ReadRamFile {
  private Scanner input;
  private int size;

  public ReadRamFile(String fileName) {
    try {
      this.input = new Scanner(new File(fileName));
      this.size = 0;
      Scanner aux = this.input;
      while (this.input.hasNextLine()) {
        String nextLine = this.input.nextLine();
        if (nextLine.startsWith("#") || nextLine.length() == 0) {
          continue;
        }
        this.size++;
      }
      this.input = aux;
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
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

  public int size() {
    return this.size;
  }

  private String readLine() {
    if (this.input.hasNextLine()) {
      String nextLine = this.input.nextLine();
      if (nextLine.startsWith("#") || nextLine.length() == 0) {
        return readLine();
      } else {
        return nextLine;
      }
    } else {
      return null;
    }
  }
}
