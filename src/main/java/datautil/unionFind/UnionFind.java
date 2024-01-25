package datautil.unionFind;

public class UnionFind {
    private final int[] roots;

    public UnionFind(int capacity) {
        roots = new int[capacity];
        for (var i = 0; i < capacity; i++) {
            roots[i] = i;
        }
    }

    public int find(int v) {
        return roots[v];
    }

    public void union(int v1, int v2) {
        var r1 = find(v1);
        var r2 = find(v2);

        if (r1 == r2) {
            return;
        }

        for (var i = 0; i < roots.length; i++) {
            if (roots[i] == r1) {
                roots[i] = r2;
            }
        }
    }

    public boolean sameRoot(int v1, int v2) {
        return find(v1) == find(v2);
    }
}
