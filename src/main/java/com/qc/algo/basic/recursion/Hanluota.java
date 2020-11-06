package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/04 9:26
 */
public class Hanluota {

    public static int hanluota(int N) {
        return process(N, "left", "right", "mid", 0);
    }

    public static int process(int N, String from, String to, String other, int size) {
        if (N == 1) {
            size++;
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            size = process(N - 1, from, other, to, size);
            size++;
            System.out.println("Move " + N + " from " + from + " to " + to);
            size = process(N - 1, other, to, from, size);
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(hanluota(3));
    }
}
