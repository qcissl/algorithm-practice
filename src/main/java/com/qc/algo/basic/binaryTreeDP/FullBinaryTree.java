package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

/**
 * description
 *
 * @author qinc 2020/10/22 11:09
 */
public class FullBinaryTree {

    public static class Info {
        boolean isFull;
        int height;

        public Info(boolean isFull, int height) {
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isFull(TreeNode head) {
        return process(head).isFull;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info left = process(head.getLeft());
        Info right = process(head.getRight());
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        int height = left.height + 1;
        return new Info(isFull, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (isFull1(head) != isFull(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isFull1(TreeNode head) {
        if (head == null) {
            return true;
        }
        int height = h(head);
        int nodes = n(head);
        return (1 << height) - 1 == nodes;
    }

    public static int h(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return Math.max(h(head.left), h(head.right)) + 1;
    }

    public static int n(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return n(head.left) + n(head.right) + 1;
    }
}
