package algo.breadthFirstSearch

import java.util.LinkedList

class KtWordLadder_127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        fun nextWord(word: String, wordList: List<String>): List<String> {
            val words: MutableList<String> = mutableListOf()
            wordList.forEach { w ->
                var diff = 0
                for (i in w.indices) {
                    if (word[i] != w[i]) {
                        diff++
                    }
                    if (diff > 1) {
                        break
                    }
                }
                if (diff == 1) {
                    words.add(w)
                }
            }
            return words
        }

        var num = 1
        val visited: MutableSet<String> = HashSet()
        val q = LinkedList<String>()
        q.offer(beginWord)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val word = q.poll()
                if (word == endWord) {
                    return num
                }
                if (!visited.add(word)) {
                    continue
                }
                nextWord(word, wordList).forEach { q.offer(it) }
            }
            num++
        }
        return 0
    }
}

fun main() {
    val ladder = KtWordLadder_127()
    println(ladder.ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
}