package algo.slidingWindow

class KtTakeKOfEachCharacterFromLeftAndRight_2516 {
    fun takeCharacters(s: String, k: Int): Int {
        val count = intArrayOf(-1 * k, -1 * k, -1 * k)  // upper bound of each char

        s.forEach { c -> count[c - 'a']++ }
        if (count[0] < 0 || count[1] < 0 || count[2] < 0) {
            return -1
        }
        if (count[0] == 0 && count[1] == 0 && count[2] == 0) {
            return s.length;
        }

        var left = 0; var right = 0
        var maxLen = 0
        while (right < s.length) {
            val c = s[right]
            count[c - 'a']--
            while (left < right && (count[0] < 0 || count[1] < 0 || count[2] < 0)) {
                // shrink the window from left
                count[s[left] - 'a']++
                left++
            }
            maxLen = maxLen.coerceAtLeast(right - left + 1)
            right++
        }
        return s.length - maxLen
    }
}

fun main() {
    val take = KtTakeKOfEachCharacterFromLeftAndRight_2516()
    println(take.takeCharacters("aabaaaacaabc", 2))
    println(take.takeCharacters("a", 0))
    println(take.takeCharacters("abc", 1))
}