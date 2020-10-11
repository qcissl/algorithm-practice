package com.qc.algo.basic.exor;

/**
 * description
 *
 * @author qinc 2020/10/11 23:29
 */
public class ExorOption {

    /**
     * 找出只有一个出现奇数次的数
     *
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr) {
        int exor = 0;
        for (int i = 0; i < arr.length; i++) {
            exor = exor ^ arr[i];
        }
        System.out.println(exor);
    }

    /**
     * 找出只有两个出现奇数次的数
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int exor = 0;
        for (int i = 0; i < arr.length; i++) {
            exor = exor ^ arr[i];
        }
        int rightOne = exor & (~exor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            onlyOne = onlyOne ^ ((rightOne & arr[i]) != 0 ? arr[i] : 0);
        }

        System.out.println((exor ^ onlyOne) + " " + onlyOne);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
