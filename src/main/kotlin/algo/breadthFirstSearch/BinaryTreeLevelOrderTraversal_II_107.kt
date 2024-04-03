package algo.breadthFirstSearch

import data.util.Tree
import data.util.TreeNode
import java.util.LinkedList

class KtBinaryTreeLevelOrderTraversal_II_107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        val q = LinkedList<TreeNode?>()
        q.addLast(root)
        while (!q.isEmpty()) {
            val size = q.size
            val level: MutableList<Int> = mutableListOf()
            for (i in 1..size) {
                val node = q.removeFirst()
                node?.also {
                    level.add(node.`val`)
                    node.left?.also { q.addLast(it) }
                    node.right?.also { q.addLast(it) }
                }
            }
            if (level.isNotEmpty()) {
                result.add(0, level.toList())
            }
        }
        return result
    }
}

fun main() {
    val traversal = KtBinaryTreeLevelOrderTraversal_II_107()
    val root = Tree.deserialize("3,9,20,null,null,15,7")
    println(traversal.levelOrderBottom(root))
}