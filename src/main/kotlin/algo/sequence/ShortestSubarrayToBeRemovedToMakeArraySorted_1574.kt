package algo.sequence

class KtShortestSubarrayToBeRemovedToMakeArraySorted_1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val len = arr.size
        var left = 0; var right = len - 1

        // find left ascending arr
        while (left < len - 1 && arr[left] <= arr[left + 1]) {
            left++
        }

        // already sorted
        if (left == len - 1) {
            return 0
        }

        // find right descending arr
        while (right > left && arr[right - 1] <= arr[right]) {
            right--
        }

        var start = 0
        // either we remove the left side or the right side
        var min = right.coerceAtMost(len - left - 1)
        // remove the subarray between left and right
        while (start <= left && right < len) {
            if (arr[start] <= arr[right]) {
                min = min.coerceAtMost(right - start - 1)
                start++
            } else {
                right++
            }
        }
        return min
    }
}