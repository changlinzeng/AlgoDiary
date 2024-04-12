package data.structure.stack

import java.util.Stack

class KtExclusiveTimeOfFunctions_636 {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val exclusiveTime = IntArray(n)
        val stack = Stack<FunctionLog>()
        logs.map { log ->
            val fields = log.split(":")
            val start = fields[1] == "start"
            FunctionLog(fields[0].toInt(), start, fields[2].toInt())
        }.sortedBy { it.timestamp }.forEach { log ->
            if (log.start) {
                stack.push(log)
            } else {
                val prev = stack.pop()
                val time = log.timestamp - prev.timestamp + 1
                // time for prev function
                exclusiveTime[prev.id] += time

                // if previous function is not finished, we need to subtract current time for previous one
                if (stack.isNotEmpty() && stack.peek().start) {
                    exclusiveTime[stack.peek().id] -= time
                }
            }
        }

        return exclusiveTime
    }

    data class FunctionLog(val id: Int, val start: Boolean, val timestamp: Int)
}


fun main() {
    val time = KtExclusiveTimeOfFunctions_636()
    println(time.exclusiveTime(2, listOf("0:start:0","1:start:2","1:end:5","0:end:6")).asList())
    println(time.exclusiveTime(3, listOf("1:start:0","0:start:2","1:start:3","2:start:4","2:end:4","0:end:6","1:end:7","1:end:8")).asList())
}