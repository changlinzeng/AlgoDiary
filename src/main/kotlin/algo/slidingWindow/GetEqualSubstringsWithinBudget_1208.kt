package algo.slidingWindow

import kotlin.math.absoluteValue

class KtGetEqualSubstringsWithinBudget_1208 {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var left = 0; var right = 0
        var cost = 0
        var maxLen = 0
        while (right < s.length) {
            cost += (t[right] - s[right]).absoluteValue
            if (cost <= maxCost) {
                maxLen = maxLen.coerceAtLeast(right - left + 1)
            } else {
                while (left < right && cost > maxCost) {
                    cost -= (t[left] - s[left]).absoluteValue
                    left++
                }
                if (left == right && cost > maxCost) {
                    cost -= (t[left] - s[left]).absoluteValue
                    left++
                }
            }
            right++
        }
        return maxLen
    }
}

fun main() {
    val substring = KtGetEqualSubstringsWithinBudget_1208()
    println(substring.equalSubstring("abcd", "bcdf", 3))
    println(substring.equalSubstring("abcd", "cdef", 3))
    println(substring.equalSubstring("abcd", "acde", 0))
}