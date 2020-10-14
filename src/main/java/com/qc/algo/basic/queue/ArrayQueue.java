package com.qc.algo.basic.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数组实现队列
 *
 * @author qinc 2020/10/12 16:30
 */
public class ArrayQueue {

    private int[] arr;
    private int limit;
    private int pushIndex = 0;
    private int popIndex = 0;
    private int size = 0;

    public ArrayQueue(int limit) {
        this.limit = limit;
        this.arr = new int[limit];
    }

    public void push(int t) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        size++;
        arr[pushIndex++] = t;
        pushIndex = convertIndex(pushIndex);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        size--;
        int value = arr[popIndex++];
        popIndex = convertIndex(popIndex);
        return value;
    }

    private int convertIndex(int index) {
        return limit > index ? index : 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public static void main(String[] args) {
        ArrayQueue myStack = new ArrayQueue(10);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            int value = (int) (Math.random() * 1000);
            if (myStack.isEmpty()) {
                myStack.push(value);
                queue.add(value);
            } else {
                if (Math.random() < 0.5 && !myStack.isFull()) {
                    myStack.push(value);
                    queue.add(value);
                } else {
                    if (myStack.pop() != queue.poll().intValue()) {
                        System.out.println("第" + i + "次:error");
                    }
                }
            }
        }
        System.out.println("ok");
    }
}
