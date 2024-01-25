package algo.breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;

public class ValidateBinaryTreeNodes_1361 {
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        var union = new int[n];
        for (var i = 0; i < n; i++) {
            union[i] = i;
        }

        for (var i = 0; i < leftChild.length; i++) {
            int parent = i, left = leftChild[i], right = rightChild[i];

            // child already in the tree. now we find a diamond
            if (left != -1 && union[left] != left) {
                return false;
            }
            if (right != -1 && union[right] != right) {
                return false;
            }
            // child pointing to parent
            if (left != -1 && union[parent] == left) {
                return false;
            }
            if (right != -1 && union[parent] == right) {
                return false;
            }
            if (left != -1) {
                var currentPar = union[left];
                for (var k = 0; k < n; k++) {
                    if (union[k] == currentPar) {
                        union[k] = union[parent];
                    }
                }
            }
            if (right != -1) {
                var currentPar = union[right];
                for (var k = 0; k < n; k++) {
                    if (union[k] == currentPar) {
                        union[k] = union[parent];
                    }
                }
            }
        }

        var prev = union[0];
        for (var p : union) {
            if (p != prev) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateBinaryTreeNodesBfs(int n, int[] leftChild, int[] rightChild) {
        var root = new HashSet<Integer>();
        var visited = new boolean[n];
        for (var i = 0; i < n; i++) {
            root.add(i);
        }
        for (var i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                root.remove(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                root.remove(rightChild[i]);
            }
        }
        if (root.size() != 1) {
            return false;
        }
        var node = root.iterator().next();
        return bfs(leftChild, rightChild, node, visited);
    }

    private static boolean bfs(int[] leftChild, int[] rightChild, int node, boolean[] visited) {
        var q = new LinkedList<Integer>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            var n = q.poll();
            for (var child : new int[]{leftChild[n], rightChild[n]}) {
                if (child == -1) {
                    continue;
                }
                if (visited[child]) {
                    return false;
                }
                visited[child] = true;
                q.offer(child);
            }
        }
        for (var v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateBinaryTreeNodesBfs(4, new int[]{1,-1,3,-1}, new int[] {2,-1,-1,-1}));
        System.out.println(validateBinaryTreeNodesBfs(4, new int[]{1,-1,3,-1}, new int[] {2,3,-1,-1}));
        System.out.println(validateBinaryTreeNodesBfs(2, new int[]{1,0}, new int[] {-1,-1}));
//        System.out.println(validateBinaryTreeNodes(4, new int[]{3,-1,1,-1}, new int[] {-1,-1,0,-1}));
        System.out.println(validateBinaryTreeNodesBfs(4, new int[]{1,0,3,-1}, new int[] {-1,-1,-1,-1}));
    }
}
