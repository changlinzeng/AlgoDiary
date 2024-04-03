package algo.depthFirstSearch

import kotlin.contracts.contract

class KtWildcardMatching_44 {
    fun isMatch(s: String, p: String): Boolean {
        fun match(s: String, p: String, sIndex: Int, pIndex: Int, dp: Array<IntArray>): Int {
            if (s == "") {
                return if (p == "*" || p == "") 1 else 0
            }
            if (p == "") {
                return -1
            }
            if (dp[sIndex][pIndex] != 0) {
                return dp[sIndex][pIndex]
            }
            val sLen = s.length; val pLen = p.length
            var i = sIndex; var j = pIndex
            while (i < sLen && j < pLen) {
                val sChar = s[i]; val pChar = p[j]
                if (pChar == '*') {
                    if (j == pLen - 1) {
                        // pattern ends with '*' so it matches from current till end
                        dp[sIndex][pIndex] = 1
                        return 1
                    } else {
                        for (k in i..<sLen) {
                            // match the char after '*'
                            if (s[k] == p[j + 1] || p[j + 1] == '?') {
                                val res = match(s, p, k, j + 1, dp)
                                dp[k][j + 1] = res
                                if (res == 1) {
                                    return 1
                                }
                            }
                        }
                    }
                }
                if (pChar != '?' && sChar != pChar) {
                    dp[sIndex][pIndex] = -1
                    return -1
                }
                i++
                j++
            }
            if (i == sLen && (j == pLen || j == pLen - 1 && p[j] == '*')) {
                dp[sIndex][pIndex] = 1
            } else {
                dp[sIndex][pIndex] = -1
            }
            return dp[sIndex][pIndex]
        }

        // remove consecutive '*' in pattern
        var pattern = ""
        p.indices.forEach { i ->
            if (i == 0 || p[i] != '*' || p[i] == '*' && p[i - 1] != '*') {
                pattern += p[i]
            }
        }
        return match(s, pattern, 0, 0, Array(s.length) { IntArray(p.length) {0} }) == 1
    }
}

fun main() {
    val match = KtWildcardMatching_44()
    println(match.isMatch("aa", "a"))
    println(match.isMatch("aa", "*"))
    println(match.isMatch("cb", "?a"))
    println(match.isMatch("aa", "aaa"))
    println(match.isMatch("aabbcc", "a?*b"))
    println(match.isMatch("adceb", "*a*b"))
}