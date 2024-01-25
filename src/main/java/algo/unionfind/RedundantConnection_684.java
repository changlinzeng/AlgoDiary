package algo.unionfind;

public class RedundantConnection_684 {
    public static int[] findRedundantConnection(int[][] edges) {
        // union find. Add edge one by one and if there are two nodes in one edge already
        // in the unionfind, then we can remove it
        var n = edges.length;
        var union = new int[n + 1];

        for (var edge : edges) {
            var from = edge[0];
            var to = edge[1];

            // two nodes in one edge already counted so it is a cycle now
            if (union[from] != 0 && union[to] != 0 && union[from] == union[to]) {
                return new int[]{from, to};
            }

            if (union[from] != 0 && union[to] != 0) {
                // join two group
                var target = union[to];
                for (var i = 1; i <= n; i++) {
                    if (union[i] == target) {
                        union[i] = union[from];
                    }
                }
            } else if (union[from] != 0) {
                union[to] = union[from];
            } else if (union[to] != 0) {
                union[from] = union[to];
            } else {
                union[from] = from;
                union[to] = from;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
//        var edge = findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
//        var edge = findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}});
        var edge = findRedundantConnection(new int[][]{{1,5},{3,4},{3,5},{4,5},{2,4}});
        System.out.println(edge[0] + ":" + edge[1]);

    }
}
