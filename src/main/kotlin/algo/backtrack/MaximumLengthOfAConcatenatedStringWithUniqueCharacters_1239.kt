package algo.backtrack

class KtMaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239 {
    fun maxLength(arr: List<String>): Int {
        var maxLen = Int.MIN_VALUE
        fun canAdd(str: String, visited: BooleanArray): Boolean {
            val count = IntArray(26)
            str.forEach {
                if (visited[it - 'a']) {
                    return false
                }
                if (count[it - 'a'] > 0) {
                    return false
                }
                count[it - 'a']++
            }
            return true
        }

        fun backtrack(arr: List<String>, start: Int, visited: BooleanArray) {
            if (start == arr.size) {
                maxLen = maxLen.coerceAtLeast(visited.count { it })
            }
            for (i in start..<arr.size) {
                if (canAdd(arr[i], visited)) {
                    arr[i].forEach {
                        visited[it - 'a'] = true
                    }
                    backtrack(arr, i + 1, visited)

                    // revert
                    arr[i].forEach {
                        visited[it - 'a'] = false
                    }
                    backtrack(arr, i + 1, visited)
                } else {
                    backtrack(arr, i + 1, visited)
                }
            }
        }

        backtrack(arr, 0, BooleanArray(26))
        return maxLen
    }
}

fun main() {
    val maxLen = KtMaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239()
    println(maxLen.maxLength(listOf("un","iq","ue")))
}