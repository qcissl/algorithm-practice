package com.qc.algo.basic.queue;

import com.qc.algo.basic.stack.MyStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/12 15:09
 */
public class MyQueue<T> {

    private DoubleEndsQueue<T> doubleEndsQueue = new DoubleEndsQueue<>();

    public boolean isEmpty() {
        return doubleEndsQueue.isEmpty();
    }

    public void push(T t) {
        doubleEndsQueue.addFromHead(t);
    }

    public T poll() {
        return doubleEndsQueue.popFromTail();
    }

    public static void main(String[] args) {

        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 500; i++) {
            int value = (int) (Math.random()*1000);
            if (queue.isEmpty()){
                myQueue.push(value);
                queue.add(value);
            }else{
                if (Math.random() < 0.5){
                    myQueue.push(value);
                    queue.add(value);
                }else{
                    if (myQueue.poll().intValue()!= queue.poll().intValue()){
                        System.out.println("error");
                    }
                }
            }
        }
        System.out.println("ok");
    }
}
