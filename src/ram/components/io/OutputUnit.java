package ram.components.io;

public class OutputUnit {
  private int[] outputTape;
  private int writingHead;

  public OutputUnit() {
    outputTape = new int[1024];
    outputTape[0] = 0;
    writingHead = 0;
  }

  public void write(int value) {
    if (writingHead >= outputTape.length) {
      int[] newOutputTape = new int[outputTape.length * 2];
      System.arraycopy(outputTape, 0, newOutputTape, 0, outputTape.length);
      outputTape = newOutputTape;
    }
    outputTape[writingHead++] = value;
  }

  public int[] getOutputTape() {
    return outputTape;
  }
}
