package algo.sequence

class KtCountNumberOfNiceSubarrays_1248 {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val odds: MutableList<Int> = mutableListOf()  // index of odd numbers
        nums.indices.filter { nums[it] % 2 != 0 }.forEach { odds.add(it) }

        var count = 0
        run loop@ {
            odds.indices.forEach { i ->
                val end = i + k - 1
                if (end >= odds.size) {
                    return@loop
                }
                // index of start and end odds in nums
                var m = 1; var n = 1
                m = if (i == 0) {
                    odds[i]
                } else {
                    odds[i] - odds[i - 1] - 1
                }
                n = if (end == odds.size - 1) {
                    nums.size - odds[end] - 1
                } else {
                    odds[end + 1] - odds[end] - 1
                }
                count += (m + 1) * (n + 1)
            }
        }
        return count
    }
}

fun main() {
    val nice = KtCountNumberOfNiceSubarrays_1248()
    println(nice.numberOfSubarrays(intArrayOf(1,1,2,1,1), 3))
}