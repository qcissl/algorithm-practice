package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/20 16:17
 */
public class RandomNode {

    int value;
    RandomNode next;
    RandomNode rand;

    public RandomNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RandomNode getNext() {
        return next;
    }

    public void setNext(RandomNode next) {
        this.next = next;
    }

    public RandomNode getRand() {
        return rand;
    }

    public void setRand(RandomNode rand) {
        this.rand = rand;
    }
}
