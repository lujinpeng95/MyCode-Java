package _5091_实现链式队列;

import model.ListNode;

/**
 * @author lujinpeng
 * @date 2024-07-29 16:51
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode() {}
 *     public ListNode(int val) { this.val = val;}
 *     public ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class LinkedQueue {

    private ListNode<Integer> fakeNode = new ListNode(0, null);
    private ListNode<Integer> head = fakeNode;
    private ListNode<Integer> tail = fakeNode;

    public void enqueue(int value) {
        tail.next = new ListNode(value, null);
        tail = tail.next;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        ListNode res = head.next;
        if (res.next == null) {
            // 最后一个节点
            tail = head;
            return (Integer) res.val;
        }

        head.next = res.next;
        return (Integer) res.val;
    }

    public boolean isEmpty() {
        return tail == head;
    }
}

