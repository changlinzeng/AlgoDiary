package algo.monotonicStack;

import java.util.Stack;

public class OnlineStockSpan_901 {
  static class StockSpanner {

    private final Stack<StockSpan> span;

    public StockSpanner() {
      this.span = new Stack<>();
    }

    public int next(int price) {
      var count = 1;
      while (!span.isEmpty() && span.peek().price <= price) {
        count += span.pop().span;
      }
      span.push(new StockSpan(price, count));
      return count;
    }

    private static class StockSpan {
      public int price;
      public int span;
      public StockSpan(int price) {
        this.price = price;
        this.span = 1;
      }
      public StockSpan(int price, int span) {
        this.price = price;
        this.span = span;
      }
    }
  }
}
