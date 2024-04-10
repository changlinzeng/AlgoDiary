package algo.slidingWindow

class KtFruitIntoBaskets_904 {
    fun totalFruit(fruits: IntArray): Int {
        val count: MutableMap<Int, Int> = mutableMapOf()  // fruit type -> count
        var maxCount = 0
        var i = 0; var j = 0
        while (j < fruits.size) {
            count[fruits[j]] = count.getOrDefault(fruits[j], 0) + 1
            if (count.size <= 2) {
                maxCount = maxCount.coerceAtLeast(j - i + 1)
            } else {
                while (i < j) {
                    val fruit = fruits[i]
                    if (count[fruit] != null) {
                        count[fruit] = count[fruit]!! - 1
                        if (count[fruit] == 0) {
                            count.remove(fruit)
                        }
                    }
                    i++
                    if (count.size <= 2) {
                        break
                    }
                }
            }
            j++
        }

        return maxCount
    }
}

fun main() {
    val fruit = KtFruitIntoBaskets_904()
    println(fruit.totalFruit(intArrayOf(0,1,2,2)))
}