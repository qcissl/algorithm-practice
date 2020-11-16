package com.qc.algo.trainingCamp.slidingWindow;

import com.qc.algo.basic.sort.CheckCompareSortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/11/14 9:14
 */
public class AllLessNumSubArray {

    public static int right(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        return process(arr, num, 0, new ArrayList<>());
    }

    public static int process(int[] arr, int num, int index, List<Integer> list) {
        if (index == arr.length) {
            if (list.size() == 0) {
                return 0;
            }
            list.sort((o1, o2) -> o1 - o2);
            if (list.get(list.size() - 1) - list.get(0) <= num) {
                return 1;
            }
            return 0;
        }
        int sum = 0;
        if (list.isEmpty()) {
            sum += process(arr, num, index + 1, new ArrayList<>());
        } else {
            list.sort((o1, o2) -> o1 - o2);
            if (list.get(list.size() - 1) - list.get(0) <= num) {
                sum++;
            }
        }
        sum += process(arr, num, index + 1, getList(list, arr[index]));
        return sum;
    }

    private static List<Integer> getList(List<Integer> list, int i) {
        List<Integer> list1 = new ArrayList<>(list);
        list1.add(i);
        return list1;
    }

    public static int lessNumSum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }

        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int sum = 0;
        int index = 0;
        int R = 0;

        while (index < arr.length) {

            while (R < arr.length) {
                while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[R]) {
                    maxQueue.pollLast();
                }
                maxQueue.addLast(R);

                while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[R]) {
                    minQueue.pollLast();
                }
                minQueue.addLast(R);
                if (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > num) {
                    break;
                }
                R++;
            }
            sum += R - index;
            if (maxQueue.peekFirst() == index) {
                maxQueue.pop();
            }
            if (minQueue.peekFirst() == index) {
                minQueue.pop();
            }
            index++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = CheckCompareSortUtil.createArray(10, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println(right(arr, 10));
        System.out.println(lessNumSum(arr, 10));
    }

}
