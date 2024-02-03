package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapSumPairs_677 {
  static class MapSum {

    private final Map<String, Integer> sumMap;
    private final Map<String, Set<String>> prefixMap;
    public MapSum() {
      this.sumMap = new HashMap<>();
      this.prefixMap = new HashMap<>();
    }

    public void insert(String key, int val) {
      sumMap.put(key,val);
      var pre = "";
      for (var i = 0; i < key.length(); i++) {
        pre += key.charAt(i);
        prefixMap.putIfAbsent(pre, new HashSet<>());
        prefixMap.get(pre).add(key);
      }
    }

    public int sum(String prefix) {
      if (!prefixMap.containsKey(prefix)) {
        return 0;
      }
      return prefixMap.get(prefix).stream().map(p -> sumMap.getOrDefault(p, 0)).mapToInt(a -> a).sum();
    }
  }

  public static void main(String[] args) {
    var mapSum = new MapSum();
    mapSum.insert("a", 3);
    mapSum.insert("ap", 2);
    System.out.println(mapSum.sum("ap"));
  }
}
