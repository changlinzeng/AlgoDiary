package algo.sort

class KtLargestNumber_179 {
    fun largestNumber(nums: IntArray): String {
        // compare number in alphabetic order
        val str = nums.map { it.toString() }.sortedWith(object: Comparator<String> {
            override fun compare(s1: String?, s2: String?): Int {
                var i = 0
                val ss1 = s1 + s2; val ss2 = s2 + s1
                while (i < ss1.length) {
                    if (ss1[i] != ss2[i]) {
                        return ss2[i] - ss1[i]
                    }
                    i++
                }
                return 0
            }
        }).joinToString("")

        return if (str.first() == '0' && str.last() == '0') {
            "0"
        } else {
            str
        }
    }
}

fun main() {
    val largest = KtLargestNumber_179()
    println(largest.largestNumber(intArrayOf(10, 2)))
    println(largest.largestNumber(intArrayOf(3,30,34,5,9)))
}