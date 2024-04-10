package algo.slidingWindow

class KtMinimumWindowSubstring_76 {
    fun minWindow(s: String, t: String): String {
        val base = IntArray(58)
        val count = IntArray(58)
        val window = t.length
        if (t.length > s.length) {
            return ""
        }
        t.forEach { ch -> base[ch - 'A']++ }

        var left = 0; var right = 0
        var minWindow = ""
        while (right < s.length) {
            count[s[right] - 'A']++
            if (right >= window - 1) {
                var included = true
                for (i in base.indices) {
                    if (base[i] != 0 && base[i] > count[i]) {
                        included = false
                        break
                    }
                }
                if (included) {
                    // try to shrink the window from left
                    while (base[s[left] - 'A'] == 0 || count[s[left] - 'A'] > base[s[left] - 'A']) {
                        if (count[s[left] - 'A'] > 0) {
                            count[s[left] - 'A'] = count[s[left] - 'A'] - 1
                        }
                        left++
                    }
                    val sub = s.substring(left, right + 1)
                    if (minWindow == "" || sub.length < minWindow.length) {
                        minWindow = sub
                    }
                }
            }
            right++
        }
        return minWindow
    }
}

fun main() {
    val window = KtMinimumWindowSubstring_76()
    println(window.minWindow("ADOBECODEBANC", "ABC"))
    println(window.minWindow("a", "a"))
}