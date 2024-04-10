package algo.slidingWindow

class KtLongestSubstringWithoutRepeatingCharacters_3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val count: MutableSet<Char> = mutableSetOf()
        var left = 0; var right = 0
        var maxLen = 0
        while (right < s.length) {
            val ch = s[right]
            if (!count.add(ch)) {
                while (s[left] != ch) {
                    count.remove(s[left])
                    left++
                }
                left++
            } else {
                maxLen = maxLen.coerceAtLeast(right - left + 1)
            }
            right++
        }
        return maxLen
    }
}

fun main() {
    val substring = KtLongestSubstringWithoutRepeatingCharacters_3()
    println(substring.lengthOfLongestSubstring("abcabcbb"))
    println(substring.lengthOfLongestSubstring("bbbbb"))
    println(substring.lengthOfLongestSubstring("pwwkew"))
}