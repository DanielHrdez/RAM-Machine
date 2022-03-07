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
 * @see DataMemory
 * Clase que representa una memoria de datos.
 */

package ram.components.memory;

public class DataMemory {
  private int[] registers = new int[1];

  /**
   * Constructor de la clase DataMemory.
   */
  public DataMemory() {
    registers[0] = 0;
  }

  /**
   * Método que carge un valor en el registro 0
   * 
   * @param value
   *         Valor que se carga en el registro 0.
   */
  public void load(int value) {
    registers[0] = value;
  }

  /**
   * Método que devuelve el valor del registro 0.
   * 
   * @param address
   *        Dirección del registro que se asgina el contenido.
   * 
   * @return Valor del registro 0.
   */
  public void store(int address) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    registers[address] = registers[0];
  }

  /**
   * Método que devuelve el valor del registro 0.
   * 
   * @return Valor del registro 0.
   */
  public int getAcc() {
    return this.registers[0];
  }

  /**
   * Método que asigna un valor al registro indicado.
   * 
   * @param address
   *       Dirección del registro que se asgina el contenido.
   * @param value
   *      Valor que se asigna al registro.
   */
  public void setReg(int address, int value) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    this.registers[address] = value;
  }

  /**
   * Método que devuelve el valor del registro indicado.
   * 
   * @param address
   *       Dirección del registro que se asgina el contenido.
   * 
   * @return Valor del registro indicado.
   */
  public int getReg(int address) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    return this.registers[address];
  }

  /**
   * Método que sume el valor del registro 0 con el valor del indicado
   * y lo asigna al registro 0.
   * 
   * @param value
   *     Valor que se suma al registro 0.
   */
  public void add(int value) {
    this.registers[0] += value;
  }

  /**
   * Método que multiplica el valor del registro 0 con el valor del indicado
   * y lo asigna al registro 0.
   * 
   * @param value
   *     Valor que se multiplica al registro 0.
   */
  public void mul(int value) {
    this.registers[0] *= value;
  }

  /**
   * Método que devuelve los valores de los registros.
   * 
   * @return String de los valores de los registros.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Registers: ");
    for (int i = 0; i < registers.length; i++) {
      sb.append(registers[i]);
      sb.append(" ");
    }
    return sb.toString();
  }
}
