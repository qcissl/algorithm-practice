package com.qc.algo.basic.binarysearch;

import com.qc.algo.basic.sort.CheckUtil;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/11 19:28
 */
public class BinarySearch {

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L < R) {
//            mid = (L + R) / 2;
            mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return true;
            } else {
                if (num > arr[mid]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        return arr[L] == num;
    }

    /**
     * >=num 最左边
     *
     * @param arr
     * @param num
     * @return
     */
    public static int nearLeft(int arr[], int num) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int num = 22;
        for (int j = 0; j < 100; j++) {

            int[] origin = CheckUtil.createArray(10, 50);
            Arrays.sort(origin);
            boolean a = exist(origin, num);

            boolean b = false;
            for (int i = 0; i < origin.length; i++) {
                if (origin[i] == num) {
                    b = true;
                    break;
                }
            }

            if (a == b) {
                System.out.println("ok");
            } else {
                System.out.println(Arrays.toString(origin));
                System.out.println("a:" + a);
                System.out.println("b:" + b);
                System.out.println("error");
                break;
            }
        }
    }
}
