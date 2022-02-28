package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInFile {
  private int[] inputTape = new int[1024];

  public ReadInFile(String fileName) {
    try {
      Scanner input = new Scanner(new File(fileName));
      String allTape = input.nextLine();
      for (int i = 0; i < allTape.length(); ++i) {
        if (i >= inputTape.length) {
          int[] newInputTape = new int[this.inputTape.length * 2];
          System.arraycopy(inputTape, 0, newInputTape, 0, this.inputTape.length);
          this.inputTape = newInputTape;
        }
        inputTape[i] = allTape.charAt(i) - '0';
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public int[] getInputTape() {
    return inputTape;
  }
}
