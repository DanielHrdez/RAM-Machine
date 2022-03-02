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
 * @see ProgramMemory
 * Clase que representa una memoria de programa.
 */

package ram.components.memory;

public class ProgramMemory {
  private Instruction[] instructions;
  private int programCounter;

  /**
   * Constructor de la clase ProgramMemory.
   * 
   * @param instructions
   *          Array de instrucciones que representa la memoria de programa.
   */
  public ProgramMemory(Instruction[] instructions) {
    this.instructions = instructions;
    this.programCounter = 0;
  }

  /**
   * Método que devuelve la instrucción en la posición del program counter.
   * 
   * @return Instrucción en la posición del program counter.
   */
  public Instruction getInstruction() {
    return instructions[programCounter++];
  }

  /**
   * Método que devuelve el program counter.
   * 
   * @return Program counter.
   */
  public void setPC(String tag) {
    for (int i = 0; i < this.instructions.length; ++i) {
      if (this.instructions[i].getTag().equals(tag)) {
        this.programCounter = i;
        return;
      }
    }
  }
}
