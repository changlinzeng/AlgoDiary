package algo.twoPointers;

public class SwapAdjacentInLRString_777 {
  public static boolean canTransform(String start, String end) {
    if (start.length() == 1) {
      return start.equals(end);
    }
    var len = start.length();
    var startArr = start.toCharArray();
    var i = 0;
    while (i < len) {
      if (startArr[i] == end.charAt(i)) {
        i++;
        continue;
      }
      switch (end.charAt(i)) {
        case 'R' -> {
          // if target is 'R', start is 'X' or 'L', we could not make swap to make it 'R'
          return false;
        }
        case 'L' -> {
          if (startArr[i] == 'R') {
            return false;
          }
          // start[i] is 'X' so we find the first 'L' to the right and swap
          // e.g. XXXXXL
          var j = i + 1;
          while (j < len && startArr[j] == 'X') {
            j++;
          }
          if (j == len || startArr[j] != 'L') {
            return false;
          }
          startArr[j] = 'X';
        }
        case 'X' -> {
          if (startArr[i] == 'L') {
            return false;
          }
          // start[i] is 'R', find the first 'X' to the right and swap
          // e.g. RRRRX
          var j = i + 1;
          while (j < len && startArr[j] == 'R') {
              j++;
            }
          if (j == len || startArr[j] != 'X') {
            return false;
          }
          startArr[j] = 'R';
        }
      }
      i++;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    System.out.println(canTransform("R", "L"));
  }
}
