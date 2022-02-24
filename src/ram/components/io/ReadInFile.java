package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInFile {
  private int[] inputTape = new int[1024];

  public ReadInFile(String fileName) {
    try {
      Scanner input = new Scanner(new File(fileName));
      for (int i = 0; input.hasNext(); ++i) {
        if (i >= this.inputTape.length) {
          int[] newInputTape = new int[this.inputTape.length * 2];
          System.arraycopy(inputTape, 0, newInputTape, 0, this.inputTape.length);
          this.inputTape = newInputTape;
        }
        this.inputTape[i] = input.nextInt();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public int[] getInputTape() {
    return inputTape;
  }
}
