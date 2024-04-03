package algo.depthFirstSearch

import data.util.TreeNode

class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
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
        val posMap = inorder.indices.associateBy { inorder[it] }
        return dfs(preorder, posMap, 0, 0, preorder.size - 1)
    }
}