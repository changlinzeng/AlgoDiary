package design

import kotlin.math.max

class KtOnlineElection_911 {
    class TopVotedCandidate(private val persons: IntArray, private val times: IntArray) {
        private val leader: MutableMap<Int, Int> = HashMap(times.size)  // time -> leader

        init {
            countVotes()
        }

        fun q(t: Int): Int {
            if (t >= times.last()) {
                return leader[times.last()]!!
            }
            // binary search to find the latest time < given time
            var start = 0; var end = times.size - 1
            while (start <= end) {
                val mid = start + (end - start) / 2
                if (times[mid] == t) {
                    return leader[t]!!
                } else if (times[mid] < t) {
                    if (mid < times.size - 1 && times[mid + 1] > t) {
                        return leader[times[mid]]!!
                    } else {
                        start = mid + 1
                    }
                } else {
                    if (mid > 0 && times[mid - 1] < t) {
                        return leader[times[mid - 1]]!!
                    } else {
                        end = mid - 1
                    }
                }
            }
            return -1
        }

        private fun countVotes() {
//            val votes: MutableMap<Int, Int> = HashMap(0)
//            times.indices.forEach { i ->
//                votes[persons[i]] = votes.getOrDefault(persons[i], 0) + 1
//                val maxVotes = votes.maxBy { it.value }.value
//                if (maxVotes == votes[persons[i]]) {
//                    // current is the leader
//                    leader[times[i]] = persons[i]
//                } else {
//                    // if current person is not the leader, then find the previous leader
//                    leader[times[i]] = leader[times[i - 1]]!!
//                }
//            }
            val votes: MutableMap<Int, Int> = HashMap(0)
            var lead = -1; var maxVote = 0;
            times.indices.forEach { i ->
                votes[persons[i]] = votes.getOrDefault(persons[i], 0) + 1
                if (lead == -1) {
                    lead = persons[i]
                    maxVote++
                } else {
                    if (persons[i] == lead) {
                        maxVote++
                    } else {
                        // current is the new lead
                        if (votes[persons[i]]!! >= maxVote) {
                            lead = persons[i]
                            maxVote = votes[persons[i]]!!
                        }
                    }
                }
                leader[times[i]] = lead
            }
        }
    }
}

fun main() {
    val election = KtOnlineElection_911.TopVotedCandidate(intArrayOf(0, 1, 1, 0, 0, 1, 0), intArrayOf(0, 5, 10, 15, 20, 25, 30))
    println(election.q(3))
    println(election.q(12))
    println(election.q(25))
    println(election.q(15))
    println(election.q(24))
}