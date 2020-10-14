package com.qc.algo.basic.stack;

import java.util.Stack;

/**
 * 获取栈中最小值
 *
 * @author qinc 2020/10/14 8:52
 */
public class MinValueStack {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> mini = new Stack<>();

    public void push(Integer t) {
        data.push(t);
        if (mini.isEmpty()) {
            mini.push(t);
        } else {
            if (mini.peek().intValue() < t.intValue()) {
                mini.push(mini.peek());
            } else {
                mini.push(t);
            }
        }
    }

    public Integer pop() {
        if (data.isEmpty()) {
            return null;
        }
        mini.pop();
        return data.pop();
    }

    public Integer getMinValue() {
        return mini.peek();
    }

    public static void main(String[] args) {

        MinValueStack stack1 = new MinValueStack();
        stack1.push(3);
        System.out.println(stack1.getMinValue());
        stack1.push(4);
        System.out.println(stack1.getMinValue());
        stack1.push(1);
        System.out.println(stack1.getMinValue());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMinValue());

    }
}
