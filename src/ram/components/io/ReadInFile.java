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
 * @see ReadInFile
 * Clase que reconoce un archivo de entrada.
 */

package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInFile {
  private int[] inputTape = new int[0];

  /**
   * Constructor de la clase ReadInFile.
   * 
   * @param fileName
   *          Nombre del archivo de entrada.
   */
  public ReadInFile(String fileName) {
    try {
      Scanner input = new Scanner(new File(fileName));
      String allTape = input.nextLine();
      for (int i = 0; i < allTape.length(); ++i) {
        int[] newInputTape = new int[this.inputTape.length + 1];
        System.arraycopy(inputTape, 0, newInputTape, 0, this.inputTape.length);
        this.inputTape = newInputTape;
        inputTape[i] = allTape.charAt(i) - '0';
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  /**
   * Método que devuelve la cinta de entrada.
   * 
   * @return Cinta de entrada.
   */
  public int[] getInputTape() {
    return inputTape;
  }
}
