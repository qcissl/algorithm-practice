package com.qc.algo.trainingCamp.slidingWindow;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * description
 *
 * @author qinc 2020/11/14 9:27
 */
public class SlidingWindowMaxArray {

    public static int[] getMax(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w == 0 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];

        int L = 0;
        int R = 0;
        int index = 0;
        while (index < arr.length) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[R]) {
                queue.pollLast();
            }
            queue.addLast(R);
            if ((R - L + 1) < w) {
                R++;
            } else {
                R++;
                result[index - w + 1] = arr[queue.peekFirst()];
                if (queue.peekFirst() == L) {
                    queue.pop();
                }
                L++;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 10;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = CheckCompareSortUtil.createArray(maxSize, maxValue);
            int w = (int) (Math.random() * arr.length);
            int[] ans1 = getMax(arr, w);
            int[] ans2 = rightWay(arr, w);
            if (!CheckCompareSortUtil.checkArray(ans1, ans2)) {
                System.out.println("Oops!");
                System.out.println(w);
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(ans1));
                System.out.println(Arrays.toString(ans2));
                break;
            }
        }
        System.out.println("test finish");
    }

    // for test
    public static int[] rightWay(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < arr.length) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);

            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }
}
