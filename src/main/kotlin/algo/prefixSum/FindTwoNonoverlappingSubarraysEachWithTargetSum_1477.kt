package algo.prefixSum

class KtFindTwoNonoverlappingSubarraysEachWithTargetSum_1477 {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        // find subarray before i from start to end
        val prefixSum: MutableMap<Int, Int> = mutableMapOf()  // prefix sum -> index
        val prefixArr = IntArray(arr.size)  // min length of subarray with sum = target before index i
        var sum = 0
        for (i in arr.indices) {
            sum += arr[i]
            prefixSum[sum] = i
            if (sum == target) {
                prefixArr[i] = i + 1
            } else {
                if (prefixSum.containsKey(sum - target) && prefixSum[sum - target]!! < i) {
                    if (prefixArr[i - 1] > 0) {
                        prefixArr[i] = prefixArr[i - 1].coerceAtMost(i - prefixSum[sum - target]!!)
                    } else {
                        prefixArr[i] = i - prefixSum[sum - target]!!
                    }
                } else {
                    if (i > 0) {
                        prefixArr[i] = prefixArr[i - 1]
                    }
                }
            }
        }

        // find subarray after i from end to start
        sum = 0
        val suffixSum: MutableMap<Int, Int> = mutableMapOf()  // prefix sum -> index
        val suffixArr = IntArray(arr.size)  // min length of subarray with sum = target before index i
        for (i in arr.size - 1 downTo 0) {
            sum += arr[i]
            suffixSum[sum] = i
            if (sum == target) {
                suffixArr[i] = arr.size - i
            } else {
                if (suffixSum.containsKey(sum - target) && suffixSum[sum - target]!! > i) {
                    if (suffixArr[i + 1] > 0) {
                        suffixArr[i] = suffixArr[i + 1].coerceAtMost(suffixSum[sum - target]!! - i)
                    } else {
                        suffixArr[i] = suffixSum[sum - target]!! - i
                    }
                } else {
                    if (i < arr.size - 1) {
                        suffixArr[i] = suffixArr[i + 1]
                    }
                }
            }
        }

        var minLengthSum = Int.MAX_VALUE
        for (idx in 0..<prefixArr.size - 1) {
            if (prefixArr[idx] > 0 && suffixArr[idx + 1] > 0) {
                minLengthSum = minLengthSum.coerceAtMost(prefixArr[idx] + suffixArr[idx + 1])
            }
        }
        return if (minLengthSum == Int.MAX_VALUE) -1 else minLengthSum
    }
}

fun main() {
    val subarray = KtFindTwoNonoverlappingSubarraysEachWithTargetSum_1477()
    println(subarray.minSumOfLengths(intArrayOf(3,2,2,4,3), 3))
    println(subarray.minSumOfLengths(intArrayOf(7,3,4,7), 7))
    println(subarray.minSumOfLengths(intArrayOf(4,3,2,6,2,3,4), 6))
    println(subarray.minSumOfLengths(intArrayOf(1,1,1,2,2,2,4,4), 6))
    println(subarray.minSumOfLengths(intArrayOf(61,2,11,39,13,1,5,11,3,2,15,32,7,14,2,3,1,18,13,26,11,5,1,21,21), 74))
}