package com.qc.algo.basic.queue;

import com.qc.algo.basic.linkedList.DoubleNode;
import com.qc.algo.basic.linkedList.Node;

/**
 * description
 *
 * @author qinc 2020/10/12 14:44
 */
public class DoubleEndsQueue<T> {

    DoubleNode<T> head;
    DoubleNode<T> tail;

    public void addFromHead(T t) {
        DoubleNode<T> node = new DoubleNode<>(t);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.setPre(node);
            node.setNext(head);
            head = node;
        }
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        }
        DoubleNode<T> node = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPre(null);
            node.setNext(null);
        }
        return node.getValue();
    }

    public void addFromTail(T t) {
        DoubleNode<T> node = new DoubleNode<>(t);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.setNext(node);
            node.setPre(tail);
            tail = node;
        }
    }

    public T popFromTail() {
        if (tail == null) {
            return null;
        }
        DoubleNode<T> node = tail;
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.getPre();
            tail.setNext(null);
            node.setPre(null);
        }

        return node.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

}
