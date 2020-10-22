package com.qc.algo.basic.binaryTree;

/**
 * description
 *
 * @author qinc 2020/10/22 9:41
 */
public class PaperFolding {

    public static void printAllFolds(int N) {
        process(1, N, true);
    }

    public static void process(int k, int N, boolean flag) {
        if (k > N) {
            return;
        }
        process(k + 1, N, true);
        System.out.println(flag == true ? "down" : "up");
        process(k + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 10;
        printAllFolds(N);
    }
}
