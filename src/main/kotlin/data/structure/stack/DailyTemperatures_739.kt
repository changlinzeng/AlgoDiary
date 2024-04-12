package data.structure.stack

import java.util.Stack

class KtDailyTemperatures_739 {
    // find the next greater element
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // use a min stack to record the index of temperature and find the next grater element
        val minStack = Stack<Int>()  // index of temperature
        val days = IntArray(temperatures.size)
        temperatures.indices.forEach { i ->
            while (minStack.isNotEmpty() && temperatures[minStack.peek()] < temperatures[i]) {
                val day = minStack.pop()
                days[day] = i - day
            }
            minStack.push(i)
        }
        return days
    }
}

fun main() {
    val dailyTemp = KtDailyTemperatures_739()
    println(dailyTemp.dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)))
}