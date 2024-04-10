package algo.twoPointers

class KtStringCompression_443 {
    fun compress(chars: CharArray): Int {
        var count = 1
        var end = 0
        for (i in 1..chars.size) {
            if (i == chars.size || chars[i] != chars[i - 1]) {
                chars[end++] = chars[i - 1]
                // no need to write count
                if (count == 1) {
                    continue
                }

                var start = end
                // append count to end in reverse order and then reverse it
                while (count > 9) {
                    chars[end++] = (count % 10).digitToChar()
                    count /= 10
                }
                chars[end++] = count.digitToChar()
                count = 1

                // reverse the number
                var to = end - 1
                while (start < to) {
                    val tmp = chars[start]
                    chars[start] = chars[to]
                    chars[to] = tmp
                    start++
                    to--
                }
            } else {
                count++
            }
        }
        return end
    }
}

fun main() {
    val compress = KtStringCompression_443()
    println(compress.compress(charArrayOf('a','a','b','b','c','c','c')))
    println(compress.compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
    println(compress.compress(charArrayOf('a')))
    println(compress.compress(charArrayOf('a','a','a','b','b','a','a')))
}