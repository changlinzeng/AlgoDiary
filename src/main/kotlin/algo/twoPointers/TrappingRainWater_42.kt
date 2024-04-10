package algo.twoPointers

import kotlin.math.min

class KtTrappingRainWater_42 {
    fun trap(height: IntArray): Int {
        // find the max height after i and then calculate from i to max height
        val len = height.size
        val maxHeight = IntArray(len)  // index of max height after i
        var maxH = len - 1
        height.indices.reversed().forEach { i ->
            if (i == len - 1) {
                maxHeight[i] = i
                maxH = len - 1
            } else {
                // update index for max height after i
                maxHeight[i] = maxH
                if (height[i] >= height[maxH]) {
                    maxH = i
                }
            }
        }

        var water = 0
        var from = 0
        while (from < len) {
            val to = maxHeight[from]
            val minH = min(height[from], height[to])
            var idx = from + 1
            while (idx < to && height[idx] < minH) {
                water += minH - height[idx]
                idx++
            }
            from = idx
        }
        return water
    }
}

fun main() {
    val trapping = KtTrappingRainWater_42()
    println(trapping.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}