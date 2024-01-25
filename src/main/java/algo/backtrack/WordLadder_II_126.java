package algo.backtrack;

import java.util.*;

public class WordLadder_II_126 {
  /**
   * Same as SlidingPuzzle
   */
  public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//    var ladders = new ArrayList<List<String>>();
//    var ladder = new ArrayList<String>();
//    ladder.add(beginWord);
//    backtrack(beginWord, endWord, wordList, ladders, ladder);
//    return ladders;

    var ladders = new TreeMap<Integer, List<List<String>>>();
    var ladder = new ArrayList<String>();
    var visited = new HashSet<String>();
//    ladder.add(beginWord);
//    visited.add(beginWord);
//    backtrack2(beginWord, endWord, wordList, ladders, ladder, visited);
//    backtrack2(beginWord, endWord, wordList, ladders, ladder, visited);
//    return ladders.isEmpty() ? new ArrayList<>() : ladders.firstEntry().getValue();

    return bfs(beginWord, endWord, wordList);
  }

  private static void backtrack(String word, String endWord, List<String> wordList,
                                List<List<String>> ladders, List<String> ladder) {
    if (word.equals(endWord)) {
      if (ladders.isEmpty()) {
        ladders.add(new ArrayList<>(ladder));
      } else {
        if (ladders.get(0).size() > ladder.size()) {
          ladders.clear();
          ladders.add(new ArrayList<>(ladder));
        } else if (ladders.get(0).size() == ladder.size()) {
          ladders.add(new ArrayList<>(ladder));
        }
      }
      return;
    }
    for (var n : next(wordList, word, ladder)) {
      if (ladder.contains(n)) {
        continue;
      }
      ladder.add(n);
      backtrack(n, endWord, wordList, ladders, ladder);
      ladder.remove(ladder.size() - 1);
    }
  }

  private static void backtrack2(String word, String endWord, List<String> wordList,
                                 Map<Integer, List<List<String>>> ladders, List<String> ladder,
                                 Set<String> visited) {
    if (word.equals(endWord)) {
      var len = ladder.size();
      if (!ladders.containsKey(len)) {
        ladders.put(len, new ArrayList<>());
      }
      ladders.get(len).add(new ArrayList<>(ladder));
      return;
    }
    for (var nw : next(wordList, word, ladder)) {
      if (visited.add(nw)) {
        ladder.add(nw);
        backtrack2(nw, endWord, wordList, ladders, ladder, visited);
        ladder.removeLast();
        visited.remove(nw);
      }
    }
  }

  private static List<List<String>> bfs(String startWord, String endWord, List<String> wordList) {
    var ladders = new TreeMap<Integer, List<List<String>>>();
    var q = new LinkedList<List<String>>();
    var visited = new HashMap<String, Integer>();
    var start = List.of(startWord);
    q.offer(start);
    visited.put(startWord, 1);
    while (!q.isEmpty()) {
      var path = q.poll();
      var word = path.getLast();

      if (visited.containsKey(word) && visited.get(word) < path.size()) {
        continue;
      }

      var nws = next(wordList, word, path);
      for (var nw : nws) {
        if (visited.containsKey(nw) && visited.get(nw) < path.size() + 1) {
          continue;
        }

//        if (path.contains(nw)) {
//          continue;
//        }
        var ladder = new ArrayList<>(path);
        ladder.add(nw);
        if (nw.equals(endWord)) {
          var len = ladder.size();
          if (!ladders.containsKey(len)) {
            ladders.put(len, new ArrayList<>());
          }
          ladders.get(len).add(new ArrayList<>(ladder));
        } else {
          visited.put(nw, ladder.size());
          q.offer(ladder);
        }
      }
    }
    return ladders.isEmpty() ? new ArrayList<>() : ladders.firstEntry().getValue();
  }

  private static List<String> next(List<String> wordList, String word, List<String> path) {
    var result = new ArrayList<String>();
    var words = new HashSet<>(path);
    for (var w : wordList) {
      if (words.contains(w)) {
        continue;
      }
      var diff = 0;
      for (var i = 0; i < w.length(); i++) {
        if (w.charAt(i) != word.charAt(i)) {
          diff++;
          if (diff > 1) {
            break;
          }
        }
      }
      if (diff == 1) {
        result.add(w);
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    findLadders("hit", "cog", List.of("hot","dot","dog","lot","log", "cog")).forEach(System.out::println);
//    findLadders("cet", "ism", List.of("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim")).forEach(System.out::println);
    var now = System.currentTimeMillis();
    findLadders("aaaaa", "ggggg", List.of("aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz")).forEach(System.out::println);
    System.out.println(System.currentTimeMillis() - now);
  }
}
