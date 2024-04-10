package algo.twoPointers

class KtLongestWordInDictionaryThroughDeleting_524 {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        var longestWord = ""
        val sorted = dictionary.sorted()
        sorted.forEach { word ->
            if (word.length > s.length) {
                return@forEach
            }
            var i = 0; var j = 0
            while (i < s.length && j < word.length) {
                if (s[i] == word[j]) {
                    j++
                }
                i++
            }
            // matched
            if (j == word.length) {
                if (word.length > longestWord.length) {
                    longestWord = word
                }
            }
        }
        return longestWord
    }
}