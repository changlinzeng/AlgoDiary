package algo.palindrome

class KtPalindromicSubstrings_647 {
    fun countSubstrings(s: String): Int {
        // end index of palindrome ends at i -> start indices of all palindromes
        val palindrome: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val dp = IntArray(s.length)
        s.indices.forEach { i ->
            palindrome.getOrPut(i) { mutableListOf() }.add(i)
            dp[i]++

            // check if we can make palindrome by adding chars around idx to i - 1
            if (i > 0) {
                palindrome[i - 1]?.filter { it > 0 }?.forEach { idx ->
                    if (s[i] == s[idx - 1]) {
                        palindrome[i]?.add(idx - 1)
                        dp[i]++
                    }
                }
            }

            // check if we can make palindrome by adding s[i] to prev palindrome
            palindrome[i - 1]?.forEach check@{ idx ->
                if (palindrome[i]!!.contains(idx)) {
                    return@check
                }
                var isPalindrome = true
                for (k in idx..(idx + (i - idx) / 2)) {
                    if (s[k] != s[i + idx - k]) {
                        isPalindrome = false
                        break
                    }
                }
                if (isPalindrome) {
                    palindrome[i]?.add(idx)
                    dp[i]++
                }
            }
        }
        return dp.sum()
    }
}

fun main() {
    val palindrome = KtPalindromicSubstrings_647()
    println(palindrome.countSubstrings("abc"))
    println(palindrome.countSubstrings("aaa"))
}