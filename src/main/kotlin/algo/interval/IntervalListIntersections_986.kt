package algo.interval

class KtIntervalListIntersections_986 {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val intersections: MutableList<IntArray> = mutableListOf()
        var i = 0; var j = 0
        while (i < firstList.size && j < secondList.size) {
            val first = firstList[i]
            val second = secondList[j]
            val start = first[0].coerceAtLeast(second[0])
            val end = first[1].coerceAtMost(second[1])
            // there is intersection
            if (start <= end) {
                intersections.add(intArrayOf(start, end))
            }

            if (first[1] <= second[1]) {
                i++
            } else {
                j++
            }
        }
        return intersections.toTypedArray()
    }
}