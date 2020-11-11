package com.qc.algo.basic.dp;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/11/11 11:09
 */
public class WashCoffee {

    public static int wash(int[] arr, int washTime, int autoTime) {
        Arrays.sort(arr);
        if (arr == null || arr.length == 0 || washTime <= 0 || autoTime <= 0) {
            return 0;
        }
        if (autoTime <= washTime) {
            return arr[arr.length - 1] + autoTime;
        }
        return process(arr, washTime, autoTime, 0, 0);
    }

    public static int process(int[] arr, int washTime, int autoTime, int index, int washLine) {
        if (index == arr.length - 1) {
            return Math.min(Math.max(washLine, arr[index]) + washTime, arr[index] + autoTime);
        }
        int wash = Math.max(washLine, arr[index]) + washTime;
        int next1 = process(arr, washTime, autoTime, index + 1, wash);
        int p1 = Math.max(wash, next1);
        int auto = arr[index] + autoTime;
        int next2 = process(arr, washTime, autoTime, index + 1, washLine);
        int p2 = Math.max(auto, next2);
        return Math.min(p1, p2);
    }

    public static int dp(int[] arr, int washTime, int autoTime) {
        Arrays.sort(arr);
        if (arr == null || arr.length == 0 || washTime <= 0 || autoTime <= 0) {
            return 0;
        }
        if (autoTime <= washTime) {
            return arr[arr.length - 1] + autoTime;
        }

        int washLine = 0;
        for (int i = 0; i < arr.length; i++) {
            washLine = Math.max(washLine, arr[i]) + washTime;
        }

        int[][] dp = new int[arr.length][washLine + 1];
        for (int i = 0; i <= washLine; i++) {
            dp[arr.length - 1][i] = Math.min(Math.max(i, arr[arr.length - 1]) + washTime, arr[arr.length - 1] + autoTime);
        }

        for (int index = arr.length - 2; index >= 0; index--) {
            for (int i = 0; i <= washLine; i++) {
                int wash = Math.max(i, arr[index]) + washTime;
                int next1 = Integer.MIN_VALUE;
                if (wash <= washLine) {
                    next1 = dp[index + 1][wash];
                }
                int p1 = Math.max(wash, next1);
                int auto = arr[index] + autoTime;
                int next2 = dp[index + 1][i];
                int p2 = Math.max(auto, next2);
                dp[index][i] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 5, 5, 7, 10, 12, 12, 12, 12, 12, 12, 15};
        int a1 = 3;
        int b1 = 10;
        System.out.println(wash(test, a1, b1));
        System.out.println(dp(test, a1, b1));
    }
}
