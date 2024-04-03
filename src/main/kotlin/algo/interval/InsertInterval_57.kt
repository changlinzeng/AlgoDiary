package algo.interval

class KtInsertInterval_57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val merged: MutableList<IntArray> = mutableListOf()
        var (newStart, newEnd) = newInterval
        var startIndex = -1; var endIndex = -1
        run loop@ {
            intervals.indices.forEach { i ->
                val interval = intervals[i]
                val (start, end) = interval
                if (start < newStart) {
                    merged.add(interval)
                    startIndex = i
                }
                if (end >= newEnd && endIndex == -1) {
                    endIndex = i
                    return@loop
                }
            }
        }

        if (startIndex != -1) {
            val startInterval = intervals[startIndex]
            // merge with previous interval
            if (newStart <= startInterval[1]) {
                merged.removeLast()
                newStart = startInterval[0]
            }
        }

        if (endIndex != -1) {
            val endInterval = intervals[endIndex]
            // merge with next interval
            if (newEnd >= endInterval[0]) {
                newEnd = endInterval[1]
                endIndex++
            }
        }

        merged.add(intArrayOf(newStart, newEnd))

        if (endIndex != -1) {
            for (i in endIndex..<intervals.size) {
                merged.add(intervals[i])
            }
        }

        return merged.toTypedArray()
    }
}

fun main() {
    val insert = KtInsertInterval_57()
    println(insert.insert(arrayOf(intArrayOf(1,3), intArrayOf(6,9)), intArrayOf(2,5)))
}