package algo.dp;

public class MinimumDeletionsToMakeStringBalanced_1653 {
  public static int minimumDeletions(String s) {
    // if s[i] is 'a' then
    //   if previous pattern is 'aaa...aa', then delete all 'b' from previous pattern
    //   if previous pattern is 'aaa...bb', then delete s[i] on top of previous result
    // if s[i] is 'b', then just count b

    var result = 0;
    var prevResult = 0;
    var bNum = 0;
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (c == 'a') {
        result = Math.min(prevResult + 1, bNum);
        prevResult = result;
      } else {
        bNum++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(minimumDeletions("ab"));
    System.out.println(minimumDeletions("aba"));
    System.out.println(minimumDeletions("abb"));
    System.out.println(minimumDeletions("bba"));
    System.out.println(minimumDeletions("abba"));
    System.out.println(minimumDeletions("aababbab"));
    System.out.println(minimumDeletions("bbaaaaabb"));
  }
}
