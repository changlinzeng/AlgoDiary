package data.structure.priorityQueue

import java.util.PriorityQueue

class KtKthSmallestPrimeFraction_786 {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val pq = PriorityQueue<IntArray> {a, b -> a[1] * b[0] - a[0] * b[1]}  // max heap
        arr.sorted().indices.reversed().forEach { j ->
            for (i in 0..<j) {
                if (pq.size < k) {
                    pq.offer(intArrayOf(arr[i], arr[j]))
                } else {
                    val top = pq.peek()
                    if (top[0] * arr[j] < top[1] * arr[i]) {
                        break
                    }
                    // if top > i / j, then pop pop and push i / j
                    pq.poll();
                    pq.offer(intArrayOf(arr[i], arr[j]))
                }
            }
        }
        return pq.peek()
    }
}

fun main() {
    val prime = KtKthSmallestPrimeFraction_786()
    println(prime.kthSmallestPrimeFraction(intArrayOf(1,2,3,5), 3).toList())
}