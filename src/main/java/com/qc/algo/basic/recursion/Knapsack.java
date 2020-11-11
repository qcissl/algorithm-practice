package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/05 19:54
 */
public class Knapsack {

    public static int knapsack(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0 || v.length == 0 || bag <= 0) {
            return 0;
        }
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

    public static int knapsack1(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0 || v.length == 0 || bag <= 0) {
            return 0;
        }
        int[][] dp = new int[w.length + 1][bag + 1];
        for (int index = w.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][bag];
                if (rest - w[index] >= 0) {
                    dp[index][rest] = Math.max(dp[index + 1][rest], dp[index + 1][rest - w[index]] + v[index]);
                }
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(knapsack(weights, values, bag));
        System.out.println(knapsack1(weights, values, bag));
    }
}
