package model;

public class SingleLinkedList<E> {

    private ListNode<E> dummyHead;
    private int size;

    public SingleLinkedList(){
        dummyHead = new ListNode<E>();
        size = 0;
    }

    // 根据参数顺序，产生一条链表
    public SingleLinkedList(E... args){
        dummyHead = new ListNode<E>();
        size = 0;

        for (int i = 0; i < args.length; i++) {
            addLast(args[i]);
        }

    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){
        addNode(index, new ListNode(e));
    }

    // 在链表的index(0-based)位置添加指定结点
    public void addNode(int index, ListNode<E> node) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        ListNode prev = dummyHead;
        for (int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }

        node.next = prev.next;
        prev.next = node;

        size ++;

    }

    // 在链表末尾添加新的结点/链表
    public void addNodes(ListNode<E> node) {

        ListNode prev = dummyHead;
        for (int i = 0 ; i < size ; i ++) {
            prev = prev.next;
        }

        prev.next = node;
        size ++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        return getNode(index).val;
    }

    // 获得链表的第index(0-based)个位置的结点
    public ListNode<E> getNode(int index){

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        ListNode<E> cur = dummyHead.next;
        for (int i = 0 ; i < index ; i ++) {
            cur = cur.next;
        }
        return cur;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的第一个结点
    public ListNode<E> getHead(){
        return dummyHead.next;
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 获得链表的最后一个结点
    public ListNode<E> getLastNode(){
        return getNode(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }

        ListNode cur = dummyHead.next;
        for (int i = 0 ; i < index ; i ++) {
            cur = cur.next;
        }
        cur.val = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        ListNode cur = dummyHead.next;
        while(cur != null){
            if (cur.val.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        // E ret = findNode(index).e; // 两次遍历

        ListNode<E> prev = dummyHead;
        for (int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }

        ListNode<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.val;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        ListNode prev = dummyHead;
        while(prev.next != null){
            if (prev.next.val.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        ListNode cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>(1, 2, 3, 4);
        System.out.println(list);

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>(7, 8, 9);
        list.addNodes(list2.getNode(0));
        System.out.println(list);
    }

}
