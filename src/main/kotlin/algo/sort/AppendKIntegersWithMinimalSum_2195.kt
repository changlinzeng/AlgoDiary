package algo.sort

class KtAppendKIntegersWithMinimalSum_2195 {
    fun minimalKSum(nums: IntArray, k: Int): Long {
        // fill numbers from 1 till we add k numbers
        nums.sort()
        var count = k  // count of numbers to consume
        var sum: Long = 0
        run loop@ {
            nums.indices.forEach { i ->
                val numsToConsume = if (i == 0) nums[i] - 1 else nums[i] - nums[i - 1] - 1
                val from = if (i == 0) 1 else nums[i - 1] + 1
                var to = nums[i] - 1
                if (numsToConsume <= 0) {
                    return@forEach
                }
                count -= numsToConsume
                if (count < 0) {
                    // restore count
                    count += numsToConsume
                    to = if (i == 0) {
                        k
                    } else {
                        nums[i - 1] + count
                    }
                    // set count to 0 so we will quit
                    count = 0
                }
                sum += (from + to).toLong() * (to - from + 1).toLong() / 2
                if (count == 0) {
                    return@loop
                }
            }
        }

        // need to consume more from the end
        for (i in 1..count) {
            sum += nums.last() + i
        }
        return sum
    }
}

fun main() {
    val append = KtAppendKIntegersWithMinimalSum_2195()
//    println(append.minimalKSum(intArrayOf(1,4,25,10,25), 2))
//    println(append.minimalKSum(intArrayOf(5,6), 6))
//    println(append.minimalKSum(intArrayOf(96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84), 35))
    println(append.minimalKSum(intArrayOf(3), 1))
}