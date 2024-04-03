package algo.interval

class KtFindRightInterval_436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        // position of each interval start
        var maxStart = 0
        val startPosition: MutableMap<Int, Int> = mutableMapOf()
        intervals.indices.forEach {
            startPosition[intervals[it][0]] = it
            maxStart = maxStart.coerceAtLeast(intervals[it][0])
        }

        val result = IntArray(intervals.size) { -1 }
        intervals.indices.forEach {
            val current = intervals[it]
            // find the smallest start in the map
            for (i in current[1]..maxStart) {
                if (startPosition.containsKey(i)) {
                    result[it] = startPosition[i]!!
                    break
                }
            }
        }
        return result
    }
}