package ram.components.memory;

public class Register {
    int value = 0;
    int[] registers = new int[1];
    boolean isVector = false;

    public boolean isVector() {
        return this.isVector;
    }

    public void setVector(boolean isVector) {
        this.isVector = isVector;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAt(int index) {
        return this.registers[index];
    }

    public void putAt(int index, int value) {
        this.registers[index] = value;
    }
}
