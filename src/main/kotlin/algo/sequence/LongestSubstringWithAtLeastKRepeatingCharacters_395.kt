package algo.sequence

class KtLongestSubstringWithAtLeastKRepeatingCharacters_395 {
    fun longestSubstring(s: String, k: Int): Int {
        // chars whose occurrence less than k can be excluded
        val freq: MutableMap<Char, Int> = mutableMapOf()
        s.forEach { ch ->
            freq[ch] = freq.computeIfAbsent(ch) { 0 } + 1
        }

        val delimiters = freq.filter { it.value < k }.map { it.key }.toTypedArray()
        if (delimiters.isEmpty()) {
            return s.length
        }

        var maxLen = 0
        s.split(Regex(delimiters.joinToString("|")))
            .filter { it.isNotEmpty() }
            .forEach { sub ->
            maxLen = maxLen.coerceAtLeast(longestSubstring(sub, k))
        }

        return maxLen
    }
}

fun main() {
    val substring = KtLongestSubstringWithAtLeastKRepeatingCharacters_395()
    println(substring.longestSubstring("aaabb", 3))
    println(substring.longestSubstring("ababbc", 2))
}