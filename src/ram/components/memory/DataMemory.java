package ram.components.memory;

public class DataMemory {
  private int[] registers = new int[1];

  public DataMemory() {
    registers[0] = 0;
  }

  public void load(int value) {
    registers[0] = value;
  }

  public void store(int address) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    registers[address] = registers[0];
  }

  public int getAcc() {
    return this.registers[0];
  }

  public void setReg(int address, int value) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    this.registers[address] = value;
  }

  public int getReg(int address) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    return this.registers[address];
  }

  public void add(int value) {
    this.registers[0] += value;
  }

  public void mul(int value) {
    this.registers[0] *= value;
  }
}
