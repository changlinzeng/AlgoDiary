package data.hashMap;

import java.util.*;

public class FindOriginalArrayFromDoubledArray_2007 {
    public static int[] findOriginalArray(int[] changed) {
        var count = new HashMap<Integer, Integer>();  // count of numbers
        for (int num : changed) {
          count.put(num, count.getOrDefault(num, 0) + 1);
        }

        var original = new ArrayList<Integer>();
        Arrays.sort(changed);
        for (var num : changed) {
            if (count.get(num) == 0) {
                continue;
            }

            // do not find double, so return
            if (!count.containsKey(2 * num)) {
                return new int[]{};
            }

            original.add(num);
            count.put(num, count.get(num) - 1);
            count.put(num * 2, count.get(num * 2) - 1);
        }

        if (original.size() != changed.length / 2) {
            return new int[]{};
        }

        var result = new int[original.size()];
        for (var i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(findOriginalArray(new int[]{0,0,0,0})).forEach(System.out::println);
    }
}
