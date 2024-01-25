package design.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowLimiter {
    private final int limit;
    private final Duration window;
    private final List<Request> requests;

    private SlidingWindowLimiter(int limit, Duration window) {
        this.limit = limit;
        this.window = window;
        this.requests = new ArrayList<>();
    }

    public static SlidingWindowLimiter create(int limit, Duration window) {
        return new SlidingWindowLimiter(limit, window);
    }

    public boolean tryAcquire(int tokens) {
        var now = Instant.now();
        var windowStart = now.minus(this.window);

        // remove requests before the window start
        requests.removeIf(r -> r.timestamp.compareTo(windowStart) < 0);

        var total = requests.stream().map(r -> r.requests).reduce(Integer::sum).orElse(0);
        if (total + tokens > this.limit) {
            return false;
        }

        for (var i = 0; i < tokens; i++) {
            requests.add(new Request(Instant.now(), 1));
        }

        return true;
    }

    private record Request(Instant timestamp, int requests) { }

    public static void main(String[] args) throws InterruptedException {
        var limiter = SlidingWindowLimiter.create(10, Duration.ofSeconds(5));
        var count = 1;
        while (true) {
            System.out.println((count++) + " - " + limiter.tryAcquire(2));
            Thread.sleep(500);
        }
    }
}
