package algo.twoPointers

class KtLongestMountainInArray_845 {
    fun longestMountain(arr: IntArray): Int {
        var start = 0
        var maxLen = 0
        while (start < arr.size - 1) {
            if (arr[start] < arr[start + 1]) {
                // try to find mountain
                var end = start
                while (end < arr.size - 1 && arr[end] < arr[end + 1]) {
                    end++
                }
                if (end == arr.size - 1) {
                    break
                }
                if (arr[end] == arr[end + 1]) {
                    start = end + 1
                    continue
                }
                while (end < arr.size - 1 && arr[end] > arr[end + 1]) {
                    end++
                }
                maxLen = maxLen.coerceAtLeast(end - start + 1)
                start = end
            } else {
                start++
            }
        }
        return maxLen
    }
}

fun main() {
    val mountain = KtLongestMountainInArray_845()
    println(mountain.longestMountain(intArrayOf(2,1,4,7,3,2,5)))
    println(mountain.longestMountain(intArrayOf(0,2,2)))
}