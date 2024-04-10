package algo.slidingWindow;

public class TakeKOfEachCharacterFromLeftAndRight_2516 {
    public static int takeCharacters(String s, int k) {
        var count = new int[]{-1 * k, -1 * k, -1 * k};
        for (var i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        if (count[0] < 0 || count[1] < 0 || count[2] < 0) {
            return -1;
        }
        if (count[0] == 0 && count[1] == 0 && count[2] == 0) {
            return s.length();
        }

        var maxLen = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            var c = s.charAt(right);
            count[c - 'a']--;
            while (left < right && (count[0] < 0 || count[1] < 0 || count[2] < 0)) {
                count[s.charAt(left) - 'a']++;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return s.length() - maxLen;
    }

    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
        System.out.println(takeCharacters("a", 0));
        System.out.println(takeCharacters("abc", 1));
    }
}
