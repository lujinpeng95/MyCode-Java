package _06_Stacks_and_Queues._6_2_Array_Stack;

/**
 * 栈接口
 *
 * @author lujinpeng
 * @date 2023-09-05 7:23 下午
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
