package com.qc.algo.basic.greedy;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.PriorityQueue;

/**
 * description
 *
 * @author qinc 2020/10/23 19:24
 */
public class LessMoneySplitGold {

    public static int right(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = process(arr, 0);
        return ans;
    }

    public static int process(int[] arr, int pre) {
        if (arr.length == 1) {
            return pre;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, process(copyArr(arr, i, j), pre + arr[i] + arr[j]));
            }
        }

        return ans;
    }

    private static int[] copyArr(int[] arr, int i, int j) {
        int[] array = new int[arr.length - 1];
        int index = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                array[index++] = arr[k];
            }
        }
        array[index] = arr[i] + arr[j];
        return array;
    }

    public static int less(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int sum = 0;
        while (queue.size() > 1) {
            int t = queue.poll() + queue.poll();
            sum += t;
            queue.add(t);
        }
        return sum;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 6;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = CheckCompareSortUtil.createArray(maxSize, maxValue);
            if (right(arr) != less(arr)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
