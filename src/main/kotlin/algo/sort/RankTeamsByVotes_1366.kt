package algo.sort

import java.util.PriorityQueue

class KtRankTeamsByVotes_1366 {

    fun rankTeams(votes: Array<String>): String {
        // collect votes for each team
        val voteCount: MutableMap<Char, IntArray> = HashMap(26)
        votes.forEach { v ->
            v.indices.forEach { i ->
                voteCount.computeIfAbsent(v[i]) { IntArray(v.length) }
                voteCount[v[i]]!![i] = voteCount[v[i]]!![i] + 1
            }
        }

        val teams = voteCount.keys
        return teams.sortedWith(object: Comparator<Char> {
            override fun compare(a: Char?, b: Char?): Int {
                val va = voteCount[a]!!
                val vb = voteCount[b]!!
                for (i in va.indices) {
                    if (va[i] != vb[i]) {
                        return vb[i] - va[i]
                    }
                }
                return 0
            }
        }).joinToString("")
    }
}

fun main() {
    val rank = KtRankTeamsByVotes_1366()
    println(rank.rankTeams(arrayOf("ABC","ACB","ABC","ACB","ACB")))
    println(rank.rankTeams(arrayOf("ZMNAGUEDSJYLBOPHRQICWFXTVK")))
    println(rank.rankTeams(arrayOf("BCA","CAB","CBA","ABC","ACB","BAC")))
}