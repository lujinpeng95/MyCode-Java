package _086_分隔链表;

import model.ListNode;
import model.SingleLinkedList;

/**
 * @author lujinpeng
 * @date 2023-06-13 5:16 下午
 */
class Solution {
    // 法一：分别分类到两个链表中
    public ListNode partition(ListNode<Integer> head, int x) {
        // 小的数据存储在这个链表
        ListNode<Integer> dummyLess = new ListNode();
        ListNode<Integer> curLess = dummyLess;
        // 大的数据存储在这个链表
        ListNode<Integer> dummyBigger = new ListNode();
        ListNode<Integer> curBig = dummyBigger;
        ListNode<Integer> probe = head;

        while (probe != null) {
            int val = probe.val;
            if (val < x) {
                curLess.next = probe;
                curLess = curLess.next;
            } else {
                curBig.next = probe;
                curBig = curBig.next;
            }
            probe = probe.next;

        }

        // 后链接的链表需要置null，防止循环链表
        curBig.next = null;
        curLess.next = dummyBigger.next;
        return dummyLess.next;

    }

    // 法二：大的结点单独放置，原链表卸掉拆除的结点
    public ListNode partition2(ListNode head, int x) {
        ListNode<Integer> fakeHead = new ListNode();
        ListNode<Integer> prev = fakeHead;
        fakeHead.next = head;

        ListNode<Integer> biggerHead = new ListNode();
        ListNode<Integer> biggerCurr = biggerHead;

        while (prev.next != null) {
            ListNode<Integer> curr = prev.next;
            // 小于指定值，考虑下一个结点
            if (curr.val < x) {
                prev = curr;
                continue;
            }

            prev.next = curr.next;
            biggerCurr.next = curr;
            biggerCurr = biggerCurr.next;
        }

        biggerCurr.next = null;
        prev.next = biggerHead.next;
        return fakeHead.next;

    }

    public static void main(String[] args) {
        Integer[] nodesArr = new Integer[]{1, 4, 3, 2, 5, 2};
        SingleLinkedList<Integer> list = new SingleLinkedList<>(nodesArr);

        System.out.println(new Solution().partition(list.getHead(), 3).getAll());

    }
}
