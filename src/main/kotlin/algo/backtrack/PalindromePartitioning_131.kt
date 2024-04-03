package algo.backtrack

class KtPalindromePartitioning_131 {
    fun partition(s: String): List<List<String>> {
        val all: MutableList<List<String>> = mutableListOf()
        fun backtrack(s: String, list: MutableList<String>) {
            if (s == "") {
                all.add(list.toList())
                return
            }
            for (i in s.indices) {
                if (isPalindrome(s, i)) {
                    list.add(s.substring(0, i + 1))
                    backtrack(s.substring(i + 1), list)
                    list.removeLast()
                }
            }
        }
        backtrack(s, mutableListOf())
        return all
    }

    private fun isPalindrome(str: String, end: Int): Boolean {
        for (i in 0..end / 2) {
            if (str[i] != str[end - i]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val partition = KtPalindromePartitioning_131()
    println(partition.partition("aab"))
    println(partition.partition("a"))
}