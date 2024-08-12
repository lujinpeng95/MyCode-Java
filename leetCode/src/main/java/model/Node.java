package model;

/**
 * @author lujinpeng
 * @date 2024-08-12 11:02
 */
public class Node<E> {
    public E val;
    public Node<E> left;
    public Node<E> right;
    public Node<E> next;

    public Node() {}

    public Node(E val) {
        this.val = val;
    }

    public Node(E val, Node<E> left, Node<E> right, Node<E> next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString(){
        return val.toString();
    }
}
