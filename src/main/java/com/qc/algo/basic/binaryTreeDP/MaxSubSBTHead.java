package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.ArrayList;

/**
 * description
 *
 * @author qinc 2020/10/22 15:11
 */
public class MaxSubSBTHead {

    public static class Info {
        boolean isSearch;
        int max;
        int min;
        int size;
        TreeNode head;

        public Info(boolean isSearch, int max, int min, int size, TreeNode head) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
            this.size = size;
            this.head = head;
        }
    }

    public static TreeNode findSubHead(TreeNode head) {
        return process(head).head;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }

        Info left = process(head.getLeft());
        Info right = process(head.getRight());

        int max = head.value;
        int min = head.value;
        int size = 0;
        TreeNode node = head;
        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            size = Math.max(size, left.size);
            node = left.head;
        }
        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            if (size < right.size) {
                node = right.head;
                size = right.size;
            }
        }

        boolean isSearch = head.value > (left == null ? Integer.MIN_VALUE : left.max)
                && head.value < (right == null ? Integer.MAX_VALUE : right.min)
                && (left == null ? true : left.isSearch)
                && (right == null ? true : right.isSearch);
        if (isSearch) {
            node = head;
            size = (left == null ? 0 : left.size) + (right == null ? 0 : right.size) + 1;
        }
        return new Info(isSearch, max, min, size, node);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != findSubHead(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static int getBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static TreeNode maxSubBSTHead1(TreeNode head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        TreeNode leftAns = maxSubBSTHead1(head.left);
        TreeNode rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }
}
