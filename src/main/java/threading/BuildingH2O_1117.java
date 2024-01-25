package threading;

import java.util.concurrent.Semaphore;

public class BuildingH2O_1117 {

  static class H2O {
    private volatile int n;
    private final Semaphore h;
    private final Semaphore o;
    private final Object lock;
    private volatile int count = 3;
    public H2O() {
      this.n = 2;
      this.h = new Semaphore(2);
      this.o = new Semaphore(1);
      this.lock = new Object();
    }

    public H2O(int n) {
      this.n = n;
      this.h = new Semaphore(2);
      this.o = new Semaphore(1);
      this.lock = new Object();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
      while (this.n > 0) {
        if (count == 0) {
          synchronized (lock) {
//            System.out.println("notify from H");
            lock.notifyAll();
            this.n--;
            count = 3;
          }
          continue;
        }
        if (h.tryAcquire()) {
          synchronized (lock) {
            count--;
//            System.out.println("wait H");
            lock.wait();
          }
          // releaseHydrogen.run() outputs "H". Do not change or remove this line.
          releaseHydrogen.run();
          h.release();
        }
      }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
      while (this.n > 0) {
        if (count == 0) {
          synchronized (lock) {
//            System.out.println("notify from O");
            lock.notifyAll();
            this.n--;
            count = 3;
          }
          continue;
        }
        if (o.tryAcquire()) {
          synchronized (lock) {
            count--;
//            System.out.println("wait O");
            lock.wait();
          }
          // releaseOxygen.run() outputs "O". Do not change or remove this line.
          releaseOxygen.run();
          o.release();
        }
      }
    }
  }

  public static void main(String[] args) {
    var water = new H2O(10);
    for (var i = 0; i < 3; i++) {
      new Thread(() -> {
        try {
          water.hydrogen(() -> {System.out.print("H");});
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();
      new Thread(() -> {
        try {
          water.oxygen(() -> {System.out.print("O");});
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();
    }
  }
}
