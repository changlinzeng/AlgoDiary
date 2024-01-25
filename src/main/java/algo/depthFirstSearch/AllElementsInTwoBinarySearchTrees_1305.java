package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees_1305 {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        var nodes1 = new ArrayList<Integer>();
        var nodes2 = new ArrayList<Integer>();
        inorder(root1, nodes1);
        inorder(root2, nodes2);

        int i = 0, j = 0;
        var all = new ArrayList<Integer>();
        while (i < nodes1.size() && j < nodes2.size()) {
            var n1 = nodes1.get(i);
            var n2 = nodes2.get(j);
            if (n1 < n2) {
                all.add(n1);
                i++;
            } else {
                all.add(n2);
                j++;
            }
        }
        while (i < nodes1.size()) {
            all.add(nodes1.get(i));
            i++;
        }
        while (j < nodes2.size()) {
            all.add(nodes2.get(j));
            j++;
        }

        return all;
    }

    private static void inorder(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        inorder(node.left, nodes);
        nodes.add(node.val);
        inorder(node.right, nodes);
    }

    public static void main(String[] args) {
        var root1 = Tree.fromHeap(new Integer[]{2,1,4});
        var root2 = Tree.fromHeap(new Integer[]{1,0,3});
        System.out.println(getAllElements(root1, root2));
    }
}
