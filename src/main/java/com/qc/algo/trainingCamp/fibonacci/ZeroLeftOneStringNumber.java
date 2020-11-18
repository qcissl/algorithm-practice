package com.qc.algo.trainingCamp.fibonacci;

/**
 * description
 *
 * @author qinc 2020/11/18 9:52
 */
public class ZeroLeftOneStringNumber {

    public static int f1(int n) {
        if (n <= 0) {
            return 0;
        }
        return process(n);
    }

    public static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum = 0;
        sum += process(n - 1);
        sum += process(n - 2);
        return sum;
    }

    public static int f2(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int f3(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = FibonacciProblem.matrixPower(base, n - 2);
        return 2 * result[0][0] + result[1][0];
    }

    public static void main(String[] args) {

        int n = 18;
//        Stack<Integer> stack = new Stack<>();
//        while (n > 0) {
//            if ((n & 1) != 0) {
//                stack.push(1);
//            } else {
//                stack.push(0);
//            }
//            n = n >> 1;
//        }
//        int[] arr = new int[stack.size()];
//        int index = 0;
//        while (!stack.isEmpty()) {
//            arr[index++] = stack.pop();
//        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(f1(n));
        System.out.println(f2(n));
        System.out.println(f3(n));
    }
}
