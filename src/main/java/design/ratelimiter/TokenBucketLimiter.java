package design.ratelimiter;

import java.time.Duration;
import java.time.Instant;

public class TokenBucketLimiter {
    private final int limit;
    private int tokens;
    private final int velocity; // number of tokens per second
    private Instant lastUpdateTime;

    private TokenBucketLimiter(int limit, int velocity) {
        this.limit = limit;
        this.velocity = velocity;
        this.lastUpdateTime = Instant.now();
    }

    public static TokenBucketLimiter create(int limit, int velocity) {
        return new TokenBucketLimiter(limit, velocity);
    }

    public synchronized boolean tryAcquire(int requests) {
        var now = Instant.now();
        var interval = Duration.between(this.lastUpdateTime, now);
        if (interval.compareTo(Duration.ofSeconds(1)) > 0) {
            this.tokens = Math.min(this.limit, this.tokens + (int)interval.toSeconds() * this.velocity);
            this.lastUpdateTime = now;
        }

        if (this.tokens < requests) {
            return false;
        }

        this.tokens -= requests;
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        var limiter = TokenBucketLimiter.create(10, 1);
//        Thread.sleep(10 * 1000);
//        System.out.println(limiter.tryAcquire(11));
        while (true) {
            System.out.println(limiter.tryAcquire(2));
            Thread.sleep(1000);
        }
    }
}
