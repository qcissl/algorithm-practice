package com.qc.algo.basic.dp;

/**
 * description
 *
 * @author qinc 2020/11/08 20:21
 */
public class CoinsWay {

    public static int ways(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        return process(arr, 0, target);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    public static int ways1(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return process1(arr, 0, target, dp);
    }

    public static int process1(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process1(arr, index + 1, rest - (zhang * arr[index]), dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static int ways2(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][target + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int rest = 0; rest <= target; rest++) {
                for (int zhang = 0; zhang * arr[i] <= rest; zhang++) {
                    dp[i][rest] += dp[i + 1][rest - (zhang * arr[i])];
                }
            }
        }
        return dp[0][target];
    }

    public static int ways3(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][target + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int rest = 0; rest <= target; rest++) {
                dp[i][rest] = dp[i + 1][rest];
                if (rest - arr[i] >= 0) {
                    dp[i][rest] += dp[i][rest - arr[i]];
                }
            }
        }
        return dp[0][target];
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 50, 100};
        int sum = 1000;
        System.out.println(ways(arr, sum));
        System.out.println(ways1(arr, sum));
        System.out.println(ways2(arr, sum));
        System.out.println(ways3(arr, sum));
    }
}
