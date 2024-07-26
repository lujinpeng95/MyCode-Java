package _5092_实现循环队列;

/**
 * @author lujinpeng
 * @date 2024-07-26 11:24
 */
public class CircularQueue {
    private int[] queue;
    private int queueSize;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int queueSize) {
        this.queue = new int[queueSize + 1];
        this.queueSize = queueSize + 1;
    }

    public boolean enqueue(int item) {
        // 队满
        if ((this.tail + 1) % this.queueSize == this.head) {
            return false;
        }

        this.queue[this.tail] = item;
        this.tail = (this.tail + 1) % this.queueSize;
        return true;
    }

    public int dequeue() {
        // 队空
        if (this.isEmpty()) {
            return -1;
        }

        int ret = this.queue[this.head];
        this.head = (this.head + 1) % this.queueSize;
        return ret;
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }
}