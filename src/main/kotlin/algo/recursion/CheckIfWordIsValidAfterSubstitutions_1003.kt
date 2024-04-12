package algo.recursion

class KtCheckIfWordIsValidAfterSubstitutions_1003 {
    fun isValid(s: String): Boolean {
        if (s == "abc") {
            return true
        }
        val start = s.indexOf("abc")
        if (start == -1) {
            return false
        }
        return isValid(s.substring(0, start) + s.substring(start + 3))
    }
}

fun main() {
    val substitution = KtCheckIfWordIsValidAfterSubstitutions_1003()
    println(substitution.isValid("aabcbc"))
    println(substitution.isValid("abcabcababcc"))
    println(substitution.isValid("abccba"))
}