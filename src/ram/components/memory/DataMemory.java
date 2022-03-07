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
  private Register[] registers = new Register[1];

  /**
   * Constructor de la clase DataMemory.
   */
  public DataMemory() {
    this.registers[0] = new Register();
  }

  /**
   * Método que carge un valor en el registro 0
   * 
   * @param value
   *         Valor que se carga en el registro 0.
   */
  public void load(int value) {
    registers[0].setValue(value);
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
    if (address >= this.registers.length) this.increase(address);
    registers[address] = registers[0];
  }

  /**
   * Método que devuelve el valor del registro 0.
   * 
   * @param address
   *        Dirección del registro que se asgina el contenido.
   * 
   * @return Valor del registro 0.
   */
  public void store(int address, int pos) {
    if (address >= this.registers.length) this.increase(address);
    registers[address].putAt(pos, registers[0].getValue());
  }

  /**
   * Método que devuelve el valor del registro 0.
   * 
   * @return Valor del registro 0.
   */
  public int getAcc() {
    return this.registers[0].getValue();
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
    if (address >= this.registers.length) this.increase(address);
    this.registers[address].setValue(value);
  }

  /**
   * Método que asigna un valor al registro indicado.
   * 
   * @param address
   *       Dirección del registro que se asgina el contenido.
   * @param value
   *      Valor que se asigna al registro.
   */
  public void setReg(int address, int value, int pos) {
    if (address >= this.registers.length) this.increase(address);
    registers[address].putAt(pos, value);
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
    if (address >= this.registers.length) this.increase(address);
    return this.registers[address].getValue();
  }

  /**
   * Método que sume el valor del registro 0 con el valor del indicado
   * y lo asigna al registro 0.
   * 
   * @param value
   *     Valor que se suma al registro 0.
   */
  public void add(int value) {
    this.registers[0].setValue(value + this.registers[0].getValue());
  }

  /**
   * Método que multiplica el valor del registro 0 con el valor del indicado
   * y lo asigna al registro 0.
   * 
   * @param value
   *     Valor que se multiplica al registro 0.
   */
  public void mul(int value) {
    this.registers[0].setValue(value * this.registers[0].getValue());
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

  private void increase(int size) {
    Register[] newRegisters = new Register[size + 1];
    System.arraycopy(this.registers, 0, newRegisters, 0, this.registers.length);
    for (int i = 0; i < size + 1; i++) {
      if (newRegisters[i] == null) {
        newRegisters[i] = new Register();
      }
    }
    this.registers = newRegisters;
  }
}
