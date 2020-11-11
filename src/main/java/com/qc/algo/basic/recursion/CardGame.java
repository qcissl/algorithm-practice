package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/06 8:30
 */
public class CardGame {

    public static int winner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    public static int first(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + second(arr, L + 1, R), arr[R] + second(arr, L, R - 1));
    }

    public static int second(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(first(arr, L + 1, R), first(arr, L, R - 1));
    }

    public static int winnerDp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            f[i][i] = arr[i];
        }

        for (int L = arr.length - 2; L >= 0; L--) {
            for (int R = 1; R < arr.length; R++) {
                if (L <= R) {
                    f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                    s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                }
            }
        }

        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(winner(arr));
        System.out.println(winnerDp(arr));
    }
}
