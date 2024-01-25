package algo.binarySearch;

public class NthDigit_400 {
  public static int findNthDigit(int n) {
    int remain = n;
    int digitsNumber = 9;
    int digits = 1;

    int lastDigitsNumber = digitsNumber;
    while (remain - digits >= 0) {
      remain -= digits;
      digitsNumber--;
      if (digitsNumber == 0) {
        digits++;
        digitsNumber = lastDigitsNumber * 10;
        lastDigitsNumber = digitsNumber;
      }
    }

    int current = 1;
    for (int i = 0; i < digits; i++) {
      current *= 10;
    }
    current = current - digitsNumber;

    if (remain == 0) {
      current--;
      return current % 10;
    }
    return String.valueOf(current).charAt(remain - 1) - '0';
  }

  public static void main(String[] args) {
    System.out.println(findNthDigit(3));
    System.out.println(findNthDigit(10)); //  1
    System.out.println(findNthDigit(11)); //  0
    System.out.println(findNthDigit(12)); //  1
    System.out.println(findNthDigit(13)); //  1
    System.out.println(findNthDigit(14)); //  1
    System.out.println(findNthDigit(15)); //  2
    System.out.println(findNthDigit(16)); //  1
    System.out.println(findNthDigit(17)); //  3
    System.out.println(findNthDigit(189)); //  9
    System.out.println(findNthDigit(190)); //  1
  }
}
