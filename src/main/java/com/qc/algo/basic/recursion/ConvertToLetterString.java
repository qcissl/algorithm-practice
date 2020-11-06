package com.qc.algo.basic.recursion;

/**
 * description
 *
 * @author qinc 2020/11/05 19:34
 */
public class ConvertToLetterString {

    public static int convert(String str) {

        return process(str.toCharArray(), 0);
    }

    public static int process(char[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        int sum = 0;
        if (arr[index] == '0') {
            return 0;
        } else if (arr[index] == '1') {
            sum = process(arr, index + 1);
            if (index + 1 < arr.length) {
                sum += process(arr, index + 2);
            }
        } else if (arr[index] == '2') {
            sum = process(arr, index + 1);
            if (index + 1 < arr.length && arr[index + 1] >= '1' && arr[index + 1] <= '3') {
                sum += process(arr, index + 2);
            }
        } else {
            sum = process(arr, index + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(convert("111618222"));
    }
}
