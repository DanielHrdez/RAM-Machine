package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRamFile {
  private Scanner input;

  public ReadRamFile(String fileName) {
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
