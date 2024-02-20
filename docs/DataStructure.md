# My Data Structure Diary

## 1. Array
When we see arrays, there are usually the following questions
- Sort
- Color sort
- DP with min/max stack
- Permutations and anagrams with backtrack
- Binary search
- Two pointers
- Subarray Sum

> Quiz
> 1. [Subarray Product Less Than K (LC-713 / Medium)](https://leetcode.com/problems/subarray-product-less-than-k/)
> 2. [Shortest Subarray with Sum at Least K (LC-862 / Hard)](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)

## 2. String
- Pattern match
- Two dimension DP, usually in string match

Besides traditional pattern match, there are other ways of compare two string that I think are another kind of patter nmatch, be it
- if chars in two have the same occurrence
- if set of strings have common prefix
- if two strings have shared chars
- if a string is a subsequence of another string, meaning chars have the same sequence but not consecutive

> Quiz
> 1. [Longest Palindromic Substring (LC-5 / Medium)](https://leetcode.com/problems/longest-palindromic-substring)
> 2. [Partition Labels (LC-763 / Medium)](https://leetcode.com/problems/partition-labels)
> 3. [Minimum Window Subsequence (LC-727 / Hard)](https://leetcode.com/discuss/interview-question/algorithms/125014/microsoft-minimum-window-subsequence)
> 4. [String to Integer (atoi) (LC-8 / Medium)](https://leetcode.com/problems/string-to-integer-atoi/)
> 5. [Repeated String Match (LC-686 / Medium)](https://leetcode.com/problems/repeated-string-match/)
> 6. [Longest Substring with At Least K Repeating Characters (LC-395 / Medium)](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters)
> 7. [Find All Anagrams in a String (LC-438 / Medium)](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
> 8. [Swap For Longest Repeated Character Substring (LC-1156 / Medium)](https://leetcode.com/problems/swap-for-longest-repeated-character-substring)
> 9. [Minimum Deletions to Make String Balanced (LC-1653 / Medium)](https://leetcode.com/problems/minimum-deletions-to-make-string-balanced)


## 3. Matrix
Matrix is a two dimension array
- Two dimension binary search
- Depth first search
- Spiral matrix
> Quiz
> 1. [Rotate Image (LC-48 / Medium)](https://leetcode.com/problems/rotate-image/)
> 2. [Spiral Matrix (LC-54 / Medium)](https://leetcode.com/problems/spiral-matrix/)
> 3. [Spiral Matrix II (LC-59 / Medium)](https://leetcode.com/problems/spiral-matrix-ii)
> 4. [Maximum Square (LC-221 / Medium)](https://leetcode.com/problems/maximal-square/)
> 5. [Kth Smallest Element in a Sorted Matrix (LC-378 / Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

## 4. Linked List
Operations of linked list include:
- Sort
- Reverse list
- Merge list
- Find middle of linked list
- Check circle in linked list

> Quiz
> 1. [Insertion Sort List (LC-147 / Medium)](https://leetcode.com/problems/insertion-sort-list/)
> 2. [Sort List (LC-148 / Medium)](https://leetcode.com/problems/sort-list/)
> 3. [Merge k Sorted Lists (LC-23 / Hard)](https://leetcode.com/problems/merge-k-sorted-lists/)
> 4. [Add Two Numbers (LC-2 / Medium)](https://leetcode.com/problems/add-two-numbers/)
> 5. [Add Two Numbers II (LC-445 / Medium)](https://leetcode.com/problems/add-two-numbers-ii/)
> 6. [Swap Nodes in Pairs (LC-24 / Medium)](https://leetcode.com/problems/swap-nodes-in-pairs/)
> 7. [Reverse Nodes in k-Group (LC-25 / Hard)](https://leetcode.com/problems/reverse-nodes-in-k-group/)
> 8. [Rotate List (LC-61 / Medium)](https://leetcode.com/problems/rotate-list/)
> 9. [Partition List (LC-86 / Medium)](https://leetcode.com/problems/partition-list/)
> 10. [Copy List with Random Pointer (LC-138 / Medium)](https://leetcode.com/problems/copy-list-with-random-pointer/)
> 11. [Reorder List (LC-143 / Medium)](https://leetcode.com/problems/reorder-list/description/)
> 12. [Flatten a Multilevel Doubly Linked List (LC-430 / Medium)](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list)

## 5. Priority Queue
Priority queue is usually implmented with min/max heap. It is commonly used to solve to top K problems. Quick select can also be used to solve the top K problems. Time complexity of quick select is O(n) and space complexity is O(1). In worst cases, time complexity will be O(n^2)
> Quiz
> 1. [Top K Frequent Words (LC-692 / Medium)](https://leetcode.com/problems/top-k-frequent-words)
> 2. [Task Scheduler (LC-621 / Medium)](https://leetcode.com/problems/task-scheduler/)
> 3. [Reorganize String (LC-767 / Medium)](https://leetcode.com/problems/reorganize-string/)
> 4. [Find K Pairs with Smallest Sums (LC-373 / Medium)](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)
> 5. [Kth Largest Element in an Array (LC-215 / Medium)](https://leetcode.com/problems/kth-largest-element-in-an-array)

## 6. Min/Max Stack
Min/Max stack maintains an increasing/decreasing sequence. It is usually used to solve the next greater problems.
> Quiz
> 1. [Next Greater Node In Linked List (LC-1019 / Medium)](https://leetcode.com/problems/next-greater-node-in-linked-list/)
> 2. [Daily Temperatures (LC-739 / Medium)](https://leetcode.com/problems/daily-temperatures)
> 3. [Find the Most Competitive Subsequence (LC-1673 / Medium)](https://leetcode.com/problems/find-the-most-competitive-subsequence/)
> 4. [Remove K Digits (LC-402 / Medium)](https://leetcode.com/problems/remove-k-digits/) Similar as LC-1673
> 5. [Next Greater Element II (LC-503 / Medium)](https://leetcode.com/problems/next-greater-element-ii)
> 6. [Remove All Adjacent Duplicates in String II (LC-1209 / Medium)](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii)
> 7. [Reverse Substrings Between Each Pair of Parentheses (LC-1190 / Medium)](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses)
> 8. [Score of Parentheses (LC-856 / Medium)](https://leetcode.com/problems/score-of-parentheses)
> 9. [Simplify Path (LC-71 / Medium)](https://leetcode.com/problems/simplify-path/)
> 10. [Validate Stack Sequences (LC-946 / Medium)](https://leetcode.com/problems/validate-stack-sequences)
> 11. [Remove Duplicate Letters (LC-316 / Medium)](https://leetcode.com/problems/remove-duplicate-letters)
> 12. [Decode String (LC-394 / Medium)](https://leetcode.com/problems/decode-string/)
> 13. [Minimum Remove to Make Valid Parentheses (LC-1249 / Medium)](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses)

## 7. Graph
Graph can be **directed** or **unidirected**. Directed graph can be directed acyclic graph (DAG)

Graph can be described in two ways
1. Adjascent Matrix
2. Adjascent List

Common problems related to graph include
- #### Breadth First Search
BFS uses a queue to hold the nodes for each level. For unidirected graph, we usually use an array to record whether the node is visited to prevent dead loop.

Time complexity is O(|V| + |E|) and space is O(|V|)

- #### Depth first search
DFS is a recursive process and but we can also use stack.

Time complexity is O(|V| + |E|). Space complexity is O(|V|)

- #### Topology sort
- #### Cyclic check
```java
  public boolean checkCycle(Map<Integer, List<Integer>> adjMap, int node, int[] color, boolean[] visited) {
    switch (color[node]) {
      // mark the node as visited
      case 0 -> color[node] = 1;
      case 1 -> {
        // find cycle
        return false;
      }
      case 2 -> {
        return true;
      }
    }
    for (var child : adjMap.get(node)) {
      if (!checkCycle(adjMap, child, color, visited)) {
        return false;
      }
    }
    // mark node as confirmed if all children are confirmed
    color[node] = 2;
    visited[node] = true;
    return true;
  }
```
> Quiz
> 1. [Find Eventual Safe States (LC-802 / Medium)](https://leetcode.com/problems/find-eventual-safe-states)
> 2. [Course Schedule (LC-207 / Medium)](https://leetcode.com/problems/course-schedule/)

- #### Shortest Path

|                 | BFS           | Dijkstra      | Bellman-Ford  | Floyd     |
|-----------------|:--------------|:--------------|---------------|-----------|
| Non-weighted    | OK            | OK            | OK            | OK        |
| Weighted        | X             | OK            | OK            | OK        |
| Negative weight | X             | X             | OK            | OK        |
| Time Complexity | O(V+E)        | O(V^2)        | O(VE)         | O(V^3)    |
| Usage           | Single source | Single source | Single source | All nodes |

##### Dijkstra

```java
  public void dijkstra(Map<Integer, List<int[]>> adjMap, int k, int[] cost, boolean[] visited) {
    var pq = new PriorityQueue<Integer>(Comparator.comparingInt(a -> cost[a]));
    pq.offer(k);
    while (!pq.isEmpty()) {
      var node = pq.poll();
      if (visited[node]) {
        continue;
      }
      if (!adjMap.containsKey(node)) {
        continue;
      }
      visited[node] = true;
      for (var next : adjMap.get(node)) {
        int sibling = next[0], distance = next[1];
        // update cost with min cost
        cost[sibling] = Math.min(cost[sibling], cost[node] + distance);
        pq.offer(sibling);
      }
    }
  }
```

> Quiz
> 1. [Course Schedule II (LC-210 / Medium)](https://leetcode.com/problems/course-schedule-ii/)
> 2. [Course Schedule IV (LC-1462 / Medium)](https://leetcode.com/problems/course-schedule-iv/)
> 3. [Network Delay Time (LC-743 / Medium)](https://leetcode.com/problems/network-delay-time/)
> 4. [Cheapest Flights Within K Stops (LC-787 / Medium)](https://leetcode.com/problems/cheapest-flights-within-k-stops/)


## 8. Binary Tree
#### - BST
#### - Red Black Tree
#### - Interval Tree
#### - Segment Tree
#### - Depth First Search
#### - Level Order Traverse
#### - Serialize/Deserialize
> Quiz
> 1. [Serialize and Deserialize Binary Tree (LC-297 / Hard)](https://leetcode.com/problems/serialize-and-deserialize-binary-tree)
> 2. [Construct Binary Tree from Preorder and Inorder Traversal (LC-105 / Medium)](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
> 3. [Construct Binary Tree from Inorder and Postorder Traversal (LC-106 / Medium)](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)
> 4. [Construct Binary Search Tree from Preorder Traversal (LC-1008 / Medium)](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal)
> 5. [Verify Preorder Serialization of a Binary Tree (LC-331 / Medium)](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree)
> 6. [Maximum Binary Tree (LC-654 / Medium)](https://leetcode.com/problems/maximum-binary-tree)

#### - Path Sum
> Quiz
> 1. [Binary Tree Maximum Path Sum (LC-124 / Hard)](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
> 2. [Sum Root to Leaf Numbers (LC-129 / Medium)](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
> 3. [Path Sum III (LC-437 / Medium)](https://leetcode.com/problems/path-sum-iii)
> 4. [Deepest Leaves Sum (LC-1302 / Medium)](https://leetcode.com/problems/deepest-leaves-sum/)
> 5. [Most Frequent Subtree Sum (LC-508 / Medium)](https://leetcode.com/problems/most-frequent-subtree-sum/)
> 6. [Convert BST to Greater Tree (LC-538 / Medium)](https://leetcode.com/problems/convert-bst-to-greater-tree/)
> 7. [Binary Search Tree to Greater Sum Tree (LC-1038 / Medium)](https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree)
> 8. [Maximum Sum BST in Binary Tree (LC-1373 / Hard)](https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/)

> Quiz
> 1. [Check Completeness of a Binary Tree (LC-958 / Medium)](https://leetcode.com/problems/check-completeness-of-a-binary-tree)
> 2. [Validate Binary Search Tree (LC-98 / Medium)](https://leetcode.com/problems/validate-binary-search-tree)
> 3. [Flatten Binary Tree to Linked List (LC-114 / Medium)](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)
> 4. [Lowest Common Ancestor of a Binary Search Tree (LC-235 / Medium)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
> 5. [Lowest Common Ancestor of a Binary Tree (LC-236 / Medium)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
> 6. [Lowest Common Ancestor of Deepest Leaves (LC-1123 / Medium)](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/)
> 7. [Delete Node in a BST (LC-450 / Medium)](https://leetcode.com/problems/delete-node-in-a-bst)
> 8. [Diameter of Binary Tree (LC-543 / Medium)](https://leetcode.com/problems/diameter-of-binary-tree/)
> 9. [Add One Row to Tree (LC-623 / Medium)](https://leetcode.com/problems/add-one-row-to-tree)
> 10. [Print Binary Tree (LC-655 / Medium)](https://leetcode.com/problems/print-binary-tree)
> 11. [Maximum Width of Binary Tree (LC-662 / Medium)](https://leetcode.com/problems/maximum-width-of-binary-tree)
> 12. [Trim a Binary Search Tree (LC-669 / Medium)](https://leetcode.com/problems/trim-a-binary-search-tree)
> 13. [All Nodes Distance K in Binary Tree (LC-863 / Medium)](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree)
> 14. [Smallest Subtree with all the Deepest Nodes (LC-865 / Medium)](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes)
> 15. [Flip Equivalent Binary Trees (LC-951 / Medium)](https://leetcode.com/problems/flip-equivalent-binary-trees)
> 16. [Vertical Order Traversal of a Binary Tree (LC-987 / Hard)](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree)
> 17. [Maximum Difference Between Node and Ancestor (LC-1026 / Medium)](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor)
> 18. [Insufficient Nodes in Root to Leaf Paths (LC-1080 / Medium)](https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths)
> 19. [Delete Nodes And Return Forest (LC-1110 / Medium)](https://leetcode.com/problems/delete-nodes-and-return-forest)
> 20. [Step-By-Step Directions From a Binary Tree Node to Another (LC-2096 / Medium)](https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/)
> 21. [Binary Tree Cameras (LC-968 / Hard)](https://leetcode.com/problems/binary-tree-cameras/)
> 22. [Kth Smallest Element in a BST (LC-230 / Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-bst)
> 23. [Find Bottom Left Tree Value (LC-513 / Medium)](https://leetcode.com/problems/find-bottom-left-tree-value/)
> 24. [Find Duplicate Subtrees (LC-652 / Medium)](https://leetcode.com/problems/find-duplicate-subtrees)
> 25. [Longest Univalue Path (LC-687 / Medium)](https://leetcode.com/problems/longest-univalue-path/)

## 9. Trie
Trie can be used to solve pattern match prblems, such as **Longest Common Prefix**.

```java
  class Trie {
    private final TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      var cur = root;
      for (var i = 0; i < word.length(); i++) {
        var c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode(c, false);
        }
        cur = cur.children[c - 'a'];
      }
      cur.wordEnd = true;
    }

    public boolean search(String word) {
      var node = root;
      for (var i = 0; i < word.length(); i++) {
        var child = node.children[word.charAt(i) - 'a'];
        if (child == null) {
          return false;
        }
        node = child;
      }
      return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
      var node = root;
      for (var i = 0; i < prefix.length(); i++) {
        var child = node.children[prefix.charAt(i) - 'a'];
        if (child == null) {
          return false;
        }
        node = child;
      }
      return true;
    }
  }

  class TrieNode {
    public char val;
    public boolean wordEnd;
    public final TrieNode[] children;

    public TrieNode() {
      this.val = '';
      this.children = new TrieNode[26];
    }

    public TrieNode(char val, boolean wordEnd) {
      this.val = val;
      this.wordEnd = wordEnd;
      this.children = new TrieNode[26];
    }
  }
```
> Quiz
> 1. [Design Add and Search Words Data Structure (LC-211 / Medium)](https://leetcode.com/problems/design-add-and-search-words-data-structure)

### Suffix Tree
Suffix tree or suffix array can be used to solve pattern match problems, e.g. check if a pattern exists in target string.
```java
  public Trie suffixTree(String str) {
    var root = new Trie();
    for (var i = 0; i < str.length(); i++) {
      root.insert(str.substring(i));
    }
    return root;
  }
```

## 10. Union Find
Union Find is usually used for grouping.

> Quiz
> 1. [Number of Provinces (LC-547 / Medium)](https://leetcode.com/problems/number-of-provinces)
> 2. [Redundant Connection (LC-684 / Medium)](https://leetcode.com/problems/redundant-connection)
> 3. [Similar String Groups (LC-839 / Hard)](https://leetcode.com/problems/similar-string-groups)

## 11. Data Structure Design
> 1. [LFU Cache (LC-460 / Hard)](https://leetcode.com/problems/lfu-cache)
> 2. [LRU Cache (LC-146 / Medium)](https://leetcode.com/problems/lru-cache)
> 3. [Min Stack (LC-155 / Medium)](https://leetcode.com/problems/min-stack)
> 4. [Implement Trie (Prefix Tree) (LC-208 / Medium)](https://leetcode.com/problems/implement-trie-prefix-tree)
> 5. [Design Add and Search Words Data Structure (LC-211 / Medium)](https://leetcode.com/problems/design-add-and-search-words-data-structure)
> 6. [Peeking Iterator (LC-284 / Medium)](https://leetcode.com/problems/peeking-iterator)
> 7. [Find Median from Data Stream (LC-295 / Hard)](https://leetcode.com/problems/find-median-from-data-stream)
> 8. [Serialize and Deserialize BST (LC-449 / Medium)](https://leetcode.com/problems/serialize-and-deserialize-bst)
> 9. [Serialize and Deserialize Binary Tree (LC-297 / Hard)](https://leetcode.com/problems/serialize-and-deserialize-binary-tree)
> 10. [Flatten Nested List Iterator (LC-341 / Medium)](https://leetcode.com/problems/flatten-nested-list-iterator)
> 11. [Insert Delete GetRandom O(1) (LC-380 / Medium)](https://leetcode.com/problems/insert-delete-getrandom-o1)
> 12. [Linked List Random Node (LC-382 / Medium)](https://leetcode.com/problems/linked-list-random-node)
> 13. [All O`one Data Structure (LC-432 / Hard)](https://leetcode.com/problems/all-oone-data-structure)
> 14. [Design Circular Queue (LC-622 / Medium)](https://leetcode.com/problems/design-circular-queue)
> 15. [Map Sum Pairs (LC-677 / Medium)](https://leetcode.com/problems/map-sum-pairs)
> 16. [My Calendar I (LC-729 / Medium)](https://leetcode.com/problems/my-calendar-i)
> 17. [Maximum Frequency Stack (LC-895 / Hard)](https://leetcode.com/problems/maximum-frequency-stack)
> 18. [Time Based Key-Value Store (LC-981 / Medium)](https://leetcode.com/problems/time-based-key-value-store)
> 19. [Dinner Plate Stacks (LC-1172 / Hard)](https://leetcode.com/problems/dinner-plate-stacks)
> 20. [Design Skiplist (LC-1206 / Hard)](https://leetcode.com/problems/design-skiplist)
> 21. [Design a Stack With Increment Operation (LC-1381 / Medium)](https://leetcode.com/problems/design-a-stack-with-increment-operation)
> 22. [Frequency Tracker (LC-2671 / Medium)](https://leetcode.com/problems/frequency-tracker)