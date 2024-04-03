package algo.depthFirstSearch

class KtKeysAndRooms_841 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        fun visit(rooms: List<List<Int>>, room: Int, visited: BooleanArray): Int {
            var num = 1
            if (visited[room]) {
                return 0
            }
            visited[room] = true
            rooms[room].forEach {
                num += visit(rooms, it, visited)
            }
            return num
        }
        return visit(rooms, 0, BooleanArray(rooms.size)) == rooms.size
    }
}

fun main() {
    val visit = KtKeysAndRooms_841()
    println(visit.canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    println(visit.canVisitAllRooms(listOf(listOf(1,3), listOf(3,0,1), listOf(2), listOf(0))))
}