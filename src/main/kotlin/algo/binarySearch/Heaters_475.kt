package algo.binarySearch

class KtHeaters_475 {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        // for every house, binary search in heaters to locate the position of the house in heaters
        // and find the nearest heater for the house
        var radius = 0
        houses.sort()
        heaters.sort()
        houses.forEach { house ->
            radius = radius.coerceAtLeast(search(house, heaters))
        }
        return radius
    }

    // find the nearest heater for given house
    private fun search(house: Int, heaters: IntArray): Int {
        var start = 0; var end = heaters.size - 1
        if (house <= heaters[0]) {
            return heaters[0] - house
        }
        if (house >= heaters.last()) {
            return house - heaters.last()
        }
        while (start < end) {
            val mid = start + (end - start) / 2
            if (mid == start) {
                return (house - heaters[start]).coerceAtMost(heaters[end] - house)
            }
            if (heaters[mid] == house) {
                return 0
            } else if (heaters[mid] < house) {
                start = mid
            } else {
                end = mid
            }
        }
        return -1
    }
}

fun main() {
    val heater = KtHeaters_475()
    println(heater.findRadius(intArrayOf(1,2,3), intArrayOf(2)))
    println(heater.findRadius(intArrayOf(1,2,3,4), intArrayOf(1,4)))
    println(heater.findRadius(intArrayOf(1,5), intArrayOf(2)))
}