package algo.twoPointers;

public class CompareVersionNumbers_165 {
  public static int compareVersion(String version1, String version2) {
    var v1 = version1.split("\\.");
    var v2 = version2.split("\\.");
    int len1 = v1.length, len2 = v2.length;
    var len = Math.max(len1, len2);
    for (var i = 0; i < len; i++) {
      var n1 = 0;
      if (i < len1) {
        n1 = Integer.parseInt(v1[i]);
      }
      var n2 = 0;
      if (i < len2) {
        n2 = Integer.parseInt(v2[i]);
      }
      if (n1 < n2) {
        return -1;
      } else if (n1 > n2) {
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("0.1", "1.1"));
  }
}
