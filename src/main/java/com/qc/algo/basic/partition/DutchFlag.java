package com.qc.algo.basic.partition;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;

/**
 * description
 *
 * @author qinc 2020/10/15 14:46
 */
public class DutchFlag {

    public static int[] dutchFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int num = arr[R];
        int left = L - 1;
        int right = R + 1;
        int index = L;

        while (index < right) {
            if (arr[index] < num) {
                CheckCompareSortUtil.swap(++left, index, arr);
                index++;
            } else if (arr[index] > num) {
                CheckCompareSortUtil.swap(index, --right, arr);
            } else {
                index++;
            }
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        int[] origin = CheckCompareSortUtil.createArray(10, 10);
        int[] copy = CheckCompareSortUtil.copyArray(origin);

        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(dutchFlag(copy, 0, copy.length - 1)));
        System.out.println(Arrays.toString(copy));
    }
}
