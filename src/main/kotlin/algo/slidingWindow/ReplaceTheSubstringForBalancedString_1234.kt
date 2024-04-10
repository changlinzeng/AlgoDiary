package algo.slidingWindow

class KtReplaceTheSubstringForBalancedString_1234 {
    // Find the shortest window so that when we remove the window from the string, the count of all
    // chars are less than total / 4
    fun balancedString(s: String): Int {
        val limit = s.length / 4
        val count: MutableMap<Char, Int> = mutableMapOf()
        s.forEach { ch ->
            count[ch] = count.computeIfAbsent(ch) {0} + 1
        }
        if (count.size == 4 && count.all { entry -> entry.value == limit }) {
            return 0
        }

        var left = 0; var right = 0
        var minLen = Int.MAX_VALUE
        while (right < s.length) {
            count[s[right]] = count[s[right]]!! - 1
            if (count.all { entry -> entry.value <= limit }) {
                minLen = minLen.coerceAtMost(right - left + 1)
                while (left < right) {
                    minLen = minLen.coerceAtMost(right - left + 1)
                    count[s[left]] = count[s[left]]!! + 1
                    left++
                    if (count.any() { entry -> entry.value > limit }) {
                        break
                    }
                }
            }
            right++
        }

        return minLen
    }
}

fun main() {
    val balance = KtReplaceTheSubstringForBalancedString_1234()
    println(balance.balancedString("QWER"))
    println(balance.balancedString("QQWE"))
    println(balance.balancedString("QQQW"))
}