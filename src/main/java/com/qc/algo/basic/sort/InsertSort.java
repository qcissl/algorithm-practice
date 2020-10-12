package com.qc.algo.basic.sort;

/**
 * description
 *
 * @author qinc 2020/10/09 14:01
 */
public class InsertSort implements ArraySort {
    @Override
    public void sortArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                CheckCompareSortUtil.swap(j, j - 1, arr);
            }
        }
    }
}
