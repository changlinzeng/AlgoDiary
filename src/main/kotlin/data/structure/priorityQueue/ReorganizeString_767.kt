package data.structure.priorityQueue

import java.util.PriorityQueue

class KtReorganizeString_767 {
    fun reorganizeString(s: String): String {
        val count = IntArray(26)
        val pq = PriorityQueue<Char> { a, b -> count[b - 'a'] - count[a - 'a'] }

        s.forEach { count[it - 'a']++ }
        count.indices.filter { count[it]> 0 }.forEach { pq.offer(('a'.plus(it))) }

        var result = ""
        while (pq.isNotEmpty()) {
            val chars = ArrayList<Char>()
            for (i in 0..1) {
                if (pq.isEmpty()) {
                    // not enough chars
                    break
                }
                val ch = pq.poll()
                // now we have adjacent same chars
                if (result != "" && ch == result.last()) {
                    return ""
                }
                result += ch
                count[ch - 'a']--
                if (count[ch - 'a'] > 0) {
                    chars.add(ch)
                }
            }
            chars.forEach { pq.offer(it) }
        }

        return result
    }
}

fun main() {
    val reorganize = KtReorganizeString_767()
    println(reorganize.reorganizeString("aab"))
    println(reorganize.reorganizeString("aaab"))
}