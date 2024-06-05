package algo.depthFirstSearch;

import java.util.*;

public class PyramidTransitionMatrix_756 {
  public static boolean pyramidTransition(String bottom, List<String> allowed) {
    var allowedMap = new HashMap<String, List<String>>();
    for (var str : allowed) {
      var key = str.charAt(0) + "_" + str.charAt(1);
      allowedMap.putIfAbsent(key, new ArrayList<>());
      allowedMap.get(key).add(str.charAt(2) + "");
    }

    var memo = new HashMap<String, List<String>>();
    var visited = new HashSet<String>();
    var q = new ArrayDeque<String>();
    q.offer(bottom);
    while (!q.isEmpty()) {
      var row = q.poll();
      if (!visited.add(row)) {
        continue;
      }
      for (var r : generate(row, allowedMap, memo)) {
        if (r.length() == 1) {
          return true;
        }
        q.offer(r);
      }
    }
    return false;
  }

  private static List<String> generate(String row, Map<String, List<String>> allowed, Map<String, List<String>> memo) {
    if (row.length() < 2) {
      return List.of();
    }
    var key = row.charAt(0) + "_" + row.charAt(1);
    if (memo.containsKey(row)) {
      return memo.get(row);
    }
    if (!allowed.containsKey(key)) {
      return List.of();
    }
    if (row.length() == 2) {
      return allowed.get(key);
    }
    var rows = new ArrayList<String>();
    var res = generate(row.substring(1), allowed, memo);
    if (!res.isEmpty()) {
      for (var c : allowed.get(key)) {
        for (var s : res) {
          rows.add(c + s);
        }
      }
      memo.put(row, rows);
    }
    return rows;
  }

  public static void main(String[] args) {
    // TODO Timeout!!
    System.out.println(pyramidTransition("FDBACE", List.of("EEF","BFE","EDD","EFB","EFC","DCE","CCE","ABB","BBB","EDC","ADD","AFE","CAF","DEF","ABE","BBD","CBB","ADB","ABD","EDF","FAE","CAA","CFB","BCA","BDC","EAB","FFE","FBF","EFF","AFD","DFA","BED","BDD","ABA","FCB","CBD","CDC","CEC","ECC","ECA","EBC","DFD","FFB","BDE","DBD","EBB","DEB","BEF","FFA","AEA","CCC","BFF","DCD","BBA","CFF","ECD","CBF","CCD","FAA","EDA","ADF","ECE","FCF","FFF","FCE","BFC","CCF","ACD","FDB","DBA","AED","FDD","BDF","FBE","DCB","ACE","FBC","FEF","FDF","AEF","DDB","CFA","BCB","EFA","EAC","FBD","CFC","AEE","CEB","AFA","CCA","BFD","BAC","BAA","CEE","DAB","AFC","DBE","BEE","DAF","DCA","EEA","BDB","EEB","EAA","BEC","DED","CDE","CDB","EEE","DAC","EBF","EBD","FDE","ABC","ACB","DBC","FBA","BAE","EFE","BBC","CBC","FED","FEA","ACF","DCF","FDA","BCC","ADE","DAE","DCC","EDB","AFB","CEA","DFE","BAD","FEC","EEC","EBE","CEF","EAD","ABF","EFD","AAB","AAD","FAB","FEE","CBE","BBE","ADC","FAD","DBB","CAB","CDA","AAF","DBF","FCA","DEE","EDE","FFC","DDD","DDA","DEC","DFF","BCD","ECF","DDF","AEB","BDA","FBB","BCE","DAA","ACC","CCB","FAC","BAF","BEA","CFD","EBA","ACA","DAD","BFB","ECB","CAD","DDC","FCC","BEB","FAF","BBF","AAA","AAC","CED","AAE","CDD","DDE","DEA","FFD","DFC","CFE","FEB","FDC","ADA","BCF","AFF","EAE","AEC","CAC","CDF","BAB","EED","CAE","FCD","BFA","EAF","CBA","DFB")));
  }
}
