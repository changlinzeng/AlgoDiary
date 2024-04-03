package data.util

import java.util.LinkedList

data class TreeNode(val `val`: Int,
                    var left: TreeNode? = null,
                    var right: TreeNode? = null) {
}

class Tree(val root: TreeNode) {
    companion object {
        /**
         * Serialize tree in level order
         */
        fun serialize(root: TreeNode): String {
            var data = ""
            val q = LinkedList<TreeNode?>()
            q.offer(root)
            while (q.isNotEmpty()) {
                val node = q.poll()
                if (data != "") {
                    data += ","
                }
                if (node == null) {
                    data += "null"
                    continue
                }
                data += node.`val`.toString()
                val left = node.left; val right = node.right
                q.offer(left)
                q.offer(right)
            }
            for (i in data.length - 1 downTo 0) {
                if (data[i] in '0'..'9') {
                    return data.substring(0, i + 1)
                }
            }

            return data
        }

        /**
         * Build tree from level order traversal
         */
        fun deserialize(data: String): TreeNode? {
            if (data == "") {
                return null
            }
            val vals = data.split(",")
            if (vals[0] == "null") {
                return null
            }

            val root = TreeNode(vals[0].toInt())
            val q = LinkedList<TreeNode>()
            q.offer(root)
            var index = 1
            while (q.isNotEmpty() && index < vals.size) {
                val parent = q.poll()
                if (index < vals.size) {
                    val leftVal = vals[index++]
                    if (leftVal != "null") {
                        val left = TreeNode(leftVal.toInt())
                        parent.left = left
                        q.offer(left)
                    }
                }
                if (index < vals.size) {
                    val rightVal = vals[index++]
                    if (rightVal != "null") {
                        val right = TreeNode(rightVal.toInt())
                        parent.right = right
                        q.offer(right)
                    }
                }
            }
            return root
        }

        fun preorder(root: TreeNode): String {
            fun dfs(root: TreeNode): String {
                var ser = root.`val`.toString()
                root.left?.also { ser = "$ser,${dfs(it)}" }
                root.right?.also { ser = "$ser,${dfs(it)}" }
                return ser
            }
            return dfs(root)
        }

        fun inorder(root: TreeNode): String {
            fun dfs(root: TreeNode): String {
                var ser = root.`val`.toString()
                root.left?.also { ser = "${dfs(it)},$ser" }
                root.right?.also { ser = "$ser,${dfs(it)}" }
                return ser
            }
            return dfs(root)
        }

        fun fromPreorderAndInorder(preorder: String, inorder: String): TreeNode? {
            /**
             * @param cur index of parent node
             * @param start start index in inorder
             * @param end end index in inorder
             */
            fun dfs(preorder: IntArray, posMap: Map<Int, Int>, cur: Int, start: Int, end: Int): TreeNode? {
                if (start > end) {
                    return null
                }
                val nodeVal = preorder[cur]
                val parent = TreeNode(nodeVal)
                val inorderPos = posMap[nodeVal]!!  // index of parent node in inorder
                val offsetLeft = inorderPos - start
                val rightParentIndex = cur + offsetLeft + 1
                parent.left = dfs(preorder, posMap, cur + 1, start, inorderPos - 1)
                parent.right = dfs(preorder, posMap, rightParentIndex, inorderPos + 1, end)
                return parent
            }
            val preorderArr = preorder.split(",").map { it.toInt() }.toIntArray()
            val inorderArr = inorder.split(",").map { it.toInt() }.toList()
            val posMap = inorderArr.indices.associateBy { inorderArr[it] }
            return dfs(preorderArr, posMap, 0, 0, preorderArr.size - 1)
        }
    }
}

fun main() {
    var root = Tree.deserialize("1,2,3,null,null,4,5")
    println(Tree.serialize(root!!))
    println(Tree.preorder(root))
    println(Tree.inorder(root))

    root = Tree.fromPreorderAndInorder("1,2,3,4,5", "2,1,4,3,5")
    print(root)
}