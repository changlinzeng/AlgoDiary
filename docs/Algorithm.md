# My Algorithm Diary

## 1. Sort

#### 1.1 Merge Sort
```java
    void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        var mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        // optimization for best cases. In this case, the first part and second part are already sorted
        if (nums[mid] > nums[mid + 1]) {
           merge(nums, start, mid, end);
        }
    }

    void merge(int[] nums, int start, int mid, int end) {
        int[] arr = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = nums[i++];
        }
        while (j <= end) {
            arr[k++] = nums[j++];
        }

        for (int m = start; m <= end; m++) {
            nums[m] = arr[m - start];
        }
    }
```

#### 1.2 Quick Sort
```java
    void quickSort(int[] nums, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int i = left, j = right - 1, pivot = nums[i];
        while (i < j){
            while(i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
    }
    nums[i] = pivot;
    quickSort(nums, left, i);
    quickSort(nums, i + 1, right);
}
```


> Quiz
> 1. [Pancake Sorting (LC-969 / Medium)](https://leetcode.com/problems/pancake-sorting/)
> 2. [Sort Colors (LC-75 / Medium)](https://leetcode.com/problems/sort-colors/)
> 3. [Shortest Unsorted Continuous Subarray (LC-581 / Medium)](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)
> 4. [Heaters (LC-475 / Medium)](https://leetcode.com/problems/heaters/)
> 5. [Merge k Sorted Lists (LC-23 / Hard)](https://leetcode.com/problems/merge-k-sorted-lists)

## 2. Backtrack
Backtrack is used to solve the permutation problem. Need to consider the duplicateds in the output, such as Subsets II (LC 90). Backtrack is actually a kind of bruce-force algorithm and it is usually in the form of iteration + recursion. So timeout complexity is high. We need to be careful on the performance.

> Quiz
> 1. [Subsets (LC-78 / Medium)](https://leetcode.com/problems/subsets)
> 2. [Subsets II (LC-90 / Medium)](https://leetcode.com/problems/subsets-ii) with duplicates in input
> 3. [Letter Combinations of a Phone Number (LC-17 / Medium)](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
> 4. [Generate Parentheses (LC-22 / Medium)](https://leetcode.com/problems/generate-parentheses/)
> 5. [Combination Sum (LC-39 / Medium)](https://leetcode.com/problems/combination-sum/description/)
> 6. [Combination Sum II (LC-40 / Medium)](https://leetcode.com/problems/combination-sum-ii)
> 7. [Combination Sum III (LC-216 / Medium)](https://leetcode.com/problems/combination-sum-iii/)
> 8. [Permutations (LC-46 / Medium)](https://leetcode.com/problems/permutations/)
> 9. [Permutations II (LC-47 / Medium)](https://leetcode.com/problems/permutations-ii)
> 10. [Permutation Sequence (LC-60 / Hard)](https://leetcode.com/problems/permutation-sequence)
> 11. [Combinations (LC-77 / Medium)](https://leetcode.com/problems/combinations)
> 12. [Letter Tile Possibilities (LC-1079 / Medium)](https://leetcode.com/problems/letter-tile-possibilities/)
> 13. [Maximum Length of a Concatenated String with Unique Characters (LC-1239 / Medium)](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters)
> 14. [Non-decreasing Subsequences (LC-491 / Medium)](https://leetcode.com/problems/non-decreasing-subsequences)

Sometimes we need to use memorization in backtrack to improve the speed
> 1. [Partition Equal Subset Sum (LC-416 / Medium)](https://leetcode.com/problems/partition-equal-subset-sum)
> 2. [Coin Change (LC-322 / Medium)](https://leetcode.com/problems/coin-change)

#### Bitmask is an efficient way to memorize the state
> 1. [Partition to K Equal Sum Subsets (LC-698 / Medium)](https://leetcode.com/problems/partition-to-k-equal-sum-subsets)
> 2. [Matchsticks to Square (LC-473 / Medium)](https://leetcode.com/problems/matchsticks-to-square)

## 3. Depth First Search
DFS can be used in tree, graph, array, string and other data structures to solve problems that has a **recursive subproblem**.

> Quiz
> 1. [Word Search (LC-79 / Medium)](https://leetcode.com/problems/word-search/)
> 2. [Word Search II (LC-212 / Hard)](https://leetcode.com/problems/word-search-ii/)
> 3. [Restore IP Addresses (LC-93 / Medium)](https://leetcode.com/problems/restore-ip-addresses)
> 4. [Path Sum II (LC-113 / Medium)](https://leetcode.com/problems/path-sum-ii)
> 5. [Surrounded Regions (LC-130 / Medium)](https://leetcode.com/problems/surrounded-regions)
> 6. [Word Break (LC-139 / Medium)](https://leetcode.com/problems/word-break)
> 7. [Number of Islands (LC-200 / Medium)](https://leetcode.com/problems/number-of-islands)
> 8. [Number of Closed Islands (LC-1254 / Medium)](https://leetcode.com/problems/number-of-closed-islands/)
> 10. [Minimum Height Trees (LC-310 / Medium)](https://leetcode.com/problems/minimum-height-trees/)
> 11. [Target Sum (LC-494 / Medium)](https://leetcode.com/problems/target-sum)
> 12. [Max Area of Island (LC-695 / Medium)](https://leetcode.com/problems/max-area-of-island)
> 13. [Is Graph Bipartite (LC-785 / Medium)](https://leetcode.com/problems/is-graph-bipartite)
> 14. [Possible Bipartition (LC-886 / Medium)](https://leetcode.com/problems/possible-bipartition/) LC-785 and LC-886 are the same
> 15. [Find Eventual Safe States (LC-802 / Medium)](https://leetcode.com/problems/find-eventual-safe-states)
> 16. [Shortest Bridge (LC-934 / Medium)](https://leetcode.com/problems/shortest-bridge)
> 17. [Number of Enclaves (LC-1020 / Medium)](https://leetcode.com/problems/number-of-enclaves/)
> 18. [Word Break II (LC-140 / Hard)](https://leetcode.com/problems/word-break-ii)
> 19. [Making A Large Island (LC-827 / Hard)](https://leetcode.com/problems/making-a-large-island)

There is a kind of problems that can be solved with DFS on strings, such as
> 1. [Decode String (LC-394 / Medium)](https://leetcode.com/problems/decode-string/)

#### DFS with Memorization

In order to reduce the time for DFS, we can use memorization to record the state for some problems
> Quiz
> 1. [Frog Jump (LC-403 / Hard)](https://leetcode.com/problems/frog-jump)
> 2. [Longest Increasing Path in a Matrix (LC-329 / Hard)](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/)
> 3. [Wildcard Matching (LC-44 / Hard)](https://leetcode.com/problems/wildcard-matching)
> 4. [Regular Expression Matching (LC-10 / Hard)](https://leetcode.com/problems/regular-expression-matching) Same as LC-44 Wildcard Matching
> 5. [Word Break (LC-139 / Medium)](https://leetcode.com/problems/word-break)
> 6. [Ones and Zeroes (LC-474 / Medium)](https://leetcode.com/problems/ones-and-zeroes)

#### DFS with Trie
Like word search problems, we can build Trie with the words to be searched and then DFS with the Trie.
It enabled us to search with the prefix instead of searching word one by one
> 1. [Word Search II (LC-212 / Hard)](https://leetcode.com/problems/word-search-ii)

## 4. Breadth First Search
BFS is commonly used in level traversal of a tree or graph. It can also be used in some state transformation problems, such as Word Ladder and Sliding Puzzle.
> Quiz
> 1. [Binary Tree Zigzag Level Order Traversal (LC-103 / Medium)](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal)
> 2. [Binary Tree Level Order Traversal II (LC-107 / Medium)](https://leetcode.com/problems/binary-tree-level-order-traversal-ii)
> 3. [Word Ladder (LC-127 / Hard)](https://leetcode.com/problems/word-ladder/)
> 4. [Sliding Puzzle (LC-773 / Hard)](https://leetcode.com/problems/sliding-puzzle/)
> 5. Shortest Distance from All Buildings (LC-317 / Hard)
> 6. [Open the Lock (LC-752 / Medium)](https://leetcode.com/problems/open-the-lock)
> 7. [Minimum Genetic Mutation (LC-433 / Medium)](https://leetcode.com/problems/minimum-genetic-mutation)
> 8. [Time Needed to Inform All Employees (LC-1376 / Medium)](https://leetcode.com/problems/time-needed-to-inform-all-employees)

## 5. Binary Search
Binary search has the time complexity of O(logN). It requires the array to be sorted. There are some common binary search problems

#### 5.1 Search target value
```java
  public int binarySearch(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    while (begin <= end) {
      int mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }
    return -1;
  }
```

#### 5.2 Search first occurrence
```java
  public int searchFirstEqual(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    while (begin <= end) {
      int mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        // check if previous element equals to target
        if (mid > 0 && target == nums[mid - 1]) {
          end = mid - 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }
    return -1;
  }
```

#### 5.3 Search first element equal to or greater than target value
```java
  public int searchFirstEqualOrGreater(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    int mid = begin + (end - begin) / 2;
    while (begin <= end) {
      mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        // check if previous element equals to target
        if (mid > 0 && target == nums[mid - 1]) {
          end = mid - 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }

    if (target > nums[mid]) {
      return mid < nums.length - 1 ? mid + 1 : -1;
    } else {
      return mid;
    }
  }
```

#### 5.4 Search last element equal to or less than target value
```java
  public int searchLastEqualOrLess(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid;

    while (start < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        if (mid < nums.length - 1 && nums[mid + 1] > target) {
          return mid;
        } else if (mid < nums.length - 1 && nums[mid + 1] == target) {
          return mid + 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (mid > 0 && nums[mid - 1] <= target) {
          return mid - 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return start;
  }
```

#### 5.5 Search in rotated array
```java
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > nums[low]) {  // in the upper
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {  // in the lower
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // low = high - 1
                if (mid == low) {
                    low++;
                }
                if (mid == high) {
                    high--;
                }
            }
        }
        return -1;
    }
```

**With duplicates in sorted array**
```java
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[low]) {  // in upper section
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high]) {  // in lower section
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] == nums[low]) {
                    low++;
                }
                if (nums[mid] == nums[high]) {
                    high--;
                }
            }
        }

        return false;
    }
```

#### 5.6 Find minimum in rotated array
```java
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // nums[low] < nums[high] means we are on either the
            // left side or the right side in an increasing order
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
```

**With duplicates in sorted array**
```java
  public static int findMin(int[] nums) {
    // 4 4 5 6 7 0 0 1 3 4
    int len = nums.length, low = 0, high = len - 1;
    if (nums[0] < nums[len - 1]) {
      return nums[0];
    }

    while (low < high) {
      var mid = low + (high - low) / 2;
      if (mid == low) {
        return Math.min(nums[low], nums[high]);
      } else {
        // determine which side we are on
        var allEqual = true;
        if (nums[low] == nums[high] && nums[mid] == nums[low]) {
          for (var i = low; i < mid; i++) {
            if (nums[i] < nums[low]) {
              // on the right
              allEqual = false;
              high = mid;
              break;
            }
          }
          for (var i = mid; i < high; i++) {
            if (nums[i] < nums[low]) {
              // on the left
              allEqual = false;
              low = mid;
              break;
            }
          }
          // all elements are equal
          if (allEqual) {
            return nums[mid];
          }
        } else if (nums[mid] >= nums[low]) {
          // on the left
          while (mid < high && nums[mid] == nums[high] && nums[mid + 1] == nums[low]) {
            mid++;
          }
          low = mid;
        } else if (nums[mid] <= nums[high]) {
          // on the right
          while (mid > low && nums[mid] == nums[high] && nums[mid - 1] == nums[high]) {
            mid--;
          }
          high = mid;
        }
      }
    }
    return nums[low];
  }
```

> Quiz
> 1. [Find First and Last Position of Element in Sorted Array (LC-34 / Medium)](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)
> 2. [Search in Rotated Sorted Array (LC-33 / Medium)](https://leetcode.com/problems/search-in-rotated-sorted-array)
> 3. [Search in Rotated Sorted Array II (LC-81 / Medium)](https://leetcode.com/problems/search-in-rotated-sorted-array-ii)
> 4. [Find Minimum in Rotated Sorted Array (LC-153 / Medium)](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
> 5. [Find Minimum in Rotated Sorted Array II (LC-154 / Hard)](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)
> 6. [H Index (LC-274 / Medium)](https://leetcode.com/problems/h-index)
> 7. [Find K Closest Elements (LC-658 / Medium)](https://leetcode.com/problems/find-k-closest-elements/)

## 6. Two Pointers / Sliding Window
> Quiz
> 1. [Longest Substring Without Repeating Characters (LC-3 / Medium)](https://leetcode.com/problems/longest-substring-without-repeating-characters)
> 2. [Median of Two Sorted Arrays (LC-4 / Hard)](https://leetcode.com/problems/median-of-two-sorted-arrays)
> 3. [Container With Most Water (LC-11 / Medium)](https://leetcode.com/problems/container-with-most-water)
> 4. [3Sum Closest (LC-16 / Medium)](https://leetcode.com/problems/3sum-closest)
> 5. [Trapping Rain Water (LC-42 / Hard)](https://leetcode.com/problems/trapping-rain-water)
> 6. [MinimumWindowSubstring (LC-76 / Hard)](https://leetcode.com/problems/minimum-window-substring/)
> 7. [Minimum Size Subarray Sum (LC-209 / Medium)](https://leetcode.com/problems/minimum-size-subarray-sum)
> 8. [String Compression (LC-443 / Medium)](https://leetcode.com/problems/string-compression/)
> 9. [Sliding Window Maximum (LC-239 / Hard)](https://leetcode.com/problems/sliding-window-maximum)
> 10. [Reverse Words in a String (LC-151 / Medium)](https://leetcode.com/problems/reverse-words-in-string)
> 11. [Reverse Words In a String II (LC-186 / Medium)](https://leetcode.ca/2016-06-03-186-Reverse-Words-in-a-String-II/)
> 12. [Longest Repeating Character Replacement (LC-424 / Medium)](https://leetcode.com/problems/longest-repeating-character-replacement)
> 13. [Push Dominoes (LC-838 / Medium)](https://leetcode.com/problems/push-dominoes)
> 14. [Boats to Save People (LC-881 / Medium)](https://leetcode.com/problems/boats-to-save-people)
> 15. [Interval List Intersections (LC-986 / Medium)](https://leetcode.com/problems/interval-list-intersections)
> 16. [Swap For Longest Repeated Character Substring (LC-1156 / Medium)](https://leetcode.com/problems/swap-for-longest-repeated-character-substring)
> 17. [Get Equal Substrings Within Budget (LC-1208 / Medium)](https://leetcode.com/problems/get-equal-substrings-within-budget)
> 18. [Replace the Substring for Balanced String (LC-1234 / Medium)](https://leetcode.com/problems/replace-the-substring-for-balanced-string)
> 19. [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (LC-1438 / Medium)](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit)
> 20. [Maximum Length of Subarray With Positive Product (LC-1567 / Medium)](https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product)
> 21. [Minimum Operations to Reduce X to Zero (LC-1658 / Medium)](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero)
> 22. [Shortest Unsorted Continuous Subarray (LC-581 / Medium)](https://leetcode.com/problems/shortest-unsorted-continuous-subarray)

## 7. Sequence
> Quiz
> 1. [Non-decreasing Array (LC-665 / Medium)](https://leetcode.com/problems/non-decreasing-array)
> 2. [Longest Consecutive Sequence (LC-128 / Medium)](https://leetcode.com/problems/longest-consecutive-sequence/)
> 3. [Longest Subarray of 1's After Deleting One Element (LC-1493 / Medium)](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element)
> 4. [Longest Substring with At Least K Repeating Characters (LC-395 / Medium)](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters)
> 5. [Longest Increasing Subsequence (LC-300 / Medium)](https://leetcode.com/problems/longest-increasing-subsequence/)

## 8. Prefix Sum
Sum subarray from 0 to position i
> Quiz
> 1. [Continuous Subarray Sum (LC-523 / Medium)](https://leetcode.com/problems/continuous-subarray-sum)
> 2. [Subarray Sum Equals K (LC-560 / Medium)](https://leetcode.com/problems/subarray-sum-equals-k)

## 9. Interval
Interval is an array of tuples int[n][2] and the questions include
- Merge
- Find intersection

> Quiz
> 1. [Merge Intervals (LC-56 / Medium)](https://leetcode.com/problems/merge-intervals/)
> 2. [Insert Interval (LC-57 / Medium)](https://leetcode.com/problems/insert-interval/)
> 3. [Non-overlapping Intervals (LC-435 / Medium)](https://leetcode.com/problems/non-overlapping-intervals/)
> 4. [Find Right Interval (LC-436 / Medium)](https://leetcode.com/problems/find-right-interval/)
> 5. [Interval List Intersections (LC-986 / Medium)](https://leetcode.com/problems/interval-list-intersections)

## Calculator
> Quiz
> 1. [Basic Calculator (LC-224 / Hard)](https://leetcode.com/problems/basic-calculator/)
     > This can be solved by DFS or with Stack only. Once we see a left parenthesis "(" we push current result onto stack and then calculate the result between "(" and ")"
> 2. [Basic Calculator II (LC-227 / Medium)](https://leetcode.com/problems/basic-calculator-ii/)
     > This can be solved by simply using a stack
> 3. [Basic Calculator III (LC-772 / Hard)](https://leetcode.ca/2018-01-10-772-Basic-Calculator-III/)
> 4. [Basic Calculator IV (LC-770 / Hard)](https://leetcode.com/problems/basic-calculator-iv/)
>

## 10. DP
DP is used to solve a complex problem by breaking it down to subproblems. The problem should have the two features below to be solved with DP
- **Overlapping Subproblems**: The problem can be divided into a number of subproblems of similar type but of smaller size than the original one
- **Optimal Substructure Property**: The optimal solution to the problem can be formulated from the optimal solution to its subproblems

The most importance thing in DP is to find the state transit formula.


### One Dimension
> 1. [House Robber (LC-198 / Medium)](https://leetcode.com/problems/house-robber)
> 2. [House Robber II (LC-213 / Medium)](https://leetcode.com/problems/house-robber-ii)
> 3. [Arithmetic Slices (LC-413 / Medium)](https://leetcode.com/problems/arithmetic-slices/)
### Two dimension
> 1. [01 Matrix (LC-542 / Medium)](https://leetcode.com/problems/01-matrix)
> 2. [Maximal Square (LC-221 / Medium)](https://leetcode.com/problems/maximal-square)
### Combination / Subset
> 1. [Perfect Squares (LC-279 / Medium)](https://leetcode.com/problems/perfect-squares/)
> 2. [Decode Ways (LC-91 / Medium)](https://leetcode.com/problems/decode-ways)
> 3. [Word Break (LC-139 / Medium)](https://leetcode.com/problems/word-break)
### Subsequence
> 1. [Longest Increasing Subsequence (LC-300 / Medium)](https://leetcode.com/problems/longest-increasing-subsequence)
```java
    for (int i = 1; i < len; i++) {      
        // find previous numbers smaller than nums[i]
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxlen = Math.max(maxlen, dp[i]);
    }
```
> 2. [Longest Common Subsequence (LC-1143 / Medium)](https://leetcode.com/problems/longest-common-subsequence)
```java
    //    a   b   c   d   e
    // a  1   1   1   1   1
    // c  1   1   2   2   2
    // e  1   1   2   2   3
    int len1 = text1.length(), len2 = text2.length();
    var dp = new int[len2 + 1][len1 + 1];
    for (var i = 1; i <= len2; i++) {
        for (var j = 1; j <= len1; j++) {
            if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[len2][len1];
```
> 3. [Distinct Subsequences (LC-115 / Hard)](https://leetcode.com/problems/distinct-subsequences)
```java
/**
 *    b   a   b   g   b   a   g
 * b  1   1   2   2   3   3   3
 * a  0  (1)  1   1   1  (4)  4
 * g  0   0   0   1   1   1  (5)
*/
    for (var i = 1; i < tlen; i++) {
        for (var j = 1; j < slen; j++) {
            if (t.charAt(i) == s.charAt(j)) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            } else {
                dp[i][j] = dp[i][j - 1];
            }
        }
    }
```
### Knapsack
#### 01 Knapsack
> 1. [Partition Equal Subset Sum (LC-416 / Medium)](https://leetcode.com/problems/partition-equal-subset-sum)
> 2. [Ones and Zeroes (LC-474 / Medium)](https://leetcode.com/problems/ones-and-zeroes)
> 3. [Coin Change (LC-322 / Medium)](https://leetcode.com/problems/coin-change)
#### Unbounded Knapsack
### String
### Stock Trade

> Quiz
> 1. [Jump Game (LC-55 / Medium)](https://leetcode.com/problems/jump-game)
> 2. [Jump Game II (LC-45 / Medium)](https://leetcode.com/problems/jump-game-ii)
> 3. [Jump Game VI (LC-1696 / Medium)](https://leetcode.com/problems/jump-game-vi)
> 4. [Maximum Subarray (LC-53 / Medium)](https://leetcode.com/problems/maximum-subarray)
> 5. [Unique Paths (LC-62 / Medium)](https://leetcode.com/problems/unique-paths)
> 6. [Unique Paths II (LC-63 / Medium)](https://leetcode.com/problems/unique-paths-ii)
> 7. [Minimum Path Sum (LC-64 / Medium)](https://leetcode.com/problems/minimum-path-sum)
> 8. [Climbing Stairs (LC-70 / Easy)](https://leetcode.com/problems/climbing-stairs)
> 9. [Decode Ways (LC-91 / Medium)](https://leetcode.com/problems/decode-ways)
> 10. [Unique Binary Search Trees (LC-96 / Medium)](https://leetcode.com/problems/unique-binary-search-trees)
> 11. [Distinct Subsequences (LC-115 / Hard)](https://leetcode.com/problems/distinct-subsequences)
> 12. [Best Time to Buy and Sell Stock III (LC-123 / Medium)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii)
> 13. [Maximum Product Subarray (LC-152 / Medium)](https://leetcode.com/problems/maximum-product-subarray)
> 14. [House Robber (LC-198 / Medium)](https://leetcode.com/problems/house-robber)
> 15. [House Robber II (LC-213 / Medium)](https://leetcode.com/problems/house-robber-ii)
> 16. [Maximal Square (LC-221 / Medium)](https://leetcode.com/problems/maximal-square)
> 17. [Perfect Squares (LC-279 / Medium)](https://leetcode.com/problems/perfect-squares)
> 18. [Largest Divisible Subset (LC-368 / Medium)](https://leetcode.com/problems/largest-divisible-subset)
> 19. [Wiggle Subsequence (LC-376 / Medium)](https://leetcode.com/problems/wiggle-subsequence)
> 20. [Longest Turbulent Subarray (LC-978 / Medium)](https://leetcode.com/problems/longest-turbulent-subarray)
> 21. [Arithmetic Slices (LC-413 / Medium)](https://leetcode.com/problems/arithmetic-slices)
> 22. [Unique Substrings in Wraparound String (LC-467 / Medium)](https://leetcode.com/problems/unique-substrings-in-wraparound-string)
> 23. [Longest Palindromic Subsequence (LC-516 / Medium)](https://leetcode.com/problems/longest-palindromic-subsequence)
> 24. [Contiguous Array (LC-525 / Medium)](https://leetcode.com/problems/contiguous-array)
> 25. [Palindromic Substrings (LC-647 / Medium)](https://leetcode.com/problems/palindromic-substrings)
> 26. [Subarray Product Less Than K (LC-713 / Medium)](https://leetcode.com/problems/subarray-product-less-than-k)
> 27. [Maximum Length of Repeated Subarray (LC-718 / Medium)](https://leetcode.com/problems/maximum-length-of-repeated-subarray)
> 28. [Sum of Subarray Minimums (LC-907 / Medium)](https://leetcode.com/problems/sum-of-subarray-minimums)
> 29. [Dice Roll Simulation (LC-1223 / Hard)](https://leetcode.com/problems/dice-roll-simulation)
> 30. [Find Two Non-overlapping Sub-arrays Each With Target Sum (LC-1477 / Medium)](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum)
> 31. [Number of Sub-arrays With Odd Sum (LC-1524)](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum)

## 11. Greedy
To use greedy algorithm, we have the assumption that local optimal choice will lead to global optimal solution. But it is not always this case
> Quiz
> 1. [Split Array into Consecutive Subsequences (LC-659 / Medium)](https://leetcode.com/problems/split-array-into-consecutive-subsequences)
> 2. [Course Schedule III (LC-630 / Hard)](https://leetcode.com/problems/course-schedule-iii)

## 12. Find Duplicates
> Quiz
> 1. [Find All Duplicates in an Array (LC-442 / Medium)](https://leetcode.com/problems/find-all-duplicates-in-an-array)

## 13. Math