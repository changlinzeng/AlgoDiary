package algo.math

import kotlin.math.absoluteValue

class KtFractionToRecurringDecimal_166 {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        var num: Long = numerator.toLong()
        var denom: Long = denominator.toLong()
        var result = ""
        if (num * denom < 0) {
            result = "-"
            num = num.absoluteValue
            denom = denom.absoluteValue
        }

        // integer part
        var quotient = num / denom
        var mod = num % denom
        result += quotient
        if (mod == 0L) {
            return result
        }

        // decimal part
        val modMap: MutableMap<Long, Int> = mutableMapOf()  // mod -> position
        val quotientMap: MutableMap<Int, Long> = mutableMapOf()  // position -> quotient
        result += "."
        while (true) {
            mod *= 10
            quotient = mod / denom
            mod %= denom
            result += quotient
            if (mod == 0L) {
                return result
            } else {
                // there is loop when the quotient and mod repeat at different position
                if (modMap.containsKey(mod) && quotientMap[modMap[mod]] == quotient) {
                    val start = modMap[mod]!!
                    result = result.substring(0, start) + "(" + result.substring(start, result.length - 1) + ")"
                    return result
                } else {
                    val pos = result.length - 1
                    modMap[mod] = pos
                    quotientMap[pos] = quotient
                }
            }
        }
    }
}

fun main() {
    val fraction = KtFractionToRecurringDecimal_166()
    println(fraction.fractionToDecimal(1,2))
    println(fraction.fractionToDecimal(4,333))
}