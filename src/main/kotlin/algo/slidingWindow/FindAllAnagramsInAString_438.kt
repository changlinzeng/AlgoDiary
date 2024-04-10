package algo.slidingWindow

class KtFindAllAnagramsInAString_438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val starts: MutableList<Int> = mutableListOf()
        if (p.length > s.length) {
            return starts
        }

        val base = IntArray(26)
        p.forEach { base[it - 'a']++ }

        val count = IntArray(26)
        s.indices.forEach { i ->
            val ch = s[i]
            if (i < p.length) {
                count[ch - 'a']++
            } else {
                if (isAnagram(base, count)) {
                    starts.add(i - p.length)
                }
                count[ch - 'a']++
                count[s[i - p.length] - 'a']--
            }
        }
        if (isAnagram(base, count)) {
            starts.add(s.length - p.length)
        }
        return starts
    }

    private fun isAnagram(a: IntArray, b: IntArray): Boolean {
        for (j in a.indices) {
            if (a[j] != b[j]) {
                return false
            }
        }
        return true

    }
}

fun main() {
    val anagram = KtFindAllAnagramsInAString_438()
    println(anagram.findAnagrams("cbaebabacd", "abc"))
    println(anagram.findAnagrams("abab", "ab"))
}