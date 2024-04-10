package algo.sequence

class KtHandOfStraights_846 {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val freq: MutableMap<Int, Int> = mutableMapOf()
        hand.forEach {
            freq[it] = freq.getOrDefault(it, 0) + 1
        }

        hand.sort()
        val groupNum = hand.size / groupSize
        var groupCount = 0
        hand.forEach { num ->
            if (groupCount > groupNum) {
                return false
            }
            if (freq[num]!! == 0) {
                return@forEach
            }
            var card = num
            for (i in 1..groupSize) {
                if (freq[card] != null && freq[card]!! > 0) {
                    freq[card] = freq[card]!! - 1
                } else {
                    return false
                }
                card++
            }
            groupCount++
        }
        return groupCount == groupNum
    }
}

fun main() {
    val hand = KtHandOfStraights_846()
    println(hand.isNStraightHand(intArrayOf(1,2,3,6,2,3,4,7,8), 3))
    println(hand.isNStraightHand(intArrayOf(1,2), 2))
}