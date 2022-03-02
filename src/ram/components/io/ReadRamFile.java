package ram.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ram.components.memory.Instruction;
import ram.components.memory.Opcode;

public class ReadRamFile {
  private Scanner input;

  public ReadRamFile(String fileName) {
    try {
      this.input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public Instruction[] getInstructions() {
    Instruction[] instructions = new Instruction[1];
    for (int i = 0; input.hasNextLine(); ++i) {
      if (i >= instructions.length) {
        Instruction[] newInstructions = new Instruction[instructions.length + 1];
        System.arraycopy(instructions, 0, newInstructions, 0, instructions.length);
        instructions = newInstructions;
      }
      instructions[i] = this.getInstruction(i);
    }
    return instructions;
  }

  private Instruction getInstruction(int numInstruction) {
    String instruction = this.readLine();
    if (instruction.trim().length() == 0) {
      return this.getInstruction(numInstruction);
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
    return new Instruction(tokens[0], this.getOpcode(tokens[1]), tokens[2]);
  }

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

  private Opcode getOpcode(String opcode) {
    switch (opcode) {
      case "LOAD":
        return Opcode.LOAD;
      case "STORE":
        return Opcode.STORE;
      case "ADD":
        return Opcode.ADD;
      case "SUB":
        return Opcode.SUB;
      case "MUL":
        return Opcode.MUL;
      case "DIV":
        return Opcode.DIV;
      case "READ":
        return Opcode.READ;
      case "WRITE":
        return Opcode.WRITE;
      case "JUMP":
        return Opcode.JUMP;
      case "JZERO":
        return Opcode.JZERO;
      case "JGTZ":
        return Opcode.JGTZ;
      case "HALT":
        return Opcode.HALT;
      default:
        return null;
    }
  }
}
