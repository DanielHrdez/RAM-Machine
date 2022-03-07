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
 * @see Instruction
 * Clase que representa una instrucción.
 */

package ram.components.memory;

public class Instruction {
  private String tag;
  private Opcode opcode;
  private String operand;

  /**
   * Constructor de la clase Instruction.
   * 
   * @param tag
   *          Tag de la instrucción.
   * @param opcode
   *          Opcode de la instrucción.
   * @param operand
   *          Operando de la instrucción.
   */
  public Instruction(String tag, Opcode opcode, String operand) {
    this.tag = tag;
    this.opcode = opcode;
    this.operand = operand;
  }

  /**
   * Método que devuelve el tag de la instrucción.
   * 
   * @return Tag de la instrucción.
   */
  public String getTag() {
    return this.tag;
  }

  /**
   * Método que devuelve el opcode de la instrucción.
   * 
   * @return Opcode de la instrucción.
   */
  public Opcode getOpcode() {
    return this.opcode;
  }

  /**
   * Método que devuelve el operando de la instrucción.
   * 
   * @return Operando de la instrucción.
   */
  public String getOperand() {
    return this.operand;
  }

  /**
   * Método que devuelve una representación en String de la instrucción.
   * 
   * @return Representación en String de la instrucción.
   */
  public String toString() {
    return "Instruccion: " + this.tag + " " + this.opcode.toString() + " " + this.operand;
  }
}
