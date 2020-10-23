package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

/**
 * description
 *
 * @author qinc 2020/10/22 10:06
 */
public class BalancedBinaryTree {

    public static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalance, int height) {
            this.isBalanced = isBalance;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info left = process(head.getLeft());
        Info right = process(head.getRight());
        boolean isBalance = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) < 2);
        int height = Math.max(right.height, left.height) + 1;
        return new Info(isBalance, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isBalanced1(TreeNode head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(TreeNode head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
