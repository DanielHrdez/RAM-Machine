package ram.components.io;

public class InputUnit {
  private int[] inputTape;
  private int readingHead;

  public InputUnit(int[] inputTape) {
    this.inputTape = inputTape;
    readingHead = 0;
  }

  public int read() {
    if (readingHead >= inputTape.length) {
      return 0;
    }
    return inputTape[readingHead++];
  }
}
