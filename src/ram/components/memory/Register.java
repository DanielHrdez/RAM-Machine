package ram.components.memory;

public class Register {
    private int[] values;

    public Register() {
        this.values = new int[1];
        this.values[0] = 0;
    }

    public int getValue() {
        return this.values[0];
    }

    public void setValue(int value) {
        this.values[0] = value;
    }

    public int getAt(int index) {
        return this.values[index];
    }

    public void putAt(int index, int value) {
        this.values[index] = value;
    }
}
