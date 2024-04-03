package algo.interval

class KtCarPooling_1094 {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val trip: MutableMap<Int, Int> = mutableMapOf()
        trips.forEach { t ->
            var p = trip.getOrPut(t[1]) { 0 }
            trip[t[1]] = p + t[0]  // take passengers
            p = trip.getOrPut(t[2]) { 0 }
            trip[t[2]] = p - t[0]  // drop passengers
        }
        val sorted = trip.toSortedMap()
        var load = 0
        sorted.forEach { (_, v) ->
            load += v
            if (load > capacity) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val pooling = KtCarPooling_1094()
//    println(pooling.carPooling(arrayOf(intArrayOf(2,1,5), intArrayOf(3,3,7)), 4))
    println(pooling.carPooling(arrayOf(intArrayOf(4,5,6), intArrayOf(6,4,7), intArrayOf(4,3,5), intArrayOf(2,3,5)), 13))
}