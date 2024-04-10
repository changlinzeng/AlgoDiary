package algo.slidingWindow

class KtMaxConsecutiveOnes_III_1004 {
    /**
     * the same as KtLongestRepeatingCharacterReplacement_424
     */
    fun longestOnes(nums: IntArray, k: Int): Int {
        var oneCount = 0
        var left = 0; var right = 0
        var maxLen = 0
        while (right < nums.size) {
            if (nums[right] == 1) {
                oneCount++
            }
            val window = right - left + 1
            if (window - oneCount <= k) {
                maxLen = maxLen.coerceAtLeast(right - left + 1)
            } else {
                while ((right - left + 1) - oneCount > k) {
                    if (nums[left] == 1) {
                        oneCount--
                    }
                    left++
                }
            }
            right++
        }
        return maxLen
    }
}

fun main() {
    val ones = KtMaxConsecutiveOnes_III_1004()
    println(ones.longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2))
}