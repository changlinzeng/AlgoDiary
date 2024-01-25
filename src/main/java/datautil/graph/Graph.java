package datautil.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public Map<Vertex, List<Vertex>> nodes = new HashMap<>();

    public void addSibling(int vertex, int sibling, int weight) {
        var node = new Vertex(vertex);
        var sib = new Vertex(sibling, weight);
        if (!nodes.containsKey(node)) {
            nodes.put(node, new ArrayList<>());
        }
        nodes.get(node).add(sib);
    }

    public static Graph fromAdjacentMatrix(int[][] matrix) {
        var graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                var w = matrix[i][j];
                if (w != 0) {
                    graph.addSibling(i, j, w);
                }
            }
        }

        return graph;
    }

    public static int[][] buildAdjacentMatrix(int numberOfVertices, int[][] weight) {
        var matrix = new int[numberOfVertices][numberOfVertices];
        for (var w : weight) {
            matrix[w[0]][w[1]] = w[2];
        }

        return matrix;
    }

    public static Map<Vertex, List<Vertex>> buildAdjacentMap(int[][] weight) {
        var graph = new Graph();
        for (var w : weight) {
            graph.addSibling(w[0], w[1], w[2]);
        }

        return graph.nodes;
    }
}
