package com.qc.algo.basic.recursion;

import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/11/04 11:21
 */
public class ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack){
        if (stack==null||stack.isEmpty()){
            return;
        }
        process(stack);
    }

    public static void process(Stack<Integer> stack){
        int t = f(stack);
        if (!stack.isEmpty()){
            process(stack);
        }
        stack.push(t);
    }

    public static Integer f(Stack<Integer> stack){
        int t =stack.pop();
        int c = t;
        if (!stack.isEmpty()){
            c = f(stack);
            stack.push(t);
        }
        return c;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("-----------------------------------");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
