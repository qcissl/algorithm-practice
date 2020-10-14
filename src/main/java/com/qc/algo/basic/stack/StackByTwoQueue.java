package com.qc.algo.basic.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 两个队列实现栈
 *
 * @author qinc 2020/10/14 9:14
 */
public class StackByTwoQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(Integer t) {
        Queue<Integer> temp = queue.isEmpty() ? help : queue;
        temp.add(t);
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }

        Queue<Integer> temp1 = queue.isEmpty() ? help : queue;
        Queue<Integer> temp2 = queue.isEmpty() ? queue : help;
        while (temp1.size() > 1) {
            temp2.add(temp1.poll());
        }
        return temp1.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty() && help.isEmpty();
    }

    public Integer peek() {
        Integer t = poll();
        Queue<Integer> temp1 = queue.isEmpty() ? help : queue;
        temp1.add(t);
        return t;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        StackByTwoQueue myStack = new StackByTwoQueue();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops1");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops2");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops3");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops4");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }
}
