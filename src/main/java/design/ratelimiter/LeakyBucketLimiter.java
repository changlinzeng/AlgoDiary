package design.ratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;

public class LeakyBucketLimiter {
    private final long limit;
    private long current;
    private final long velocity;
    private LocalDateTime lastUpdateTime;

    public LeakyBucketLimiter(long limit, long velocity) {
        this.limit = limit;
        this.velocity = velocity;
        this.lastUpdateTime = LocalDateTime.now();
    }

    public boolean tryAcquire(int tokens) {
        var now = LocalDateTime.now();
        var interval = Duration.between(now, this.lastUpdateTime);
        this.current = Math.max(0, this.current - interval.toSeconds() * velocity);
        this.lastUpdateTime = now;

        if (tokens + this.current > this.limit) {
            return false;
        }

        this.current += tokens;
        return true;
    }
}
