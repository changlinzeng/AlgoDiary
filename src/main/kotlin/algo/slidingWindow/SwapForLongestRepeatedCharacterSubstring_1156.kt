package algo.slidingWindow

class KtSwapForLongestRepeatedCharacterSubstring_1156 {
    fun maxRepOpt1(text: String): Int {
        val position: MutableMap<Char, IntArray> = mutableMapOf()  // first and last index of char
        text.indices.forEach { i ->
            val c = text[i]
            position.computeIfAbsent(c) { intArrayOf(i, i) }
            position[c]!![1] = i
        }

        val count: MutableMap<Char, MutableList<Int>> = mutableMapOf()  // indices of char
        var maxLen = 0
        text.indices.forEach { i ->
            // record indices for the char
            val c = text[i]
            count.computeIfAbsent(c) { mutableListOf() }
            val q = count[c]!!
            q.add(i)

            // make sure there is less than one other char from the first index to i of current char
            while (q.isNotEmpty() && i - q.first() > q.size) {
                q.removeFirst()
            }

            // if there is any char outside the window, we can swap
            var len = q.size
            if (i - q.first() <= q.size) {
                val pos = position[c]!!
                if (pos[0] < q.first() || pos[1] > i) {
                    len++
                }
            }

            maxLen = maxLen.coerceAtLeast(len)
        }
        return maxLen
    }
}

fun main() {
    val swap = KtSwapForLongestRepeatedCharacterSubstring_1156()
    println(swap.maxRepOpt1("ababa"))
    println(swap.maxRepOpt1("aaabaaa"))
    println(swap.maxRepOpt1("aaaaa"))
}