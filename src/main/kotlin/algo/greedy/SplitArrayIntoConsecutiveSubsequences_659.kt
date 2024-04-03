package algo.greedy

class KtSplitArrayIntoConsecutiveSubsequences_659 {
    fun isPossible(nums: IntArray): Boolean {
        val shortSeq: MutableList<Seq> = mutableListOf()
        val seqs: MutableList<Seq> = mutableListOf()
        nums.indices.forEach { i ->
            val num = nums[i]
            if (i == 0 || nums[i] - nums[i - 1] > 1) {
                shortSeq.add(Seq(num, 1))
            } else {
                // try to add to sequences whose len < 3
                var added = false
                run shortLoop@ {
                    shortSeq.indices.forEach {
                        val seq = shortSeq[it]
                        if (seq.end == num - 1) {
                            added = true
                            seq.end = num
                            seq.len++
                            if (seq.len == 3) {
                                shortSeq.removeAt(it)
                                seqs.add(seq)
                            }
                            return@shortLoop
                        }
                    }
                }
                // try to add to sequences whose len >= 3
                if (!added) {
                    run longLoop@ {
                        seqs.forEach { seq ->
                            if (seq.end == num - 1) {
                                added = true
                                seq.end = num
                                seq.len++
                                return@longLoop
                            }
                        }
                    }
                }
                if (!added) {
                    shortSeq.add(Seq(num, 1))
                }
            }
        }
        return shortSeq.isEmpty()
    }
}

data class Seq(var end: Int, var len: Int)

fun main() {
    val split = KtSplitArrayIntoConsecutiveSubsequences_659()
    println(split.isPossible(intArrayOf(1,2,3,3,4,5)))
    println(split.isPossible(intArrayOf(1,2,3,3,4,4,5,5)))
    println(split.isPossible(intArrayOf(1,2,3,4,4,5)))
    println(split.isPossible(intArrayOf(1,2,3,5,5,6,7)))
}