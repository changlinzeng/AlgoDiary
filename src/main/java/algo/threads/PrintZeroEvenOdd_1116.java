package algo.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class PrintZeroEvenOdd_1116 {
  private int n;

  private final BlockingQueue<Integer> even;
  private final BlockingQueue<Integer> odd;
  private final BlockingQueue<Integer> zero;
  private final CountDownLatch latch;
  public PrintZeroEvenOdd_1116(int n) {
    this.n = n;
    this.even = new SynchronousQueue<>();
    this.odd = new SynchronousQueue<>();
    this.zero = new SynchronousQueue<>();
    this.latch = new CountDownLatch(3);
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero() throws InterruptedException {
    int count = 0;
    for (;;) {
      if (count < n) {
        System.out.print(0);
      }
      count++;
      if (count > n) {
        even.put(count);
        odd.put(count);
        break;
      }
      if (count % 2 == 0) {
        even.put(count);
      } else {
        odd.put(count);
      }
      zero.take();
    }
    latch.countDown();
  }

  public void even() throws InterruptedException {
    for (;;) {
      var val = even.take();
      if (val > n) {
        break;
      }
      System.out.print(val);
      zero.put(0);
    }
    latch.countDown();
  }

  public void odd() throws InterruptedException {
    for (;;) {
      var val = odd.take();
      if (val > n) {
        break;
      }
      System.out.print(val);
      zero.put(0);
    }
    latch.countDown();
  }

  public void run() throws InterruptedException {
    Thread.startVirtualThread(() -> {
      try {
        zero();
      } catch (Exception ignore) {
      }
    });
    Thread.startVirtualThread(() -> {
      try {
        odd();
      } catch (Exception ignore) {
      }
    });
    Thread.startVirtualThread(() -> {
      try {
        even();
      } catch (Exception ignore) {
      }
    });
    latch.await();
  }

  public static void main(String[] args) throws InterruptedException {
    var print = new PrintZeroEvenOdd_1116(10);
    print.run();
  }
}
