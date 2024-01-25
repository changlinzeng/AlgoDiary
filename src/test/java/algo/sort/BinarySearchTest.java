package algo.sort;

import algo.binarySearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

  @Test
  public void testBinarySearch() {
    int[] nums = new int[] {1, 3, 5};
    Assertions.assertEquals(0, BinarySearch.binarySearch(nums, 1));

    nums = new int[] {1, 3, 5};
    Assertions.assertEquals(-1, BinarySearch.binarySearch(nums, 2));

    nums = new int[] {1, 3, 5};
    Assertions.assertEquals(-1, BinarySearch.binarySearch(nums, 6));

    nums = new int[] {1};
    Assertions.assertEquals(0, BinarySearch.binarySearch(nums, 1));

    nums = new int[] {1};
    Assertions.assertEquals(-1, BinarySearch.binarySearch(nums, 2));
  }

  @Test
  public void testSearchFirstEqual() {
    int[] nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(1, BinarySearch.searchFirstEqual(nums, 3));

    nums = new int[] {1, 3, 5};
    Assertions.assertEquals(1, BinarySearch.searchFirstEqual(nums, 3));

    nums = new int[] {1, 3, 5};
    Assertions.assertEquals(0, BinarySearch.searchFirstEqual(nums, 1));

    nums = new int[] {1, 3, 5};
    Assertions.assertEquals(2, BinarySearch.searchFirstEqual(nums, 5));

    nums = new int[] {1, 1};
    Assertions.assertEquals(0, BinarySearch.searchFirstEqual(nums, 1));

    nums = new int[] {1};
    Assertions.assertEquals(0, BinarySearch.searchFirstEqual(nums, 1));
  }

  @Test
  public void testSearchFirstEqualOrGreater() {
    int[] nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(1, BinarySearch.searchFirstEqualOrGreater(nums, 3));

    nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(1, BinarySearch.searchFirstEqualOrGreater(nums, 2));

    nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(-1, BinarySearch.searchFirstEqualOrGreater(nums, 6));

    nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(3, BinarySearch.searchFirstEqualOrGreater(nums, 5));

    nums = new int[] {1, 3, 3, 5};
    Assertions.assertEquals(0, BinarySearch.searchFirstEqualOrGreater(nums, 0));
  }

  @Test
  public void testSearchLastEqualOrLess() {
    var nums = new int[]{1, 3, 5};
    Assertions.assertEquals(0, BinarySearch.searchLastEqualOrLess(nums, 1));
    Assertions.assertEquals(0, BinarySearch.searchLastEqualOrLess(nums, 2));
    Assertions.assertEquals(1, BinarySearch.searchLastEqualOrLess(nums, 3));
    Assertions.assertEquals(2, BinarySearch.searchLastEqualOrLess(nums, 5));
    Assertions.assertEquals(2, BinarySearch.searchLastEqualOrLess(nums, 6));
  }

}
