package algo.breadthFirstSearch

import java.util.LinkedList

class KtMinimumGeneticMutation_433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        var mutations = 0
        val visited: MutableSet<String> = mutableSetOf()
        val q = LinkedList<String>()
        q.offer(startGene)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val g = q.poll()
                visited.add(g)
                if (g == endGene) {
                    return mutations
                }
                nextGen(g, bank, visited).forEach { q.offer(it) }
            }
            mutations++
        }
        return -1
    }

    private fun nextGen(gen: String, bank: Array<String>, visited: Set<String>): List<String> {
        val nextGens: MutableList<String> = mutableListOf()
        bank.filter { !visited.contains(it) }.forEach {g ->
            var diff = 0
            for (i in gen.indices) {
                if (gen[i] != g[i]) {
                    diff++
                }
                if (diff > 1) {
                    break
                }
            }
            if (diff == 1) {
                nextGens.add(g)
            }
        }
        return nextGens
    }
}

fun main() {
    val mutate = KtMinimumGeneticMutation_433()
    println(mutate.minMutation("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA")))
    println(mutate.minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA","AACCGCTA","AAACGGTA")))
}