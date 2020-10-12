package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 9:34
 */
public class DoubleNode<T> {

    private T value;
    private Node pre;
    private Node next;

    public DoubleNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
