package algo.twoPointers

class KtBoatsToSavePeople_881 {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var left = 0; var right = people.size - 1
        var boats = 0
        people.sort()
        while (left <= right) {
            if (left == right) {
                boats++
                break
            }
            if (people[left] + people[right] <= limit) {
                boats++
                left++
                right--
            } else {
                boats++
                right--
            }
        }
        return boats
    }
}

fun main() {
    val boat = KtBoatsToSavePeople_881()
    println(boat.numRescueBoats(intArrayOf(3,2,2,1), 3))
    println(boat.numRescueBoats(intArrayOf(3,5,3,4), 5))
    println(boat.numRescueBoats(intArrayOf(3,8,7,1,4), 9))
}