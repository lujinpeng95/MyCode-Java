package model;

/**
 * 链表结点
 * @author lujinpeng
 * @date 2023-06-13 2:58 下午
 */
public class ListNode<E> {
    public E val;
    public ListNode next;

    public ListNode(E e, ListNode<E> next){
        this.val = e;
        this.next = next;
    }

    public ListNode(E e){
        this(e, null);
    }

    public ListNode(){
        this(null, null);
    }

    @Override
    public String toString(){
        return val.toString();
    }

    // 返回node及其之后链表数据
    public String getAll() {
        StringBuilder res = new StringBuilder();
        res.append(val.toString()).append("->");

        ListNode<E> cur = next;
        while(cur != null){
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

 }


