package algo.twoPointers;

public class SentenceSimilarity_III_1813 {
  public static boolean areSentencesSimilar(String sentence1, String sentence2) {
    var words1 = sentence1.split(" ");
    var words2 = sentence2.split(" ");
    if (checkSimilar(words1, words2)) {
      return true;
    }

    // check reverse in case there are duplicate words like
    // [A] and [a A b A]
    var reverse1 = new String[words1.length];
    var reverse2 = new String[words2.length];
    for (var i = 0; i < words1.length; i++) {
      reverse1[words1.length - i - 1] = words1[i];
    }
    for (var i = 0; i < words2.length; i++) {
      reverse2[words2.length - i - 1] = words2[i];
    }
    return checkSimilar(reverse1, reverse2);
  }

  private static boolean checkSimilar(String[] words1, String[] words2) {
    String[] shortSentence, longSentence;
    if (words1.length < words2.length) {
      shortSentence = words1;
      longSentence = words2;
    } else {
      shortSentence = words2;
      longSentence = words1;
    }

    int i = 0, j = 0;
    int start = -1, end = -1;  // start and end index of different words between two sentences
    while (i < shortSentence.length && j < longSentence.length) {
      if (!shortSentence[i].equals(longSentence[j])) {
        // find a second part that differs
        if (start != -1 && end != -1) {
          return false;
        } else if (start == -1) {
          start = i;
        }
      } else {
        if (start != -1 && end == -1) {
          end = j - 1;
        }
        i++;
      }
      j++;
    }
    return i == shortSentence.length && (j == longSentence.length || start == -1);
  }

  public static void main(String[] args) {
    System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
    System.out.println(areSentencesSimilar("of", "a lot of words"));
    System.out.println(areSentencesSimilar("Eating right now", "Eating"));
    System.out.println(areSentencesSimilar("A", "A b A a"));
  }
}
