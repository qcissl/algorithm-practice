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

    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5, 19, 29, 80, 4};
        System.out.println(winner(arr));
    }
}
