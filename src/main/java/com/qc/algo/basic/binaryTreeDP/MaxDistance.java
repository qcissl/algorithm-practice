package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * description
 *
 * @author qinc 2020/10/22 19:13
 */
public class MaxDistance {

    public static class Info {
        int max;
        int height;

        public Info(int max, int height) {
            this.max = max;
            this.height = height;
        }
    }

    public static int maxDistance(TreeNode head) {
        return process(head).max;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(0, 0);
        }

        Info left = process(head.getLeft());
        Info right = process(head.getRight());

        int height = Math.max(left.height, right.height) + 1;
        int max = Math.max(left.max, right.max);
        max = Math.max(max, left.height + right.height + 1);
        return new Info(max, height);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (maxDistance1(head) != maxDistance(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static int maxDistance1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = getPrelist(head);
        HashMap<TreeNode, TreeNode> parentMap = getParentMap(head);
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    public static ArrayList<TreeNode> getPrelist(TreeNode head) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        fillPrelist(head, arr);
        return arr;
    }

    public static void fillPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static HashMap<TreeNode, TreeNode> getParentMap(TreeNode head) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(head, null);
        fillParentMap(head, map);
        return map;
    }

    public static void fillParentMap(TreeNode head, HashMap<TreeNode, TreeNode> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }

    public static int distance(HashMap<TreeNode, TreeNode> parentMap, TreeNode o1, TreeNode o2) {
        HashSet<TreeNode> o1Set = new HashSet<>();
        TreeNode cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        TreeNode lowestAncestor = cur;
        cur = o1;
        int distance1 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance1++;
        }
        cur = o2;
        int distance2 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance2++;
        }
        return distance1 + distance2 - 1;
    }
}
