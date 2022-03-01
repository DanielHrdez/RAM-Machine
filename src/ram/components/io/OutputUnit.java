package ram.components.io;

public class OutputUnit {
  private int[] outputTape;
  private int writingHead;

  public OutputUnit() {
    this.outputTape = new int[1];
    this.outputTape[0] = 0;
    this.writingHead = 0;
  }

  public void write(int value) {
    if (this.writingHead >= this.outputTape.length) {
      int[] newOutputTape = new int[this.outputTape.length + 1];
      System.arraycopy(this.outputTape, 0, newOutputTape, 0, this.outputTape.length);
      this.outputTape = newOutputTape;
    }
    this.outputTape[this.writingHead++] = value;
  }

  public int[] getOutputTape() {
    return this.outputTape;
  }
}
