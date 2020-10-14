package com.qc.algo.basic.sort;

/**
 * description
 *
 * @author qinc 2020/10/14 11:30
 */
public class MergeSort implements ArraySort {

    @Override
    public void sortArray(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int left = L;
        int right = mid + 1;
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
            if (arr[left] <= arr[right]) {
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
    }

    public static void main(String[] args) {
        CheckCompareSortUtil.checkArray(new MergeSort());
    }
}
