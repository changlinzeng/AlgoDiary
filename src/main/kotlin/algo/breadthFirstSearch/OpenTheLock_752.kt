package algo.breadthFirstSearch

import java.lang.StringBuilder
import java.util.LinkedList

class KtOpenTheLock_752 {
    fun openLock(deadends: Array<String>, target: String): Int {
        fun nextStates(state: String, deadends: Set<String>): Set<String> {
            val states: MutableSet<String> = mutableSetOf()
            for (i in state.indices) {
                when (state[i]) {
                    '0' -> {
                        val sb1 = StringBuilder(state)
                        sb1.setCharAt(i, '1')
                        states.add(sb1.toString())
                        sb1.setCharAt(i, '9')
                        states.add(sb1.toString())
                    }
                    '9' -> {
                        val sb1 = StringBuilder(state)
                        sb1.setCharAt(i, '0')
                        states.add(sb1.toString())
                        sb1.setCharAt(i, '8')
                        states.add(sb1.toString())
                    }
                    else -> {
                        val sb1 = StringBuilder(state)
                        sb1.setCharAt(i, state[i] - 1)
                        states.add(sb1.toString())
                        sb1.setCharAt(i, state[i] + 1)
                        states.add(sb1.toString())
                    }
                }
            }
            return states.filter { !deadends.contains(it) }.toSet()
        }

        if (target == "0000") {
            return 0
        }
        if (deadends.contains(target)) {
            return -1
        }

        var steps = 1
        val visited: MutableSet<String> = mutableSetOf()
        val q = LinkedList<String>()
        q.offer("0000")
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val e = q.poll()
                if (!visited.add(e)) {
                    continue
                }
                if (deadends.contains(e)) {
                    continue
                }
                val next = nextStates(e, deadends.toSet())
                if (next.contains(target)) {
                    return steps
                }
                next.filter { !visited.contains(it) }.forEach { q.offer(it) }
            }
            steps++
        }

        return -1
    }
}

fun main() {
    val openLock = KtOpenTheLock_752()
    println(openLock.openLock(arrayOf("0201","0101","0102","1212","2002"), "0202"))
    println(openLock.openLock(arrayOf("8888"), "0009"))
    println(openLock.openLock(arrayOf("8887","8889","8878","8898","8788","8988","7888","9888"), "8888"))
}