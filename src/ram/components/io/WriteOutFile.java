/**
 * Universidad de La Laguna
 * Escuela Superior de Ingeniería y Tecnología
 * Grado en Ingeniería Informática
 * Asignatura: Diseño y Análisis de Algoritmos
 * 
 * @author Daniel Hdez de León
 * 
 * @version 1.0.0
 * 
 * @see WriteOutFile
 * Clase que escribe en un fichero de salida.
 */

package ram.components.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOutFile {
  private File outputFile;

  /**
   * Constructor de la clase WriteOutFile.
   * 
   * @param path
   *          Ruta del fichero de salida.
   */
  public WriteOutFile(String path) {
    try {
      this.outputFile = new File(path);
      if (!this.outputFile.exists()) {
        this.outputFile.createNewFile();
      } else {
        this.outputFile.delete();
        this.outputFile.createNewFile();
      }
    } catch (IOException e) {
      System.out.println("Error occurred while creating file");
    }
  }

  /**
   * Método que escribe en el fichero de salida.
   * 
   * @param outputTape
   *          Cinta de salida.
   */
  public void write(int[] outputTape) {
    try {
      PrintWriter outputWriter = new PrintWriter(this.outputFile);
      for (int i = 0; i < outputTape.length; ++i) {
        outputWriter.print(outputTape[i]);
      }
      outputWriter.close();
    } catch (IOException e) {
      System.out.println("Error occurred while writing to file");
    }
  }
}
