package algo.sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting_969 {
    public static List<Integer> pancakeSort(int[] arr) {
        var len = arr.length;
        var result = new ArrayList<Integer>();
        // swap the max to the end
        var max = len;
        for (var i = len - 1; i > 0; i--) {
            for (var j = 0; j < i; j++) {
                if (arr[j] == max) {
                    reverse(arr, j);
                    result.add(j + 1);
                    reverse(arr, i);
                    result.add(i + 1);
                    break;
                }
            }
            max--;
        }

        return result;
    }

    private static void reverse(int[] arr, int pos) {
        int tmp;
        for (var i = 0; i <= pos / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[pos - i];
            arr[pos - i] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3,2,4,1}));
//        System.out.println(pancakeSort(new int[]{1,2,3}));
//        System.out.println(pancakeSort(new int[]{2,1,3}));
    }
}
