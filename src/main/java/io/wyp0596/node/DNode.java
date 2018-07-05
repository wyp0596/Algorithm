package io.wyp0596.node;

/**
 * 双向链表节点
 *
 * @author wangyupeng
 * @date 2018/7/4
 */
public class DNode<T> {

    private T data;

    private DNode<T> pre;

    private DNode<T> next;

    public T getData() {
        return data;
    }

    public DNode<T> setData(T data) {
        this.data = data;
        return this;
    }

    public DNode<T> getPre() {
        return pre;
    }

    public DNode<T> setPre(DNode<T> pre) {
        this.pre = pre;
        return this;
    }

    public DNode<T> getNext() {
        return next;
    }

    public DNode<T> setNext(DNode<T> next) {
        this.next = next;
        return this;
    }
}
