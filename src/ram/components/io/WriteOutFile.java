package ram.components.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOutFile {
  private File outputFile;

  public WriteOutFile(String path) {
    outputFile = new File(path);
    try {
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

  public void write(char data) {
    try {
      PrintWriter outputWriter = new PrintWriter(outputFile);
      outputWriter.print(data);
      outputWriter.close();
    } catch (IOException e) {
      System.out.println("Error occurred while writing to file");
    }
  }
}
