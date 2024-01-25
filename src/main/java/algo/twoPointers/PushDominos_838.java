package algo.twoPointers;

public class PushDominos_838 {
  public static String pushDominoes(String dominoes) {
    int len = dominoes.length();
    int start = -1, end = -1;
    var chars = new char[len + 2];

    chars[0] = 'L';
    for (int i = 0; i < len; i++) {
      chars[i + 1] = dominoes.charAt(i);
    }
    chars[len + 1] = 'R';

    // find dominoes that are not pushed
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '.') {
        if (start == -1) {
          start = i;
        }
        end = i;
      } else {
        // now we determine the status for unpushed dominoes
        if (start != -1) {
          var left = start - 1 >=0 ? chars[start - 1] : 'L';
          var right = end + 1 < chars.length ? chars[end + 1] : 'R';
          if (left == 'L' && right == 'R') {
            // no impact to the status
          } else if (left == 'L' && right == 'L') {
            for (int j = start; j <= end; j++) {
              chars[j] = 'L';
            }
          } else if (left == 'R' && right == 'R') {
            for (int j = start; j <= end; j++) {
              chars[j] = 'R';
            }
          } else if (left == 'R' && right == 'L') {
            for (int j = start, k = end; j < k; j++, k--) {
              chars[j] = 'R';
              chars[k] = 'L';
            }
          }
        }

        start = -1;
      }
    }

    return new String(chars).substring(1, chars.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(pushDominoes("RR.L"));
    System.out.println(pushDominoes(".L.R...LR..L.."));
    System.out.println(pushDominoes("L.R...RLR..L..L"));
    System.out.println(pushDominoes("L.R...RLR...L..L"));
    System.out.println(pushDominoes(".L.R."));
    System.out.println(pushDominoes("..R.."));
  }
}
