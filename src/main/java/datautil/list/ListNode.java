package datautil.list;

public class ListNode<T> {
  public T value;

  public T val;

  public ListNode<T> prev;

  public ListNode<T> next;

  public ListNode() {}

  public ListNode(T value) {
    this.value = value;
    this.val = value;
  }

  public ListNode(T value, ListNode<T> prev, ListNode<T> next) {
    this.value = value;
    this.val = value;
    this.prev = prev;
    this.next = next;
  }
}