package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AllAncestorsOfANodeInADirectedAcyclicGraph_2192 {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        var ancestors= new ArrayList<TreeSet<Integer>>();
        var degree = new int[n];
        for (var i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
        }
        for (var edge : edges) {
            degree[edge[1]]++;
        }
        for (var i = 0; i < n; i++) {
            if (degree[i] == 0) {
                dfs(i, edges, ancestors);
            }
        }

        var result = new ArrayList<List<Integer>>();
        for (var a : ancestors) {
            result.add(new ArrayList<>(a));
        }
        return result;
    }

    private static void dfs(int node, int[][] edges, List<TreeSet<Integer>> ancestors) {
        for (var edge : edges) {
            if (edge[0] == node) {
                ancestors.get(edge[1]).addAll(ancestors.get(node));
                ancestors.get(edge[1]).add(node);
                dfs(edge[1], edges, ancestors);
            }
        }
    }

    public static void main(String[] args) {
        getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}).forEach(System.out::println);
        getAncestors(5, new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}).forEach(System.out::println);
    }
}
