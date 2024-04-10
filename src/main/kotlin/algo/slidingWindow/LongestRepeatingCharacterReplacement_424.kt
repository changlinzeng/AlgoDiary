package algo.slidingWindow

class KtLongestRepeatingCharacterReplacement_424 {
    fun characterReplacement(s: String, k: Int): Int {
        var maxLen = 0
        var left = 0; var right = 0
        val freq: MutableMap<Char, Int> = mutableMapOf()
        while (right < s.length) {
            freq[s[right]] = freq.getOrDefault(s[right], 0) + 1
            val window = right - left + 1
            val maxFreqChar = freq.maxBy { it.value }.key
            if (window - freq[maxFreqChar]!! <= k) {
                maxLen = maxLen.coerceAtLeast(window)
            } else {
                val ch = s[left]
                freq[ch] = freq[ch]!! - 1
                left++
            }
            right++
        }
        return maxLen
    }
}

fun main() {
    val replace = KtLongestRepeatingCharacterReplacement_424()
    println(replace.characterReplacement("ABAB", 2))
    println(replace.characterReplacement("AABABBA", 1))
}