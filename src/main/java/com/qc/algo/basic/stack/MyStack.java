package com.qc.algo.basic.stack;

import com.qc.algo.basic.queue.DoubleEndsQueue;

import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/12 15:14
 */
public class MyStack<T> {

    private DoubleEndsQueue<T> doubleEndsQueue = new DoubleEndsQueue<>();

    public boolean isEmpty() {
        return doubleEndsQueue.isEmpty();
    }

    public void push(T t) {
        doubleEndsQueue.addFromHead(t);
    }

    public T pop() {
        return doubleEndsQueue.popFromHead();
    }

    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 500; i++) {
            int value = (int) (Math.random() * 1000);
            if (stack.isEmpty()) {
                myStack.push(value);
                stack.push(value);
            } else {
                if (Math.random() < 0.5) {
                    myStack.push(value);
                    stack.push(value);
                } else {
                    if (myStack.pop().intValue() != stack.pop().intValue()) {
                        System.out.println("error");
                    }
                }
            }
        }
        System.out.println("ok");
    }
}
