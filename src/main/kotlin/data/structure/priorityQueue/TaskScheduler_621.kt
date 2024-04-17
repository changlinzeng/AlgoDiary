package data.structure.priorityQueue

import java.util.ArrayList
import java.util.PriorityQueue
import kotlin.math.min

class KtTaskScheduler_621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val interval = n + 1
        val count = IntArray(26)
        val pq = PriorityQueue<Char> { a, b -> count[b - 'A'] - count[a - 'A'] }

        tasks.forEach { count[it - 'A']++ }
        count.indices.filter { count[it] > 0 }.forEach { pq.offer('A'.plus(it)) }

        var units = 0
        while (pq.isNotEmpty()) {
            val num = min(interval, pq.size)
            val list = ArrayList<Char>()
            for (i in 1..num) {
                val task = pq.poll()
                count[task - 'A']--
                if (count[task - 'A'] > 0) {
                    list.add(task)
                }
            }
            if (list.isNotEmpty()) {
                units += interval
                list.forEach { pq.offer(it) }
            } else {
                units += num
            }
        }
        return units
    }
}

fun main() {
    val scheduler = KtTaskScheduler_621()
    println(scheduler.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
    println(scheduler.leastInterval(charArrayOf('A', 'C', 'A', 'B', 'D', 'B'), 1))
}