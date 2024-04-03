package algo.greedy

import java.util.PriorityQueue

class KtCourseSchedule_III_630 {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        var num = 0
        var start = 0  // start time of current course
        val durations = PriorityQueue<Int> {a, b -> b - a}
        val sorted = courses.sortedWith(compareBy({it[1]}, {it[0]}))
        sorted.forEach { c ->
            val (duration, end) = c
            start += duration
            if (start <= end) {
                num++
                durations.offer(duration)
            } else {
                // remove the last course with the longest duration and add current one
                if (durations.isNotEmpty() && durations.peek() > duration) {
                    val lastDuration = durations.poll()
                    start -= lastDuration
                    durations.offer(duration)
                } else {
                    // remove current course
                    start -= duration
                }
            }
        }
        return num
    }
}

fun main() {
    val schedule = KtCourseSchedule_III_630()
    println(schedule.scheduleCourse(arrayOf(intArrayOf(5,5), intArrayOf(4,6), intArrayOf(2,6))))
}