package _023_合并K个升序链表;

import model.ListNode;
import model.SingleLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lujinpeng
 * @date 2023-06-13 6:24 下午
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        // 优先队列（默认实现最小堆）
        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>(lists.length,
                Comparator.comparingInt(integerListNode -> integerListNode.val));
//        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for (ListNode probe : lists) {
            if (probe == null) {
                continue;
            }
            pq.add(probe);
        }

        while (!pq.isEmpty()) {
            ListNode minNode = pq.remove();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummyHead.next;

    }

    public static void main(String[] args) {
        Integer[] nodesArr1 = new Integer[]{1,4,5};
        Integer[] nodesArr2 = new Integer[]{1,3,4};
        Integer[] nodesArr3 = new Integer[]{2,6};

        SingleLinkedList<Integer> list1 = new SingleLinkedList<>(nodesArr1);
        SingleLinkedList<Integer> list2 = new SingleLinkedList<>(nodesArr2);
        SingleLinkedList<Integer> list3 = new SingleLinkedList<>(nodesArr3);

        ListNode[] lists = new ListNode[]{list1.getHead(), list2.getHead(), list3.getHead()};
    }
}