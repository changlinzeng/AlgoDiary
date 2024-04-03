package algo.parenthesis

class KtMinimumRemoveToMakeValidParentheses_1249 {
    fun minRemoveToMakeValid(s: String): String {
        var leftParen = 0; var rightParen = 0
        val valid: MutableList<String> = mutableListOf()
        s.forEach {
            if (it in 'a'..'z') {
                valid.add(it.toString())
            } else if (it == '(') {
                valid.add("(")
                leftParen++
            } else {
                var str = ")"
                if (rightParen < leftParen) {
                    rightParen++
                    while (valid.isNotEmpty()) {
                        val e = valid.removeLast()
                        str = e + str
                        if (e == "(") {
                            break
                        }
                    }
                    valid.add(str)
                }
            }
        }
        return valid.filter { it != "(" }.joinToString("")
    }
}

fun main() {
    val remove = KtMinimumRemoveToMakeValidParentheses_1249()
    println(remove.minRemoveToMakeValid("lee(t(c)o)de)"))
    println(remove.minRemoveToMakeValid("a)b(c)d"))
    println(remove.minRemoveToMakeValid("))(("))
    println(remove.minRemoveToMakeValid("(a(b(c)d)"))
}