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
 * @see InputUnit
 * Clase que representa una unidad de entrada.
 */

package ram.components.io;

public class InputUnit {
  private int[] inputTape;
  private int readingHead;

  /**
   * Constructor de la clase InputUnit.
   * 
   * @param inputTape
   *          Array de enteros que representa la cinta de entrada.
   */
  public InputUnit(int[] inputTape) {
    this.inputTape = inputTape;
    readingHead = 0;
  }

  /**
   * Método que devuelve el valor de la cabeza de lectura.
   * Aumenta la cabeza de lectura en una unidad.
   * 
   * @return Valor de la cabeza de lectura.
   */
  public int read() {
    if (readingHead >= inputTape.length) {
      return 0;
    }
    return inputTape[readingHead++];
  }
}
