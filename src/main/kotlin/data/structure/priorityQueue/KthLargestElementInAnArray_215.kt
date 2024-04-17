package data.structure.priorityQueue

import java.util.PriorityQueue

class KtKthLargestElementInAnArray_215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()
        nums.forEach { num ->
            if (pq.size < k) {
                pq.offer(num)
            } else {
                if (pq.peek() < num) {
                    pq.poll()
                    pq.offer(num)
                }
            }
        }
        return pq.peek()
    }
}