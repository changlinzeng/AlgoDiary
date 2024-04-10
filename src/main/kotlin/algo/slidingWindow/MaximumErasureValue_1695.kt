package algo.slidingWindow

class KtMaximumErasureValue_1695 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var maxScore = 0; var score = 0
        var left = 0; var right = 0
        val count: MutableSet<Int> = mutableSetOf()
        while (right < nums.size) {
            if (count.add(nums[right])) {
                score += nums[right]
                maxScore = maxScore.coerceAtLeast(score)
            } else {
                while (left < right && nums[left] != nums[right]) {
                    count.remove(nums[left])
                    score -= nums[left]
                    left++
                }
                left++
            }
            right++
        }
        return maxScore
    }
}

fun main() {
    val eraser = KtMaximumErasureValue_1695()
    println(eraser.maximumUniqueSubarray(intArrayOf(4,2,4,5,6)))
    println(eraser.maximumUniqueSubarray(intArrayOf(5,2,1,2,5,2,1,2,5)))
}