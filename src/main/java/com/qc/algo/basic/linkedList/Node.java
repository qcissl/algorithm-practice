package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 9:32
 */
public class Node<T> {

    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
