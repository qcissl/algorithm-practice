package com.qc.algo.trainingCamp.fibonacci;

/**
 * description
 *
 * @author qinc 2020/11/18 8:26
 */
public class FibonacciProblem {

    public static int f0(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return f0(n - 1) + f0(n - 2);
    }

    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = matrixPower(base, n - 2);
        return result[0][0] + result[1][0];
    }

    public static int[][] matrixPower(int[][] base, int p) {
        int[][] result = new int[2][2];
        result[0][0] = 1;
        result[1][1] = 1;

        while (p > 0) {
            if ((p & 1) != 0) {
                result = matrixMul(result, base);
            }
            base = matrixMul(base, base);
            p = p >> 1;
        }
        return result;
    }

    private static int[][] matrixMul(int[][] m, int[][] b) {
        int[][] temp = {
                {m[0][0] * b[0][0] + m[0][1] * b[1][0], m[0][0] * b[0][1] + m[0][1] * b[1][1]},
                {m[1][0] * b[0][0] + m[1][1] * b[1][0], m[1][0] * b[0][1] + m[1][1] * b[1][1]}
        };
        return temp;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(f0(n));
        System.out.println(f1(n));
        System.out.println(f2(n));
    }
}
