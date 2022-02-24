package ramMachine.classes.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readInFile {
  private Scanner input;

  public readInFile(String fileName) {
    try {
      input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public String read() {
    String fileString = "";
    while (input.hasNextLine()) {
      fileString += input.nextLine();
    }
    return fileString;
  }
}
