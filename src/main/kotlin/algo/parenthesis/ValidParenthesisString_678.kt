package algo.parenthesis

class KtValidParenthesisString_678 {
    fun checkValidString(s: String): Boolean {
        val leftParen: MutableList<Int> = mutableListOf()  // index of left parenthesis
        val asterisk: MutableList<Int> = mutableListOf()  // index of asterisk
        s.indices.forEach {
            val ch = s[it]
            when (ch) {
                '(' -> leftParen.add(it)
                '*' -> asterisk.add(it)
                ')' -> {
                    if (leftParen.isNotEmpty()) {
                        leftParen.removeLast()  // consume left parenthesis
                    } else if (asterisk.isNotEmpty()) {
                        asterisk.removeLast()  // consume asterisk
                    } else {
                        // nothing to consume
                        return false
                    }
                }
            }
        }
        // consume left parenthesis with asterisk
        while (leftParen.isNotEmpty() && asterisk.isNotEmpty()) {
            // left parenthesis should on the left
            if (leftParen.removeLast() > asterisk.removeLast()) {
                return false
            }
        }
        return leftParen.isEmpty()
    }
}