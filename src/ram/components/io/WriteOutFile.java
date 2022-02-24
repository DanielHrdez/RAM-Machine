package ram.components.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOutFile {
  private File outputFile;

  public WriteOutFile(String path) {
    try {
      File outputFile = new File(path);
      if (!outputFile.exists()) {
        outputFile.createNewFile();
      } else {
        outputFile.delete();
        outputFile.createNewFile();
      }
    } catch (IOException e) {
      System.out.println("Error occurred while creating file");
    }
  }

  public void write(int[] outputTape) {
    try {
      PrintWriter outputWriter = new PrintWriter(outputFile);
      for (int i = 0; i < outputTape.length; ++i) {
        outputWriter.println(outputTape[i]);
      }
      outputWriter.close();
    } catch (IOException e) {
      System.out.println("Error occurred while writing to file");
    }
  }
}
