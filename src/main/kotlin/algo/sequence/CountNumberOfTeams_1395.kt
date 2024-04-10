package algo.sequence

class KtCountNumberOfTeams_1395 {
    fun numTeams(rating: IntArray): Int {
        var count = 0
        rating.indices.forEach { idx ->
            val current = rating[idx]
            var leftSmall = 0; var leftLarge = 0; var rightSmall = 0; var rightLarge = 0
            for (i in 0..<idx) {
                if (rating[i] < current) {
                    leftSmall++
                }
                if (rating[i] > current) {
                    leftLarge++
                }
            }
            for (i in idx + 1..<rating.size) {
                if (rating[i] < current) {
                    rightSmall++
                }
                if (rating[i] > current) {
                    rightLarge++
                }
            }
            count += leftSmall * rightLarge + leftLarge * rightSmall
        }
        return count
    }
}

fun main() {
    val teams = KtCountNumberOfTeams_1395()
    println(teams.numTeams(intArrayOf(2,5,3,4,1)))
    println(teams.numTeams(intArrayOf(2,1,3)))
    println(teams.numTeams(intArrayOf(1,2,3,4)))
}