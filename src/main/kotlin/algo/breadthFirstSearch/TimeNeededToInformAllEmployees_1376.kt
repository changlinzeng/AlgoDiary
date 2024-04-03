package algo.breadthFirstSearch

import java.util.LinkedList

class KtTimeNeededToInformAllEmployees_1376 {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val adjMap: MutableMap<Int, MutableList<IntArray>> = HashMap()
        manager.indices.forEach {
            adjMap.getOrPut(manager[it]) { mutableListOf() }.add(intArrayOf(it, informTime[it]))
        }

        var time = 0
        val q = LinkedList<IntArray>()
        q.offer(intArrayOf(headID, informTime[headID]))
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val emp = q.poll()
                val (empId, iTime) = emp
                time = time.coerceAtLeast(iTime)
                adjMap[empId]?.forEach { q.offer(intArrayOf(it[0], it[1] + iTime)) }
            }
        }
        return time
    }
}

fun main() {
    val inform = KtTimeNeededToInformAllEmployees_1376()
    println(inform.numOfMinutes(6, 2, intArrayOf(2,2,-1,2,2,2), intArrayOf(0,0,1,0,0,0)))
}