package data.structure.stack

import java.util.Stack
import kotlin.math.absoluteValue

class KtAsteroidCollision_735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        asteroids.forEach {
            if (it > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(it)
            } else {
                while (stack.isNotEmpty() && stack.peek() > 0 && stack.peek() < it.absoluteValue) {
                    stack.pop()
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(it)
                } else {
                    if (stack.peek() == it.absoluteValue) {
                        stack.pop()
                    }
                }
            }
        }
        return stack.toIntArray()
    }
}

fun main() {
    val asteroid = KtAsteroidCollision_735()
    println(asteroid.asteroidCollision(intArrayOf(5,10,-5)))
    println(asteroid.asteroidCollision(intArrayOf(8,-8)))
    println(asteroid.asteroidCollision(intArrayOf(10,2,-5)))
}