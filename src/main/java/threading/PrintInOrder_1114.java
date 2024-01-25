package threading;

public class PrintInOrder_1114 {
  static class Foo {

    private volatile int signal = 1;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
      while (signal != 1) {
        this.wait();
      }
      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      signal = 2;
      this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
      while (signal != 2) {
        this.wait();
      }
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      signal = 3;
      this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
      while (signal != 3) {
        this.wait();
      }
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }
  }

  public static void main(String[] args) {
    var foo = new Foo();
    new Thread(() -> {
      try {
        foo.first(() -> System.out.println("first"));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
    new Thread(() -> {
      try {
        foo.second(() -> System.out.println("second"));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
    new Thread(() -> {
      try {
        foo.third(() -> System.out.println("third"));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
  }
}
