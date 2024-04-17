package algo.twoPointers

class KtSwapAdjacentInLRString_777 {
    fun canTransform(start: String, end: String): Boolean {
        if (start.length == 1) {
            return start == end
        }
        val startArr = start.toCharArray()
        var i = 0
        while (i < startArr.size) {
            if (startArr[i] != end[i]) {
                when (end[i]) {
                    // if start [i] is 'L' or 'X', we could not swap to make it 'R'
                    'R' -> return false
                    'L' -> {
                        if (startArr[i] == 'R') {
                            return false
                        }
                        // start[i] is 'X' so we find the first 'L' to the right and swap
                        // e.g. XXXXXL
                        var j = i + 1
                        while (j < startArr.size && startArr[j] == 'X') {
                            j++
                        }
                        if (j == startArr.size || startArr[j] != 'L') {
                            return false
                        }
                        startArr[j] = 'X'
                    }
                    'X' -> {
                        if (start[i] == 'L') {
                            return false
                        }
                        // start[i] is 'R', find the first 'X' to the right and swap
                        // e.g. RRRRX
                        var j = i + 1
                        while (j < startArr.size && startArr[j] == 'R') {
                            j++
                        }
                        if (j == startArr.size || startArr[j] != 'X') {
                            return false
                        }
                        startArr[j] = 'R'
                    }
                }
            }
            i++
        }
        return true
    }
}

fun main() {
    val swap = KtSwapAdjacentInLRString_777()
    println(swap.canTransform("RXR", "XXR"))
    println(swap.canTransform("XXXXLXXX", "LXXXXXXX"))
    println(swap.canTransform("XLXRRXXRXX", "LXXXXXXRRR"))
    println(swap.canTransform("RLX", "XLR"))
}