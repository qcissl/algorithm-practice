package com.qc.algo.basic.queue;

import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author qinc 2020/10/14 10:01
 */
public class QueueByTwoStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void add(Integer t) {
        if (isEmpty()) {
            data.push(t);
        } else {
            if (data.isEmpty()) {
                while (help.size() > 0) {
                    data.push(help.pop());
                }
            }
            data.push(t);
        }
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        if (help.isEmpty()) {
            while (data.size() > 0) {
                help.push(data.pop());
            }
        }
        return help.pop();
    }

    public Integer peek() {
        Integer t = poll();
        help.push(t);
        return t;
    }

    public boolean isEmpty() {
        return data.isEmpty() && help.isEmpty();
    }

    public static void main(String[] args) {
        QueueByTwoStack test = new QueueByTwoStack();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        test.add(4);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
