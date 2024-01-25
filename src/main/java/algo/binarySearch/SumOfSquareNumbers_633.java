package algo.binarySearch;

public class SumOfSquareNumbers_633 {
  public static boolean judgeSquareSum(int c) {
    var sqrt = (int)Math.floor(Math.sqrt(c));
    int a = 0, b = sqrt;

    while (a <= b) {
      long sum = (long) a * a + (long) b * b;
      if (sum == c) {
        return true;
      }
      if (sum > c) {
        b--;
      } else {
        a++;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(judgeSquareSum(5));
    System.out.println(judgeSquareSum(3));
    System.out.println(judgeSquareSum(18));
    System.out.println(judgeSquareSum(4));
    System.out.println(judgeSquareSum(2147483600));
  }
}
