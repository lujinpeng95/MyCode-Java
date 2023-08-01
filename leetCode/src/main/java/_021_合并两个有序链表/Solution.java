package _021_合并两个有序链表;

import model.ListNode;
import model.SingleLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 虚拟头结点技巧（避免边界情况的讨论）
 *
 * @author lujinpeng
 * @date 2023-06-13 2:57 下午
 */
class Solution {
    public ListNode mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        // 小技巧，用fakeNode简化边界情况的判断
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;

        while (list1 != null || list2 != null) {
            // 通过赋值无穷大，简化判断
            float x = (list1 != null) ? list1.val : Float.POSITIVE_INFINITY;
            float y = (list2 != null) ? list2.val : Float.POSITIVE_INFINITY;

//            double d_p_i = Double.POSITIVE_INFINITY;  // 1.0 / 0.0, 正无穷大
//            double d_n_i = Double.NEGATIVE_INFINITY;  // -1.0 / 0.0，负无穷大
//            float f_p_i = Float.POSITIVE_INFINITY;    // 1.0f / 0.0f，正无穷大
//            float f_n_i = Float.NEGATIVE_INFINITY;    // -1.0f / 0.0f，负无穷大

            if (x < y) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        return fakeHead.next;

    }

    public static void main(String[] args) {
        Integer[] nodesArrTest = new Integer[] {1, 2, 4};

        // 熟悉java中数组与List间的转换（Arrays.asList、toArray）
        List<Integer> nodes1 = new ArrayList<>(Arrays.asList(nodesArrTest));
        List<Integer> nodes2 = new ArrayList<>(Arrays.asList(1, 3, 4));
        // 若不传参，则toArray是Object类型的（且不可强转Object[] 为 Integer[] ---- 编译可通过，运行报错）
        Integer[] nodesArr1 = nodes1.toArray(new Integer[0]);
        Integer[] nodesArr2 = nodes2.toArray(new Integer[0]);

//        // 如下可以，但不可强转Object[] 为 Integer[]
//        Object a = 1;
//        Integer b = (Integer) a;
//        System.out.println(b);

        SingleLinkedList<Integer> list1 = new SingleLinkedList<>(nodesArr1);
        SingleLinkedList<Integer> list2 = new SingleLinkedList<>(nodesArr2);

        System.out.println(new Solution().mergeTwoLists(list1.getHead(), list2.getHead()).getAll());

    }
}
