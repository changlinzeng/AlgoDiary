package algo.unionfind;

import java.util.*;

public class AccountsMerge_721 {
  public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    var len = accounts.size();
    var unionFind = new int[len];
    var emailAccountId = new HashMap<String, Integer>();  // email -> account id

    for (var i = 0; i < len; i++) {
      unionFind[i] = i;
    }

    for (var i = 0; i < len; i++) {
      var accts = accounts.get(i);
      for (var j = 1; j < accts.size(); j++) {
        var email = accts.get(j);
        if (!emailAccountId.containsKey(email)) {
          emailAccountId.put(email, i);
          continue;
        }
        // if the parent account id not equal to current account id, merge
        var parentAcct = unionFind[emailAccountId.get(email)];
        if (parentAcct != i) {
          for (var k = 0; k < len; k++) {
            if (unionFind[k] == parentAcct) {
              unionFind[k] = i;
            }
          }
        }
      }
    }

    var merge = new HashMap<Integer, Set<String>>();
    for (var i = 0; i < len; i++) {
      var parent = unionFind[i];
      var emails = accounts.get(i).subList(1, accounts.get(i).size());
      merge.putIfAbsent(parent, new HashSet<>());
      merge.get(parent).addAll(emails);
    }

    return merge.entrySet().stream().map(e -> {
      List<String> acct = new ArrayList<>();
      acct.add(accounts.get(e.getKey()).getFirst());
      acct.addAll(e.getValue().stream().sorted().toList());
      return acct;
    }).toList();
  }

  public static void main(String[] args) {
    System.out.println(accountsMerge(List.of(List.of("John","johnsmith@mail.com","john_newyork@mail.com"), List.of("John","johnsmith@mail.com","john00@mail.com"), List.of("Mary","mary@mail.com"), List.of("John","johnnybravo@mail.com"))));
  }
}
