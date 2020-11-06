package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/06 8:57
 */
public class NQueens {

    public static int queen(int n) {
        if (n == 0) {
            return 0;
        }
        int[] record = new int[n];
        return process(record, 0);
    }

    public static int process(int[] record, int row) {
        if (row == record.length) {
            return 1;
        }
        int sum = 0;
        for (int column = 0; column < record.length; column++) {
            if (validate(record, column, row)) {
                record[row] = column;
                sum += process(record, row + 1);
            }
        }
        return sum;
    }

    private static boolean validate(int[] record, int column, int row) {
        for (int j = 0; j < row; j++) {
            if (record[j] == column || Math.abs(record[j] - column) == Math.abs(row - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;

        long start = System.currentTimeMillis();
        System.out.println(queen(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");
    }
}
