package io.wyp0596.node;

/**
 * 单向链表节点
 *
 * @author wangyupeng
 * @date 2018/7/4
 */
public class Node<T> {

    private T data;

    private Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return data + " => " + next;
    }
}
