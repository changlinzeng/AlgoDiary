package algo.depthFirstSearch;

public class IsGraphBipartite_785 {
    public static boolean isBipartite(int[][] graph) {
        var vNum = graph.length;
        var color = new int[vNum];

        for (var i = 0; i < vNum; i++) {
            if (color[i] == 0) {
                if (!colorize(graph, color, -1, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean colorize(int[][] graph, int[] color, int from, int to) {
        if (color[to] == 0) {
            if (from != -1) {
                color[to] = color[from] == 1 ? 2 : 1;
            } else {
                // root
                color[to] = 1;
            }
        } else {
            if (from != -1 && color[to] == color[from]) {
                return false;
            }
            return true;
        }
        for (var v : graph[to]) {
            if (!colorize(graph, color, to, v)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{1,3},{0,2}}));
        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
        System.out.println(isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}}));
    }
}
