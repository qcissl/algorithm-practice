package com.qc.algo.basic.greedy;

import java.util.*;

/**
 * description
 *
 * @author qinc 2020/10/28 10:01
 */
public class BestArrange {

    public static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int right(Program[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> use = new HashSet<>();
        process(arr, use, list, 0, 0);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        return list.get(0);
    }

    public static void process(Program[] arr, Set<Integer> use, List<Integer> list, int size, int line) {
        if (use.size() == arr.length) {
            list.add(size);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    if (arr[i].start < line) {
                        process(arr, use, list, size, line);
                    } else {
                        process(arr, use, list, size + 1, arr[i].end);
                    }
                    use.remove(i);
                }
            }
        }
    }

    public static int best(Program[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });

        int size = 0;
        int line = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].start >= line) {
                size++;
                line = arr[i].end;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int programSize = 8;
        int timeMax = 20;
        int timeTimes = 100000;
        for (int i = 0; i < timeTimes; i++) {
            Program[] programs = generatePrograms(programSize, timeMax);
            if (right(programs) != best(programs)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static Program[] generatePrograms(int programSize, int timeMax) {
        Program[] ans = new Program[(int) (Math.random() * (programSize + 1))];
        for (int i = 0; i < ans.length; i++) {
            int r1 = (int) (Math.random() * (timeMax + 1));
            int r2 = (int) (Math.random() * (timeMax + 1));
            if (r1 == r2) {
                ans[i] = new Program(r1, r1 + 1);
            } else {
                ans[i] = new Program(Math.min(r1, r2), Math.max(r1, r2));
            }
        }
        return ans;
    }
}
