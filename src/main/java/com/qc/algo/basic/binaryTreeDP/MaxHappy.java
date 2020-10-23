package com.qc.algo.basic.binaryTreeDP;

import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/10/23 8:50
 */
public class MaxHappy {

    public static class Employee {
        int happy;
        List<Employee> subordinates;

        public Employee(int happy) {
            this.happy = happy;
            subordinates = new LinkedList<>();
        }
    }

    public static class Info {
        int go;
        int stay;

        public Info(int go, int stay) {
            this.go = go;
            this.stay = stay;
        }
    }

    public static int maxHappy(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info info = process(boss);
        return Math.max(info.go, info.stay);
    }

    public static Info process(Employee employee) {
        if (employee.subordinates.isEmpty()) {
            return new Info(employee.happy, 0);
        }
        int go = employee.happy;
        int stay = 0;
        for (int i = 0; i < employee.subordinates.size(); i++) {
            Info info = process(employee.subordinates.get(i));
            go += info.stay;
            stay += Math.max(info.go, info.stay);
        }
        return new Info(go, stay);
    }



    public static void main(String[] args) {
        int maxLevel = 4;
        int maxNexts = 7;
        int maxHappy = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            Employee boss = genarateBoss(maxLevel, maxNexts, maxHappy);
            if (maxHappy1(boss) != maxHappy(boss)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static int maxHappy1(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process1(boss, false);
    }

    // 当前来到的节点叫cur，
    // up表示cur的上级是否来，
    // 该函数含义：
    // 如果up为true，表示在cur上级已经确定来，的情况下，cur整棵树能够提供最大的快乐值是多少？
    // 如果up为false，表示在cur上级已经确定不来，的情况下，cur整棵树能够提供最大的快乐值是多少？
    public static int process1(Employee cur, boolean up) {
        if (up) { // 如果cur的上级来的话，cur没得选，只能不来
            int ans = 0;
            for (Employee next : cur.subordinates) {
                ans += process1(next, false);
            }
            return ans;
        } else { // 如果cur的上级不来的话，cur可以选，可以来也可以不来
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee next : cur.subordinates) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    // for test
    public static Employee genarateBoss(int maxLevel, int maxNexts, int maxHappy) {
        if (Math.random() < 0.02) {
            return null;
        }
        Employee boss = new Employee((int) (Math.random() * (maxHappy + 1)));
        genarateNexts(boss, 1, maxLevel, maxNexts, maxHappy);
        return boss;
    }

    // for test
    public static void genarateNexts(Employee e, int level, int maxLevel, int maxNexts, int maxHappy) {
        if (level > maxLevel) {
            return;
        }
        int nextsSize = (int) (Math.random() * (maxNexts + 1));
        for (int i = 0; i < nextsSize; i++) {
            Employee next = new Employee((int) (Math.random() * (maxHappy + 1)));
            e.subordinates.add(next);
            genarateNexts(next, level + 1, maxLevel, maxNexts, maxHappy);
        }
    }
}
