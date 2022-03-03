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
 * @see ReadRamFile
 * Clase que reconoce un archivo de código RAM.
 */

package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ram.components.memory.Instruction;
import ram.components.memory.Opcode;

public class ReadRamFile {
  private Scanner input;

  /**
   * Constructor de la clase ReadRamFile.
   * 
   * @param fileName
   *          Nombre del archivo de entrada.
   */
  public ReadRamFile(String fileName) {
    try {
      this.input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  /**
   * Método que devuelve las instrucciones leídas del archivo.
   * 
   * @return Instructiones leídas del archivo.
   */
  public Instruction[] getInstructions() {
    Instruction[] instructions = new Instruction[0];
    for (int i = 0; input.hasNextLine(); ++i) {
      Instruction[] newInstructions = new Instruction[instructions.length + 1];
      System.arraycopy(instructions, 0, newInstructions, 0, instructions.length);
      instructions = newInstructions;
      instructions[i] = this.getInstruction();
    }
    return instructions;
  }

  /**
   * Método que devuelve una instrucción leída del archivo.
   * Ignora los espacios en blanco y tabuladores.
   * 
   * @return Instrucción leída del archivo.
   */
  private Instruction getInstruction() {
    String instruction = this.readLine();
    if (instruction.trim().length() == 0) {
      return this.getInstruction();
    }
    instruction = instruction.replaceAll("\\s+", " ");
    instruction = instruction.replaceAll("\\t", " ");
    String[] tokens = instruction.split(" ");
    if (tokens.length < 3) {
      String[] newTokens = new String[3];
      System.arraycopy(tokens, 0, newTokens, 0, tokens.length);
      newTokens[2] = "";
      tokens = newTokens;
    }
    return new Instruction(tokens[0], Opcode.valueOf(tokens[1].toUpperCase()), tokens[2]);
  }

  /**
   * Método que lee una línea del archivo.
   * Ignora comentarios y líneas vacías.
   * 
   * @return Línea leída del archivo.
   */
  private String readLine() {
    if (this.input.hasNextLine()) {
      String nextLine = this.input.nextLine();
      if (nextLine.startsWith("#") || nextLine.length() == 0) {
        return this.readLine();
      } else {
        return nextLine;
      }
    } else {
      return null;
    }
  }
}
