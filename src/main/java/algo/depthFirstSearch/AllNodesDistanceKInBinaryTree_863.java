package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            return List.of(target.val);
        }

        var distanceNodes = new ArrayList<Integer>();
        findChildrenDistanceK(target, k, 0, distanceNodes);
        findNode(root, target, k, distanceNodes);

        return distanceNodes;
    }

    private static int findNode(TreeNode node, TreeNode target, int k, List<Integer> nodes) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            return 0;
        }
        var onLeft = true;
        var distance = findNode(node.left, target, k, nodes);
        if (distance != -1) {
            // not on left substree
            distance++;
        } else {
            distance = findNode(node.right, target, k, nodes);
            if (distance == -1) {
                // not on right subtree. so target is not under current node
                return -1;
            }
            distance++;
            onLeft = false;
        }
        if (distance == k) {
            nodes.add(node.val);
        } else if (distance < k) {
            if (onLeft) {
                // find on right subtree
                findChildrenDistanceK(node.right, k - distance - 1, 0, nodes);
            } else {
                // find on left substree
                findChildrenDistanceK(node.left, k - distance - 1, 0, nodes);
            }
        }
        return distance;
    }

    private static void findChildrenDistanceK(TreeNode from, int k, int distance, List<Integer> nodes) {
        if (from == null) {
            return;
        }
        if (distance == k) {
            nodes.add(from.val);
            return;
        }
        distance++;
        findChildrenDistanceK(from.left, k, distance, nodes);
        findChildrenDistanceK(from.right, k, distance, nodes);
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
//        var target = Tree.findNode(root, 5);
//        var root = Tree.fromHeap(new Integer[]{3});
//        var target = root;
//        var root = Tree.fromHeap(new Integer[]{0,1,null,3,2});
//        var target = Tree.findNode(root, 2);
        var root = Tree.fromHeap(new Integer[]{0,2,1,null,null,3});
        var target = Tree.findNode(root, 3);
        System.out.println(distanceK(root, target, 3));
    }
}
