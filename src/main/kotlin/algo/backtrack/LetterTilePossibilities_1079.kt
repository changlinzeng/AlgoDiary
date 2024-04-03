package algo.backtrack

class KtLetterTilePossibilities_1079 {
    fun numTilePossibilities(tiles: String): Int {
        val possibilities: HashSet<String> = hashSetOf()
        fun backtrack(tiles: String, possibility: String, visited: BooleanArray) {
            if (possibility != "") {
                possibilities.add(possibility)
            }
            for (i in tiles.indices) {
                if (visited[i]) {
                    continue
                }
                visited[i] = true
                val next = possibility + tiles[i]
                backtrack(tiles, next, visited)
                visited[i] = false
            }
        }
        backtrack(tiles, "", BooleanArray(tiles.length))
        return possibilities.size
    }
}

fun main() {
    val tile = KtLetterTilePossibilities_1079()
    println(tile.numTilePossibilities("AAB"))
    println(tile.numTilePossibilities("AAABBC"))
    println(tile.numTilePossibilities("V"))
}