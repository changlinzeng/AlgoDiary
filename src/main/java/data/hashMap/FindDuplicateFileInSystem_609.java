package data.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystem_609 {
  public static List<List<String>> findDuplicate(String[] paths) {
    var dup = new HashMap<String, List<String>>();
    for (var dir : paths) {
      var files = dir.split(" ");
      var folder = files[0];
      for (var i = 1; i < files.length; i++) {
        var fullname = folder + "/" + files[i];
        var start = fullname.indexOf("(");
        var content = fullname.substring(start);
        var filename = fullname.substring(0, start);
        dup.putIfAbsent(content, new ArrayList<>());
        dup.get(content).add(filename);
      }
    }
    return dup.values().stream().filter(v -> v.size() > 1).toList();
  }

  public static void main(String[] args) {
    System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
  }
}
