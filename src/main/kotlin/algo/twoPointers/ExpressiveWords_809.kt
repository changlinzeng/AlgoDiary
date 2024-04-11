package algo.twoPointers

class KtExpressiveWords_809 {
    fun expressiveWords(s: String, words: Array<String>): Int {
        fun signature(s: String): MutableList<IntArray> {
            val count: MutableList<IntArray> = mutableListOf()
            s.indices.forEach { i ->
                if (i > 0 && s[i] == s[i - 1]) {
                    count.last()[1]++
                } else {
                    count.add(intArrayOf(s[i] - 'a', 1))
                }
            }
            return count
        }

        val base = signature(s)
        var num = 0
        run loop@ {
            words.forEach { w ->
                val sig = signature(w)
                if (base.size == sig.size) {
                    for (i in base.indices) {
                        if (base[i][0] != sig[i][0]) {
                            return@forEach
                        }
                        if (base[i][1] > 2 && base[i][1] < sig[i][1] ||
                            base[i][1] <=2 && base[i][1] != sig[i][1]) {
                            return@forEach
                        }
                    }
                    num++
                }
            }
        }
        return num
    }
}

fun main() {
    val expressive = KtExpressiveWords_809()
    println(expressive.expressiveWords("heeellooo", arrayOf("hello", "hi", "helo")))
}