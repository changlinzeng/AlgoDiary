package design;

public class DesignCircularQueue_622 {
  static class MyCircularQueue {
    private final int[] array;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
      this.array = new int[k];
      this.head = -1;
      this.tail = -1;
    }

    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      if (isEmpty()) {
        array[0] = value;
        head = 0;
        tail = 0;
        return true;
      }
      tail = (tail + 1) % array.length;
      array[tail] = value;
      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      if (head == tail) {
        head = -1;
        tail = -1;
        return true;
      }
      head = (head + 1) % array.length;
      return true;
    }

    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return array[head];
    }

    public int Rear() {
      if (isEmpty()) {
        return -1;
      }
      return array[tail];
    }

    public boolean isEmpty() {
      return head == -1 && tail == -1;
    }

    public boolean isFull() {
      return head == (tail + 1) % array.length;
    }
  }
}
