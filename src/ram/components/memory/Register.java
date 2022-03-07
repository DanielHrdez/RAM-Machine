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
        if (index >= this.values.length) this.increase(index);
        return this.values[index];
    }

    public void putAt(int index, int value) {
        if (index >= this.values.length) this.increase(index);
        this.values[index] = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.values.length; i++) {
            sb.append(this.values[i]);
            if (i < this.values.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void increase(int size) {
        int[] newValues = new int[size + 1];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
}
