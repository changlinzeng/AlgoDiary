package algo.unionfind;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfProvinces_547 {
    public static int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;
        var union = new int[n];
        var visited = new boolean[n];
        Arrays.fill(union, -1);
        for (var i = 0; i < n; i++) {
            union[i] = i;
        }

        for (var i = 0; i < n; i++) {
            for (var j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && union[i] != union[j]) {
                    // add j to i
                    int par = union[i], oldPar = union[j];
                    for (var k = 0; k < n; k++) {
                        if (union[k] == oldPar) {
                            union[k] = par;
                        }
                    }
                }
            }
        }

//        for (var i = 0; i < n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//            }
//            for (var j = i + 1; j < n; j++) {
//                if (visited[j]) {
//                    // connect two groups
//                    if (isConnected[i][j] == 1 && union[i] != union[j]) {
//                        var par = union[j];
//                        for (var k = 0; k < n; k++) {
//                            if (union[k] == par) {
//                                union[k] = union[i];
//                            }
//                        }
//                    }
//                } else {
//                    // add to group
//                    if (isConnected[i][j] == 1) {
//                        union[j] = i;
//                        if (i != j) {
//                            var k = j;
//                            while (union[k] != k) {
//                                k = union[k];
//                            }
//                            union[j] = k;
//                        }
//                        visited[j] = true;
//                    }
//                }
//            }
//        }

        var set = new HashSet<Integer>();
        for (var i = 0; i < n; i++) {
            set.add(union[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
        System.out.println(findCircleNum(new int[][] {{1,0,0}, {0,1,0}, {0,0,1}}));
        System.out.println(findCircleNum(new int[][] {{1,0,0,1},
                                                      {0,1,1,0},
                                                      {0,1,1,1},
                                                      {1,0,1,1}}));
    }
}
