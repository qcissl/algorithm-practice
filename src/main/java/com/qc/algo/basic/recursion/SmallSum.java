package com.qc.algo.basic.recursion;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;

/**
 * 小和累加
 *
 * @author qinc 2020/10/15 8:56
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null && arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 2);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];

        int left = L;
        int right = mid + 1;
        int sum = 0;
        for (int i = 0; i < help.length; i++) {
            if (left > mid) {
                help[i] = arr[right];
                right++;
                continue;
            }
            if (right > R) {
                help[i] = arr[left];
                left++;
                continue;
            }
            if (arr[left] < arr[right]) {
                sum += arr[left] * (R - right + 1);
                help[i] = arr[left];
                left++;
            } else {
                help[i] = arr[right];
                right++;
            }
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CheckCompareSortUtil.createArray(maxSize, maxValue);
            int[] arr2 = CheckCompareSortUtil.copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                System.out.println(smallSum(arr1));
                System.out.println(comparator(arr2));
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }
}
