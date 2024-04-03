package algo.breadthFirstSearch

import java.util.LinkedList
import kotlin.text.StringBuilder

class KtSlidingPuzzle_773 {
    companion object {
        const val TARGET = "123450"
        // next movements when empty cell at index 0 to 5
        val direction = mapOf(
            0 to listOf(1, 3),
            1 to listOf(0, 2, 4),
            2 to listOf(1, 5),
            3 to listOf(0, 4),
            4 to listOf(1, 3, 5),
            5 to listOf(2, 4)
        )
    }
    fun slidingPuzzle(board: Array<IntArray>): Int {
        fun nextStates(position: Int, currentState: String): List<String> {
            val states: MutableList<String> = mutableListOf()
            direction[position]?.forEach {
                val tmp = currentState[it]
                val sb = StringBuilder(currentState)
                sb[it] = sb[position]
                sb[position] = tmp
                states.add(sb.toString())
            }
            return states
        }
        val state = board.flatMap { it.asIterable() }.joinToString("")
        val visited: MutableSet<String> = HashSet()
        var steps = 0
        val q = LinkedList<String>()
        q.offer(state)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val st = q.poll()
                if (st == TARGET) {
                    return steps
                }
                if (!visited.add(st)) {
                    continue
                }
                nextStates(st.indexOf('0'), st).forEach { q.offer(it) }
            }
            steps++
        }
        return -1
    }
}

fun main() {
    val puzzle = KtSlidingPuzzle_773()
    println(puzzle.slidingPuzzle(arrayOf(intArrayOf(1,2,3), intArrayOf(4,0,5))))
    println(puzzle.slidingPuzzle(arrayOf(intArrayOf(1,2,3), intArrayOf(5,4,0))))
    println(puzzle.slidingPuzzle(arrayOf(intArrayOf(4,1,2), intArrayOf(5,0,3))))
}