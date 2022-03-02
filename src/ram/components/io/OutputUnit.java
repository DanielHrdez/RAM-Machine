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
 * @see OutputUnit
 * Clase que representa una unidad de salida.
 */

package ram.components.io;

public class OutputUnit {
  private int[] outputTape;
  private int writingHead;

  /**
   * Constructor de la clase OutputUnit.
   */
  public OutputUnit() {
    this.outputTape = new int[1];
    this.outputTape[0] = 0;
    this.writingHead = 0;
  }

  /**
   * Método que escribe un valor en la cinta, 
   * en la posición de la cabeza de escritura.
   * 
   * @param value
   *         Valor que se escribe en la cinta.
   */
  public void write(int value) {
    if (this.writingHead >= this.outputTape.length) {
      int[] newOutputTape = new int[this.outputTape.length + 1];
      System.arraycopy(this.outputTape, 0, newOutputTape, 0, this.outputTape.length);
      this.outputTape = newOutputTape;
    }
    this.outputTape[this.writingHead++] = value;
  }

  /**
   * Método que devuelve la cinta de salida.
   * 
   * @return Cinta de salida.
   */
  public int[] getOutputTape() {
    return this.outputTape;
  }
}
