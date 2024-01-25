package design;

import java.util.LinkedList;
import java.util.Queue;

public class DesignBoundedBlockingQueue_1188 {
  private final int capacity;
  private final Queue<Integer> queue;

  public DesignBoundedBlockingQueue_1188(int capacity) {
    this.capacity = capacity;
    this.queue = new LinkedList<>();
  }

  public synchronized void enqueue(int element) throws InterruptedException {
    while (queue.size() == capacity) {
      queue.wait();
    }
    queue.offer(element);
    queue.notify();
  }

  public synchronized int dequeue() throws InterruptedException {
    while (queue.isEmpty()) {
      queue.wait();
    }
    int result = queue.poll();
    queue.notify();
    return result;
  }

  public synchronized int size() {
    return queue.size();
  }
}
