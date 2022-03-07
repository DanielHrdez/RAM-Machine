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
    this.outputTape = new int[0];
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
    int[] newOutputTape = new int[this.outputTape.length + 1];
    System.arraycopy(this.outputTape, 0, newOutputTape, 0, this.outputTape.length);
    this.outputTape = newOutputTape;
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

  /**
   * Método que devuelve una string con la cinta de salida.
   * 
   * @return String con la cinta de salida.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.outputTape.length == 0) sb.append("*");
    else for (int i = 0; i < this.outputTape.length; i++) {
      sb.append(this.outputTape[i]);
      if (i == this.writingHead -1) {
        sb.append("*");
      }
      sb.append(" ");
    }
    return sb.toString();
  }
}
