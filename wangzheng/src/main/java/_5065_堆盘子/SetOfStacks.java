package _5065_堆盘子;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：一堆盘子堆叠到指定数目后，需要换另一个堆。实现这一个具有现实意义的数据结构，满足栈的各种操作
 * 
 * @author lujinpeng
 * @date 2024-07-10 6:13 下午
 */
public class SetOfStacks {

    private List<Stack<Integer>> stackList = new ArrayList<>();
    private int sizePerStack;
    // 插入元素的索引位置
    private int top;
    // stackList中第几个 stack
    private int index;

    public SetOfStacks(int sizePerStack) {
        this.sizePerStack = sizePerStack;
        stackList.add(new Stack<>());
        this.top = 0;
        this.index = 0;
    }

    public void push(int value) {
        // 栈满扩容
        if (this.top == this.sizePerStack && this.index == stackList.size() - 1) {
            this.stackList.add(new Stack<>());
            this.top = 0;
            this.index++;
        }

        Stack<Integer> stack = this.stackList.get(this.index);
        stack.push(value);
        this.top++;
    }

    public int pop() {
        // 栈空
        if (this.isEmpty()) {
            return -1;
        }
        // 非第一个栈为空
        if (this.top == 0 && this.index > 0) {
            // 切换成前一个栈
            this.index--;
            this.top = this.sizePerStack;
        }

        this.top--;
        return this.stackList.get(this.index).pop();
    }

    public int peek() {
        // 栈空
        if (this.isEmpty()) {
            return -1;
        }
        // 非第一个栈为空
        if (this.top == 0 && this.index > 0) {
            // 切换成前一个栈
            this.index--;
            this.top = this.sizePerStack;
        }

        return this.stackList.get(this.index).peek();
    }

    public boolean isEmpty() {
        return this.top == 0 && this.index == 0;
    }
}

