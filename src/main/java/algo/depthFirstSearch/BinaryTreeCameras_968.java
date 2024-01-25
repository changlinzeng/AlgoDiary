package algo.depthFirstSearch;

import datautil.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCameras_968 {
    public static int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        var cameras = new HashMap<TreeNode, Boolean>();
        var covered = new HashMap<TreeNode, Boolean>();
        addCameras(root, cameras, covered);

        var num = cameras.size();
        // if root is not covered, add camera to root
        if (!covered.containsKey(root) &&
                (root.left != null && !cameras.containsKey(root.left) ||
                 root.right != null && !cameras.containsKey(root.right))) {
            num++;
        }
        return num;
    }

    private static void addCameras(TreeNode node, Map<TreeNode, Boolean> cameras, Map<TreeNode, Boolean> covered) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            addCameras(node.left, cameras, covered);
        }
        if (node.right != null) {
            addCameras(node.right, cameras, covered);
        }
        if (node.left != null && !covered.containsKey(node.left) ||
            node.right != null && !covered.containsKey(node.right)) {
            // add camera if one of the children does not have camera
            cameras.putIfAbsent(node, true);
            covered.put(node, true);
            if (node.left != null) {
                covered.put(node.left, true);
            }
            if (node.right != null) {
                covered.put(node.right, true);
            }
        }
        if (node.left != null && cameras.containsKey(node.left) ||
            node.right != null && cameras.containsKey(node.right)) {
            // overed by children
            covered.putIfAbsent(node, true);
        }
    }
}
