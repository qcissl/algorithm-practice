package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 9:34
 */
public class DoubleNode<T> {

    private T value;
    private DoubleNode pre;
    private DoubleNode next;

    public DoubleNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
