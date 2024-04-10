package algo.twoPointers

class KtPushDominos_838 {
    fun pushDominoes(dominoes: String): String {
        val states = dominoes.toMutableList()
        states.add(0, 'L')
        states.add('R')

        // find 'L' and 'R' and then change status between 'L' and 'R'
        var leftState = -1; var rightState = -1
        states.indices.forEach { i ->
            if (states[i] != '.') {
                if (leftState == -1) {
                    leftState = i
                } else {
                    rightState = i
                }
            }
            if (leftState != -1 && rightState != -1) {
                val left = states[leftState]
                val right = states[rightState]
                if (left == 'L' && right == 'L') {
                    for (k in leftState + 1..<rightState) {
                        states[k] = 'L'
                    }
                } else if (left == 'L' && right == 'R') {
                    // do nothing
                } else if (left == 'R' && right == 'L') {
                    var j = leftState; var k = rightState
                    while (j < k) {
                        states[j] = 'R'
                        states[k] = 'L'
                        j++
                        k--
                    }
                } else if (left == 'R' && right == 'R') {
                    for (k in leftState + 1..<rightState) {
                        states[k] = 'R'
                    }
                }
                leftState = rightState
                rightState = -1
            }
        }
        val s = states.joinToString("")
        return s.substring(1, s.length - 1)
    }
}

fun main() {
    val domino = KtPushDominos_838()
    println(domino.pushDominoes("RR.L"))
    println(domino.pushDominoes(".L.R...LR..L.."))
    println(domino.pushDominoes(".L.R."))
    println(domino.pushDominoes("R.R.L"))
}