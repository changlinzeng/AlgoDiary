package algo.interval

import java.util.PriorityQueue

class KtDivideIntervalsIntoMinimumNumberOfGroups_2406 {
    fun minGroups(intervals: Array<IntArray>): Int {
        val pq = PriorityQueue<Int>()  // last interval of each group sorted by end
        intervals.sortWith(compareBy<IntArray> {it[0]}.thenBy { it[1] })

        intervals.forEach {
            val (start, end) = it
            // no overlap between current interval the last interval so we add current interval to last group
            if (pq.isNotEmpty() && pq.peek() < start) {
                pq.poll()
            }
            pq.offer(end)
        }
        return pq.size
    }
}

fun main() {
    val divide = KtDivideIntervalsIntoMinimumNumberOfGroups_2406()
    println(divide.minGroups(arrayOf(intArrayOf(5,10), intArrayOf(6,8), intArrayOf(1,5), intArrayOf(2,3), intArrayOf(1,10))))
}