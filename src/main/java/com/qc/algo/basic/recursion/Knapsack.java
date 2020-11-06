package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/05 19:54
 */
public class Knapsack {

    public static int knapsack(int[] w, int[] v, int bag) {

        return process(w, v, 0, bag);
    }

    public static int process(int[] w, int[] v, int index, int remainder) {
        if (remainder < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, remainder);
        int p2 = process(w, v, index + 1, remainder - w[index]);
        if (p2 > -1) {
            p2 += v[index];
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(knapsack(weights, values, bag));
    }
}
