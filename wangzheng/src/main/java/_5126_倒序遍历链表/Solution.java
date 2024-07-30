package _5126_倒序遍历链表;

import model.ListNode;

/**
 * https://codecrush.cn/oj/problem/24
 * 
 * 给定一个单链表的头节点 head ，倒序遍历输出单链表中的节点值。
 * 链表中的节点定义为 ListNode，其中包含 print() 函数用来打印节点。你不需要自己去定义 ListNode 类和实现 print() 函数，直接使用即可。
 * 链表的长度 n<=100
 * 
 * @author lujinpeng
 * @date 2024-07-30 17:01
 */
public class Solution {
    public void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        head.print();
    }
}
