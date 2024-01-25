package design.ratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SlidingWindowLimiter_II {
    private final int limit;
    private final Duration window;
    private final Duration bucketLength;
    private final int buckets;
    private final int bucketSize;
    private final int[] counters;
    private LocalDateTime lastUpdateTime;

    public SlidingWindowLimiter_II(int limit, Duration window, Duration bucketSize) {
        if (window.toNanos() % bucketSize.toNanos() != 0) {
            throw new IllegalArgumentException("Invalid bucket size");
        }
        this.limit = limit;
        this.window = window;
        this.bucketLength = bucketSize;
        this.buckets = (int)(this.window.toNanos() / bucketSize.toNanos());
        this.bucketSize = this.limit / this.buckets;
        this.counters = new int[this.buckets];
    }

    public boolean tryAcquire(int tokens) {
        if (this.lastUpdateTime == null) {
            if (tokens <= this.bucketSize) {
                counters[0] += tokens;
                this.lastUpdateTime = LocalDateTime.now();
                return true;
            } else {
                return false;
            }
        }

        var now = LocalDateTime.now();

        // calculate how many buckets are expired
        var expired = Duration.between(now, this.lastUpdateTime).toNanos() / this.bucketLength.toNanos();
        for (var i = 0; i < expired; i++) {
            counters[i] = 0;
        }

        // get total counts
        var total = Arrays.stream(counters).sum();

        if (total + tokens <= this.limit && tokens <= this.bucketSize) {
            counters[this.buckets - 1] += tokens;
            this.lastUpdateTime = now;
            return true;
        }
        return false;
    }
}
