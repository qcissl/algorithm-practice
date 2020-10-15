package com.qc.algo.basic.partition;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/15 13:37
 */
public class Partition {

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }

        int num = arr[R];
        int left = L - 1;
        int index = L;

        while (index < R) {
            if (arr[index] <= num) {
                CheckCompareSortUtil.swap(left + 1, index, arr);
                left++;
            }
            index++;
        }
        CheckCompareSortUtil.swap(++left, R, arr);
        return left;
    }

    public static void main(String[] args) {
        int[] origin = CheckCompareSortUtil.createArray(10, 10);
        int[] copy = CheckCompareSortUtil.copyArray(origin);


        System.out.println(Arrays.toString(origin));
        System.out.println(partition(copy, 0, copy.length - 1));
        System.out.println(Arrays.toString(copy));
    }
}
