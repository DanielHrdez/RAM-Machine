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
 * @see Opcode
 * Enumerado que representa los diferentes opcodes.
 */

package ram.components.memory;

public enum Opcode {
  LOAD, STORE, ADD, SUB, MUL, DIV, READ, WRITE, JUMP, JZERO, JGTZ, HALT;
}
