package _5064_三栈合一;

/**
 * 题目描述：用一个数组，存储三个栈（栈大小一致），并且每个栈都能实现正常的栈操作。所有的栈操作需要传递stackID指名用的是三个栈中的哪一个（从0开始）
 * 
 * 
 * @author lujinpeng
 * @date 2024-05-19 20:38
 */
class TripleStackInOne {

    private int stackSize;
    private int[] data;
    private int[] tops;
    private int[] counts;

    public TripleStackInOne(int stackSize) {
      
        data = new int[3 * stackSize];
        this.stackSize = stackSize;
        tops = new int[3];
        counts = new int[3];

        // 第1个栈插入元素时的索引位置
        tops[0] = 0;
        // 第1个栈的元素个数
        counts[0] = 0;

        // 第2个栈插入元素时的索引位置
        tops[1] = stackSize;
        // 第2个栈的元素个数
        counts[1] = 0;

        // 第3个栈插入元素时的索引位置
        tops[2] = 2 * stackSize;
        // 第3个栈的元素个数
        counts[2] = 0;
    }

    public boolean push(int stackID, int value) {
        if (counts[stackID] >= stackSize) {
            return false;
        }

        data[tops[stackID]] = value;
        tops[stackID]++;
        counts[stackID]++;
        return true;
    }

    public int pop(int stackID) {
        if (counts[stackID] == 0) {
            return -1;
        }

        tops[stackID]--;
        int ret = data[tops[stackID]];
        counts[stackID]--;

        return ret;
    }

    public int peek(int stackID) {
        if (counts[stackID] == 0) {
            return -1;
        }

        return data[tops[stackID]-1];
    }

    public boolean isEmpty(int stackID) {
        return counts[stackID] == 0;
    }
}