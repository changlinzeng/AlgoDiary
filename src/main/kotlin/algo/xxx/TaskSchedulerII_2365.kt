package algo.xxx

class KtTaskSchedulerII_2365 {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        val lastTaskPosition: MutableMap<Int, Int> = mutableMapOf()  // last position of each task type
        val spaces = LongArray(tasks.size)  // spaces added before task i
        tasks.indices.forEach { i ->
            val task = tasks[i]
            if (i > 0 && lastTaskPosition.containsKey(task)) {
                val lastTask = lastTaskPosition[task]!!
                var daysBetween = (i - lastTask - 1).toLong()
                for (j in i - 1 downTo lastTask + 1) {
                    daysBetween += spaces[j]
                }
                // add spaces before i
                if (daysBetween < space) {
                    spaces[i] = space - daysBetween
                }
            }
            lastTaskPosition[task] = i
        }
        return tasks.size + spaces.sum()
    }
}

fun main() {
    val scheduler = KtTaskSchedulerII_2365()
    println(scheduler.taskSchedulerII(intArrayOf(1,2,1,2,3,1), 3))
}