package algo.twoPointers

import kotlin.math.min

class KtTrappingRainWater_42 {
    fun trap(height: IntArray): Int {
        val len = height.size;
        val leftMax = IntArray(len)
        var maxIdx = 0
        (1..<len).forEach { i ->
            if (height[i] > height[maxIdx]) {
                maxIdx = i
            }
            leftMax[i] = maxIdx
        }

        val rightMax = IntArray(len)
        rightMax[len - 1] = len - 1
        maxIdx = len - 1
        (len - 2 downTo 0).forEach { i ->
            if (height[i] > height[maxIdx]) {
                maxIdx = i
            }
            rightMax[i] = maxIdx
        }

        var trapped = 0
        (1..<len - 1).forEach { i ->
            val water = min(height[leftMax[i]], height[rightMax[i]]) - height[i]
            trapped += water
        }
        return trapped
    }
}

fun main() {
    val trapping = KtTrappingRainWater_42()
    println(trapping.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}