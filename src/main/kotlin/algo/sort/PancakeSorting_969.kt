package algo.sort

class KtPancakeSorting_969 {
    fun pancakeSort(arr: IntArray): List<Int> {
        // for [0, i], swap the max val to the end
        var max = arr.size
        val result: MutableList<Int> = mutableListOf()
        for (i in arr.size - 1 downTo 1) {
            for (j in 0..<i) {
                // swap max to head if it is not the last one
                if (arr[j] == max) {
                    reverse(arr, j)
                    result.add(j + 1)

                    // swap max to end
                    reverse(arr, i)
                    result.add(i + 1)
                    break
                }
            }
            max--
        }
        return result
    }

    private fun reverse(arr: IntArray, end: Int) {
        var left = 0; var right = end
        while (left < right) {
            val tmp = arr[left]
            arr[left] = arr[right]
            arr[right] = tmp
            left++
            right--
        }
    }
}

fun main() {
    val pancake = KtPancakeSorting_969()
    println(pancake.pancakeSort(intArrayOf(3,2,4,1)))
}