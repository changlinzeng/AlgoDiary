package algo.depthFirstSearch

class KtDecodeString_394 {
    fun decodeString(s: String): String {
        fun dfs(s: String, start: Int): Pair<String, Int> {
            var num = 0
            var result = ""
            var i = start
            while (i < s.length) {
                when (val ch = s[i]) {
                    in '0'..'9' -> {
                        num = num * 10 + (ch - '0')
                    }
                    in 'a'..'z' -> {
                        result += ch
                    }
                    '[' -> {
                        val res = dfs(s, i + 1)
                        result += res.first.repeat(num)
                        i = res.second
                        num = 0
                    }
                    ']' -> {
                        break
                    }
                }
                i++
            }
            return Pair(result, i)
        }
        return dfs(s, 0).first
    }
}

fun main() {
    val decode = KtDecodeString_394()
    println(decode.decodeString("3[a]2[bc]"))
    println(decode.decodeString("3[a2[c]]"))
    println(decode.decodeString("2[abc]3[cd]ef"))
    println(decode.decodeString("4[2[jk]e1[f]]"))
}