package ramMachine.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readRamFile {
  private Scanner input;

  public readRamFile(String fileName) {
    try {
      input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public String readLine() {
    if (input.hasNextLine()) {
      if (input.nextLine().startsWith("#") || input.nextLine().length() == 0) {
        return readLine();
      } else {
        return input.nextLine();
      }
    } else {
      return null;
    }
  }
}
