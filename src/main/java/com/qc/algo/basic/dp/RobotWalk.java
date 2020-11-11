package com.qc.algo.basic.dp;

/**
 * description
 *
 * @author qinc 2020/11/06 22:18
 */
public class RobotWalk {

    public static int walk(int N, int M, int K, int P) {
        if (N < 2 || M > N || P > N) {
            return 0;
        }
        return process(N, P, K, M);
    }

    public static int process(int range, int end, int size, int move) {
        if (size == 0 && move == end) {
            return 1;
        }

        int sum = 0;
        if (size > 0) {
            if (move == 1) {
                sum += process(range, end, size - 1, move + 1);
            } else if (move == range) {
                sum += process(range, end, size - 1, move - 1);
            } else {
                sum += process(range, end, size - 1, move - 1);
                sum += process(range, end, size - 1, move + 1);
            }
        }
        return sum;
    }

    public static int walk1(int N, int M, int K, int P) {
        if (N < 2 || M > N || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return process1(N, P, K, M, dp);
    }

    public static int process1(int range, int end, int size, int move, int[][] dp) {
        if (dp[size][move] != -1) {
            return dp[size][move];
        }
        if (size == 0 && move == end) {
            dp[size][move] = 1;
            return 1;
        }

        int sum = 0;
        if (size > 0) {
            if (move == 1) {
                sum += process1(range, end, size - 1, move + 1, dp);
            } else if (move == range) {
                sum += process1(range, end, size - 1, move - 1, dp);
            } else {
                sum += process1(range, end, size - 1, move - 1, dp);
                sum += process1(range, end, size - 1, move + 1, dp);
            }
        }
        dp[size][move] = sum;
        return sum;
    }

    public static int walk2(int N, int M, int K, int P) {
        if (N < 2 || M > N || P > N) {
            return 0;
        }
        int[][] dp = new int[K + 1][N + 1];
        dp[0][M] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[K][P];
    }

    public static void main(String[] args) {
        System.out.println(walk(7, 4, 13, 3));
        System.out.println(walk1(7, 4, 13, 3));
        System.out.println(walk2(7, 4, 13, 3));
    }
}
