package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.ArrayList;

/**
 * description
 *
 * @author qinc 2020/10/22 14:25
 */
public class SearchBinaryTree {

    public static class Info {
        boolean isSearch;
        int max;
        int min;

        public Info(boolean isSearch, int max, int min) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isSearch(TreeNode head) {
        return process(head).isSearch;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }

        Info left = process(head.getLeft());
        Info right = process(head.getRight());

        int max = Math.max(head.value, left == null ? Integer.MIN_VALUE : left.max);
        max = Math.max(max, right == null ? Integer.MIN_VALUE : right.max);
        int min = Math.min(head.value, left == null ? Integer.MAX_VALUE : left.min);
        min = Math.min(min, right == null ? Integer.MAX_VALUE : right.min);

        boolean isSearch = head.value > (left == null ? Integer.MIN_VALUE : left.max)
                && head.value < (right == null ? Integer.MAX_VALUE : right.min)
                && (right == null ? true : right.isSearch) && (left == null ? true : left.isSearch);
        return new Info(isSearch, max, min);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (isBST1(head) != isSearch(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }
}
