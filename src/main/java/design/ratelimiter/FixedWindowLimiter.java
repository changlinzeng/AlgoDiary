package design.ratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;

public class FixedWindowLimiter {

    private final int limit;
    private final Duration window;
    private int counter;
    private LocalDateTime lastRequestTime;

    private FixedWindowLimiter(int limit, Duration window) {
        this.limit = limit;
        this.window = window;
    }

    public static FixedWindowLimiter create(int limit, Duration window) {
        return new FixedWindowLimiter(limit, window);
    }

    public boolean tryAcquire(int tokens) {
        var now = LocalDateTime.now();
        if (lastRequestTime == null || Duration.between(lastRequestTime, now).compareTo(window) > 0) {
            // Current window expired. Create a new window
            lastRequestTime = now;
            this.counter = 0;
        }

        // reject request
        if (this.counter + tokens > this.limit) {
            return false;
        }

        this.counter += tokens;
        this.lastRequestTime = now;
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        var limiter = FixedWindowLimiter.create(10, Duration.ofSeconds(1));
        System.out.println(limiter.tryAcquire(11));

        limiter = FixedWindowLimiter.create(10, Duration.ofSeconds(1));
        System.out.println(limiter.tryAcquire(9));

        limiter = FixedWindowLimiter.create(10, Duration.ofSeconds(5));
        System.out.println(limiter.tryAcquire(10));
        Thread.sleep(5 * 1000);
        System.out.println(limiter.tryAcquire(1));
    }
}
