package algo.depthFirstSearch;

public class VerifyPreorderSerializationOfABinaryTree_331 {
  private static int index = 0;

  public static boolean isValidSerialization(String preorder) {
    var seq = preorder.split(",");
    dfs(seq);
    return index == seq.length - 1;
  }

  private static void dfs(String[] preorder) {
    if (index > preorder.length - 1) {
      return;
    }

    if ("#".equals(preorder[index])) {
      return;
    }

    // left substree
    index++;
    dfs(preorder);

    // right substree
    index++;
    if (index > preorder.length - 1) {
      return;
    }
    dfs(preorder);
  }

  public static void main(String[] args) {
    System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    System.out.println(isValidSerialization("1,#"));
    System.out.println(isValidSerialization("1,#,#,2"));
  }
}
