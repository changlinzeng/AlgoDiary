package datautil.tree;

import java.util.*;

public class Tree {
    public static String toPreorder(TreeNode root) {
        var sb = new StringBuffer();
        doSerialize(root, sb);
        return sb.toString();
    }

    private static void doSerialize(TreeNode node, StringBuffer sb) {
        if (!sb.isEmpty()) {
            sb.append(",");
        }
        if (node == null) {
            sb.append("null");
            return;
        }
        sb.append(node.val);
        doSerialize(node.left, sb);
        doSerialize(node.right, sb);
    }

    public static TreeNode fromPreorder(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        return doDeserialize(data.split(","), new Index(0));
    }

    private static TreeNode doDeserialize(String[] data, Index index) {
        var idx = index.val;
        if ("null".equals(data[idx])) {
            index.val++;
            return null;
        }
        var parent = new TreeNode(Integer.parseInt(data[idx]));
        index.val++;
        parent.left = doDeserialize(data, index);
        parent.right = doDeserialize(data, index);
        return parent;
    }

    private static class Index {
        public int val;
        public Index(int val) {
            this.val = val;
        }
    }

    /**
     * Serialize binary tree in level order
     */
    public static String serialize(TreeNode node) {
        var result = "";
        var q = new LinkedList<TreeNode>();
        q.offer(node);
        while (!q.isEmpty()) {
            if (!result.isEmpty()) {
                result += ",";
            }
            var n = q.poll();
            if (n == null) {
                result += "null";
                continue;
            }
            result += n.val;
            if (node.left == null && node.right == null) {
                continue;
            }
            q.offer(n.left);
            q.offer(n.right);
        }

        for (var i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) >= '0' && result.charAt(i) <= '9') {
                return result.substring(0, i + 1);
            }
        }
        return result;
    }

    /**
     * Deserialize binary tree from level order traversal
     */
    public static TreeNode deserialize(String ser) {
        if (ser == null || ser.isBlank()) {
            return null;
        }
        var data = ser.split(",");
        var val = data[0];
        if (val.equals("null")) {
            return null;
        }
        var root = new TreeNode(Integer.parseInt(val));
        var q = new ArrayDeque<TreeNode>();
        var index = 1;
        q.offer(root);
        while (!q.isEmpty() && index < data.length) {
            var node = q.poll();
            var leftVal = data[index++];
            if (!leftVal.equals("null")) {
                var left = new TreeNode(Integer.parseInt(leftVal));
                node.left = left;
                q.offer(left);
            }
            if (index < data.length) {
                var rightVal = data[index++];
                if (!rightVal.equals("null")) {
                    var right = new TreeNode(Integer.parseInt(rightVal));
                    node.right = right;
                    q.offer(right);
                }
            }
        }

        return root;
    }

    public static TreeNode fromHeap(Integer[] heap) {
        if (heap.length == 0) {
            return null;
        }
        return buildSubTree(heap, 0);
    }

    private static TreeNode buildSubTree(Integer[] heap, int parent) {
        if (parent >= heap.length) {
            return null;
        }
        var node = new TreeNode(heap[parent]);
        var left = parent * 2 + 1;
        var right = parent * 2 + 2;
        if (left < heap.length && heap[left] != null) {
            node.left = buildSubTree(heap, parent * 2 + 1);
        }
        if (right < heap.length && heap[right] != null) {
            node.right = buildSubTree(heap, parent * 2 + 2);
        }
        return node;
    }

    /**
     * Applies when the node values are unique in the tree
     */
    public static TreeNode fromPreorderAndInorderTraverse(int[] preorder, int[] inorder) {
        // record the position of inorder
        var pos = new HashMap<Integer, Integer>();
        for (var i = 0; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }

        return build(preorder, pos, 0, inorder.length - 1, 0);
    }

    private static TreeNode build(int[] preorder, HashMap<Integer, Integer> pos, int start, int end, int parentIndex) {
        if (start > end) {
            return null;
        }
        var parent = preorder[parentIndex];
        var node = new TreeNode(parent);
        // index of current parent in inorder array
        var index = pos.get(parent);
        var leftLen = index - start;
        var newParent = parentIndex + leftLen + 1;
        node.left = build(preorder, pos, start, index - 1, parentIndex + 1);
        node.right = build(preorder, pos, index + 1, end, newParent);

        return node;
    }

    public static void preorder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }

    public static void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        var node = findNode(root.left, val);
        if (node != null) {
            return node;
        }
        node = findNode(root.right, val);
        return node;
    }

    private static List<TreeNode> findPathToNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return List.of();
        }
        if (root == target) {
            return List.of(root);
        }

        var path = new ArrayList<TreeNode>();
        var subpath = findPathToNode(root.left, target);
        if (!subpath.isEmpty()) {
            path.add(root);
            path.addAll(subpath);
        } else {
            subpath = findPathToNode(root.right, target);
            if (!subpath.isEmpty()) {
                path.add(root);
                path.addAll(subpath);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        var root = Tree.fromPreorderAndInorderTraverse(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        var nodes = new ArrayList<Integer>();
        Tree.preorder(root, nodes);
        System.out.println(nodes);
        nodes.clear();
        Tree.inorder(root, nodes);
        System.out.println(nodes);

        root = Tree.fromHeap(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        nodes.clear();
        Tree.preorder(root, nodes);
        System.out.println(nodes);
    }
}
