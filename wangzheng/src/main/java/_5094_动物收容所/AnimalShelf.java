package _5094_动物收容所;

/**
 * 【对比】对比 leetcode 面试题 3.6动物收容所，此处dogID/catID 的顺序性不做保障，且需要自己维护 Node 等基础节点
 * 有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在领养该收容所的动物时，领养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者指定领养种类猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想领养的对象。请创建适用于这个系统的数据结构，实现如下几个操作方法：
 *
 * enqueueDog(dogID) 如果收容所满了，则返回false，否则返回true。
 * enqueueCat(catID) 同上。
 * dequeueAny() 如果收容所为空，则返回-1，否则返回动物编号ID。
 * dequeueDog() 如果收容所中没有狗狗了，则返回-1，否则返回狗狗编号ID。
 * dequeueCat() 如果收容所中没有猫猫了，则返回-1，否则返回猫猫编号ID。
 * 
 * dogID 和 catID 分表代表狗猫的编号；
 * 收容所的大小通过构造函数中的 shelfSize 传递；
 * 收容所每次只能进行一个操作，也就是说不需要考虑并发问题。
 * 
 * @author lujinpeng
 * @date 2024-07-29 18:33
 */
public class AnimalShelf {

    // 动物类型
    private static class Animal {
        public int id;
        public int orderId;
        public Animal(int id, int orderId) {
            this.id = id;
            this.orderId = orderId;
        }
    }

    // 队列节点
    private static class ListNode {
        public Animal val;
        private ListNode next;

        public ListNode() {

        }
        public ListNode(Animal val) {
            this.val = val;
        }
        public ListNode(Animal val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 动物队列
    private static class AnimalQueue {
        private final ListNode head;
        private ListNode tail;

        public AnimalQueue() {
            ListNode fakeNode = new ListNode(null, null);
            this.head = fakeNode;
            this.tail = fakeNode;
        }

        public void enqueue(Animal val) {
            this.tail.next = new ListNode(val);
            this.tail = this.tail.next;
        }

        public Animal dequeue() {
            if (this.isEmpty()) {
                return null;
            }

            ListNode res = this.head.next;
            // 最后一个节点
            if (res.next == null) {
                this.tail = this.head;
                return res.val;
            }

            this.head.next = res.next;
            return res.val;
        }

        public Animal peek() {
            if (this.isEmpty()) {
                return null;
            }

            return this.head.next.val;
        }

        public boolean isEmpty() {
            return this.head == this.tail;
        }
    }



    private final AnimalQueue dogQueue = new AnimalQueue();
    private final AnimalQueue catQueue = new AnimalQueue();
    // 维护入队序号
    private int orderId;
    // 已有动物数量
    private int animalNum;
    private final int shelfSize;
    // 动物收容所 -- 维护两个 queue
    public AnimalShelf(int shelfSize) {
        this.shelfSize = shelfSize;
        this.animalNum = 0;
        this.orderId = 0;
    }

    public boolean enqueueDog(int dogID) {
        // 容量满
        if (this.animalNum == this.shelfSize) {
            return false;
        }

        this.dogQueue.enqueue(new Animal(dogID, this.orderId));
        this.orderId++;
        this.animalNum++;
        return true;
    }

    public boolean enqueueCat(int catID) {
        if (this.animalNum == this.shelfSize) {
            return false;
        }

        this.catQueue.enqueue(new Animal(catID, this.orderId));
        this.orderId++;
        this.animalNum++;
        return true;
    }

    public int dequeueAny() {
        if (this.dogQueue.isEmpty()) {
            return dequeueCat();
        }
        if (this.catQueue.isEmpty()) {
            return dequeueDog();
        }

        this.animalNum--;
        if (this.dogQueue.peek().orderId < this.catQueue.peek().orderId) {
            return this.dogQueue.dequeue().id;
        }

        return this.catQueue.dequeue().id;
    }

    public int dequeueDog() {
        if (this.dogQueue.isEmpty()) {
            return -1;
        }

        this.animalNum--;
        return this.dogQueue.dequeue().id;
    }

    public int dequeueCat() {
        if (this.catQueue.isEmpty()) {
            return -1;
        }

        this.animalNum--;
        return this.catQueue.dequeue().id;
    }
}
