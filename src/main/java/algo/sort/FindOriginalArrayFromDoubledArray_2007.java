package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class FindOriginalArrayFromDoubledArray_2007 {
    public static int[] findOriginalArray(int[] changed) {
        var len = changed.length;
        if (len % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);

        var visited = new boolean[len];
        var origin = new ArrayList<Integer>();
        for (var i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            for (var j = i + 1; j < len; j++) {
                if (visited[j]) {
                    continue;
                }
                if (changed[i] * 2 == changed[j]) {
                    origin.add(changed[i]);
                    visited[i] = true;
                    visited[j] = true;
                    break;
                }
            }
        }

        if (origin.size() != len / 2) {
            return new int[0];
        }

        var result = new int[origin.size()];
        for (var i = 0; i < origin.size(); i++) {
            result[i] = origin.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(findOriginalArray(new int[]{0,0,0,0})).forEach(System.out::println);
    }
}
