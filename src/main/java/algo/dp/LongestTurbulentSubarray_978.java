package algo.dp;

public class LongestTurbulentSubarray_978 {
  public static int maxTurbulenceSize(int[] arr) {
    if (arr.length < 2) {
      return arr.length;
    }

    int len = arr.length, max = 0, start = 0, i;
    var sign = 1;
    while (start < len - 1) {
      i = start + 1;
      if (i >= len) {
        break;
      }
      sign = arr[i] - arr[start];
      if (sign == 0) {
        max = Math.max(max, 1);
        start++;
        continue;
      }
      for (; i < len - 1; i++) {
        if ((arr[i + 1] - arr[i]) * sign >= 0) {
          break;
        }
        sign = arr[i + 1] - arr[i];
      }
      max = Math.max(max, i - start + 1);
      start = i;
    }

    return max;
  }

  public static int maxTurbulenceSize2(int[] arr) {
    //  9  4  2  10  7  8  8  1  9
    //  1  2  2   3  4  5  1  2  3
    int len = arr.length, max = 1, sign = 0;
    var dp = new int[len];
    dp[0] = 1;
    for (var i = 1; i < len; i++) {
      if (arr[i] == arr[i - 1]) {
        dp[i] = 1;
      } else if (arr[i] > arr[i - 1]) {
        if (sign == 0 || sign == 1) {
          dp[i] = 2;
        } else {
          dp[i] = dp[i - 1] + 1;
        }
        sign = 1;
      } else {
        if (sign == 0 || sign == -1) {
          dp[i] = 2;
        } else {
          dp[i] = dp[i - 1] + 1;
        }
        sign = -1;
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxTurbulenceSize2(new int[]{9,4,2,10,7,8,8,1,9}));
    System.out.println(maxTurbulenceSize2(new int[]{4,8,12,16}));
    System.out.println(maxTurbulenceSize2(new int[]{10}));
    System.out.println(maxTurbulenceSize2(new int[]{9,9}));
  }
}
