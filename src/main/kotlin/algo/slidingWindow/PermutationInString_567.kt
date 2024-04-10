package algo.slidingWindow

import algo.backtrack.KtPermutations_II_47

class KtPermutationInString_567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) {
            return false
        }
        val base = IntArray(26)
        s1.forEach { base[it - 'a']++ }

        val count = IntArray(26)
        for (i in s1.indices) {
            count[s2[i] - 'a']++
        }
        for (i in s1.length - 1..<s2.length) {
            if (i > s1.length - 1) {
                count[s2[i] - 'a']++
                count[s2[i - s1.length] - 'a']--
            }
            // check permutation
            var isPermutation = true
            for (k in 0..25) {
                if (base[k] != count[k]) {
                    isPermutation = false
                    break
                }
            }
            if (isPermutation) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val permutation = KtPermutationInString_567()
    println(permutation.checkInclusion("ab", "eidbaooo"))
}