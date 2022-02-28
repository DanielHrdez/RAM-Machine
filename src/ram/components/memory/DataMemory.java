package ram.components.memory;

public class DataMemory {
  private int[] registers = new int[1024];

  public DataMemory() {
    registers[0] = 0;
  }

  public void load(int value) {
    registers[0] = value;
  }

  public void store(int address) {
    registers[address] = registers[0];
  }

  public int getAcc() {
    return this.registers[0];
  }

  public void setReg(int address, int value) {
    this.registers[address] = value;
  }

  public int getReg(int address) {
    return this.registers[address];
  }

  public void add(int value) {
    this.registers[0] += value;
  }

  public void mul(int value) {
    this.registers[0] *= value;
  }
}
