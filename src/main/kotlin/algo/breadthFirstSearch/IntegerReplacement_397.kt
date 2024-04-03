package algo.breadthFirstSearch

import java.util.LinkedList

class KtIntegerReplacement_397 {
    fun integerReplacement(n: Int): Int {
        var ops = 0
        val q = LinkedList<Long>()
        q.offer(n.toLong())
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val num = q.poll()
                if (num == 1L) {
                    return ops
                }
                when (num % 2) {
                    0L -> q.offer(num / 2)
                    1L -> {
                        q.offer(num - 1)
                        q.offer(num + 1)
                    }
                }
            }
            ops++
        }
        return -1
    }
}

fun main() {
    val replace = KtIntegerReplacement_397()
    println(replace.integerReplacement(8))
    println(replace.integerReplacement(7))
    println(replace.integerReplacement(4))
}