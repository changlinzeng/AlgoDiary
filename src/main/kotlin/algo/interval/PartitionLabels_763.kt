package algo.interval

class KtPartitionLabels_763 {
    fun partitionLabels(s: String): List<Int> {
        // record the first and last index of each char and then we will get list of intervals
        // merge the overlapped intervals will get the result
        val position: MutableMap<Char, IntArray> = mutableMapOf()
        s.indices.forEach { i ->
            val pos = position.computeIfAbsent(s[i]) { intArrayOf(i, i) }
            pos[1] = i
        }

        val partitions: MutableList<Int> = mutableListOf()
        val intervals = position.values
        var start = -1; var end = -1
        intervals.forEach { interval ->
            if (start == -1 && end == -1) {
                start = interval[0]
                end = interval[1]
            } else {
                val (nextStart, nextEnd) = interval
                if (nextStart < end) {
                    start = start.coerceAtMost(nextStart)
                    end = end.coerceAtLeast(nextEnd)
                } else {
                    partitions.add(end - start + 1)
                    start = interval[0]
                    end = interval[1]
                }
            }
        }
        if (start != -1) {
            partitions.add(end - start + 1)
        }

        return partitions
    }
}
 fun main() {
     val partition = KtPartitionLabels_763()
     println(partition.partitionLabels("ababcbacadefegdehijhklij"))
 }