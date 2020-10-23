package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.LinkedList;

/**
 * description
 *
 * @author qinc 2020/10/22 11:38
 */
public class CompleteBinaryTree {

    public static class Info {
        boolean isComplete;
        boolean isFull;
        int height;

        public Info(boolean isComplete, boolean isFull, int height) {
            this.isComplete = isComplete;
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isComplete(TreeNode head) {
        return process(head).isComplete;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true, true, 0);
        }
        Info left = process(head.getLeft());
        Info right = process(head.getRight());

        int height = Math.max(left.height, right.height) + 1;
        boolean isFull = left.isFull && right.isFull && left.height == right.height;

        boolean isComplete = false;
        if (left.height == right.height && left.isFull && right.isComplete) {
            isComplete = true;
        }
        if (left.height - right.height == 1 && right.isFull && left.isComplete) {
            isComplete = true;
        }
        return new Info(isComplete, isFull, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if (isCBT1(head) != isComplete(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null)) || (l == null && r != null)

            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
