package design;

public class DesignCircularDeque_641 {

  private final int[] queue;
  private final int size;
  private int head;
  private int tail;

  public DesignCircularDeque_641(int k) {
    this.queue = new int[k];
    size = k;
    head = -1;
    tail = -1;
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    if (isEmpty()) {
      queue[0] = value;
      head = 0;
      tail = 0;
      return true;
    }
    head = (head - 1 + size) % size;
    queue[head] = value;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    if (isEmpty()) {
      queue[0] = value;
      head = 0;
      tail = 0;
      return true;
    }
    tail = (tail + 1) % size;
    queue[tail] = value;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    if (head == tail) {
      head = -1;
      tail = -1;
      return true;
    }
    head = (head + 1) % size;
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    if (head == tail) {
      head = -1;
      tail = -1;
      return true;
    }
    tail = (tail - 1 + size) % size;
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return queue[head];
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return queue[tail];
  }

  public boolean isEmpty() {
    return head == -1 && tail == -1;
  }

  public boolean isFull() {
    return head == (tail + 1) % size;
  }
}
