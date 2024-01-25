package threading;

public class PrintFooBarAlternately_1115 {
  static class FooBar {
    private int n;
    private volatile int signal;

    public FooBar(int n) {
      this.n = n;
      this.signal = 1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        while (signal != 1) {
          this.wait();
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        signal = 2;
        this.notify();
      }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
      for (int i = 0; i < n; i++) {
        while (signal != 2) {
          this.wait();
        }
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        signal = 1;
        this.notify();
      }
    }
  }

  public static void main(String[] args) {
    var fb = new FooBar(3);
    new Thread(() -> {
      try {
        fb.foo(() -> {System.out.println("foo");});
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
    new Thread(() -> {
      try {
        fb.bar(() -> {System.out.println("bar");});
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
  }
}
