package com.qc.algo.basic.sort;

/**
 * description
 *
 * @author qinc 2020/10/09 13:36
 */
public class BubblingSort implements ArraySort {
    @Override
    public void sortArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    CheckCompareSortUtil.swap(j, j + 1, arr);
                }
            }

        }
    }
}
