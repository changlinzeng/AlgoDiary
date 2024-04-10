package data.util.hashMap

class KtFindOriginalArrayFromDoubledArray_2007 {
    fun findOriginalArray(changed: IntArray): IntArray {
        val count: MutableMap<Int, Int> = mutableMapOf()  // count of each number
        changed.forEach { count[it] = count.getOrDefault(it, 0) + 1 }

        val original: MutableList<Int> = mutableListOf()
        changed.sort()
        changed.forEach {
            if (count[it] == 0) {
                return@forEach
            }
            if (!count.containsKey(it * 2)) {
                return intArrayOf()
            }
            original.add(it)
            count[it] = count[it]!! - 1
            count[it * 2] = count[it * 2]!! - 1
        }
        return if (original.size == changed.size / 2) original.toIntArray() else intArrayOf()
    }
}

fun main() {
    val findOriginal = KtFindOriginalArrayFromDoubledArray_2007()
    println(findOriginal.findOriginalArray(intArrayOf(1,3,4,2,6,8)))
    println(findOriginal.findOriginalArray(intArrayOf(6,3,0,1)))
}