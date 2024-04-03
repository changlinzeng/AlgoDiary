package algo.backtrack

class KtLetterCombinationsOfAPhoneNumber_17 {
    fun letterCombinations(digits: String): List<String> {
        val all: MutableList<String> = mutableListOf()
        val letterMap: Map<Char, CharArray> = mapOf(
            '2' to charArrayOf('a', 'b', 'c'),
            '3' to charArrayOf('d', 'e', 'f'),
            '4' to charArrayOf('g', 'h', 'i'),
            '5' to charArrayOf('j', 'k', 'l'),
            '6' to charArrayOf('m', 'n', 'o'),
            '7' to charArrayOf('p', 'q', 'r', 's'),
            '8' to charArrayOf('t', 'u', 'v'),
            '9' to charArrayOf('w', 'x', 'y', 'z')
        )
        fun backtrack(digits: String, combination: String) {
            if (digits == "") {
                if (combination != "") {
                    all.add(combination)
                }
                return
            }
            val digit = digits[0]
            letterMap[digit]!!.forEach {
                backtrack(digits.substring(1), "$combination$it")
            }
        }
        backtrack(digits, "")
        return all
    }
}

fun main() {
    val letterCombination = KtLetterCombinationsOfAPhoneNumber_17()
    println(letterCombination.letterCombinations("23"))
    println(letterCombination.letterCombinations(""))
}