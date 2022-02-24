package ramMachine.classes.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class writeOutFile {
  private File outputFile;

  public writeOutFile(String path) {
    outputFile = new File(path);
  }

  public void write(String data) {
    try {
      if (!outputFile.exists()) {
        outputFile.createNewFile();
      }
      PrintWriter output = new PrintWriter(outputFile);
      output.println(data);
      output.close();
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }
}
