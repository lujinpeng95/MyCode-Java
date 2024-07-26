package _5093_三队合一;

/**
 * 题目描述：用一个数组，存储三个队列（大小一致），并且每个队列都能实现正常的队列操作。所有的队列操作需要传递queueID指名用的是三个队列中的哪一个（从0开始）
 * 
 * @author lujinpeng
 * @date 2024-07-26 16:34
 */
public class TripleQueueInOne {

    private int queueSize;
    private int[] data;

    private int[] base;
    private int[] head;
    private int[] tail;


    public TripleQueueInOne(int queueSize) {
        this.queueSize = queueSize + 1;
        this.data = new int[this.queueSize * 3];

        this.base = new int[3];
        this.head = new int[3];
        this.tail = new int[3];

        for (int i = 0; i < 3; i++) {
            this.base[i] = this.queueSize * i;
            this.head[i] = this.queueSize * i;
            this.tail[i] = this.queueSize * i;
        }
    }

    public boolean enqueue(int queueID, int value) {
        if ((this.tail[queueID] + 1) % this.queueSize == this.head[queueID] % this.queueSize) {
            return false;
        }

        this.data[this.tail[queueID]] = value;
        this.tail[queueID] = (this.tail[queueID] + 1) % this.queueSize + this.base[queueID];
        return true;
    }

    public int dequeue(int queueID) {
        if (this.isEmpty(queueID)) {
            return -1;
        }

        int ret = this.data[this.head[queueID]];
        this.head[queueID] = (this.head[queueID] + 1) % this.queueSize + this.base[queueID];
        return ret;
    }

    public boolean isEmpty(int queueID) {
        return this.head[queueID] == this.tail[queueID];
    }
}
