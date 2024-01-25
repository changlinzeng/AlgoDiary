package datautil.list;

public class List<T> {
  public ListNode<T> head;

  public static <T> List<T> fromArray(T[] arr) {
    return fromArray(arr, false);
  }

  public static <T> List<T> fromArray(T[] arr, boolean doubly) {
    var list = new List<T>();
    if (arr == null) {
      return list;
    }

    ListNode<T> node, prev = null;
    for (T e : arr) {
      if (doubly) {
        node = new ListNode<>(e, prev, null);
      } else {
        node = new ListNode<>(e, null, null);
      }
      if (prev == null) {
        list.head = node;
      } else {
        prev.next = node;
      }
      prev = node;
    }

    return list;
  }

  public void print() {
    StringBuilder sb = new StringBuilder();
    var cur = this.head;
    while (cur != null) {
      if (!sb.toString().equals("")) {
        sb.append(",");
      }
      sb.append(cur.value);
      cur = cur.next;
    }
    System.out.println("[" + sb + "]");
  }

  public void reverse() {
    ListNode<T> cur = head, prev = null, next;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    head = prev;
  }

  public T mid() {
    ListNode<T> cur = head, next = head;
    while (next != null) {
      next = next.next;
      if (next != null) {
        next = next.next;
        if (next != null) {
          cur = cur.next;
        }
      }
    }

    return cur.value;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3});
    list.print();
//    list.reverse();
//    list.print();
    System.out.println(list.mid());
  }

}