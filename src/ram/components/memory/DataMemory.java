package ram.components.memory;

public class DataMemory {
  private int[] registers = new int[1];

  public DataMemory() {
    registers[0] = 0;
  }

  public void store(int address, int value) {
    if (address >= registers.length) {
      int[] newRegisters = new int[address + 1];
      System.arraycopy(registers, 0, newRegisters, 0, registers.length);
      registers = newRegisters;
    }
    registers[address] = value;
  }

  public int load(int address) {
    if (address >= registers.length) {
      return 0;
    }
    return registers[address];
  }
}
