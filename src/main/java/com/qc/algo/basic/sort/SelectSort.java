package com.qc.algo.basic.sort;

/**
 * description
 *
 * @author qinc 2020/10/09 11:22
 */
public class SelectSort implements ArraySort {

    @Override
    public void sortArray(int[] arr) {
        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            CheckCompareSortUtil.swap(i, minIndex, arr);
        }
    }


}
