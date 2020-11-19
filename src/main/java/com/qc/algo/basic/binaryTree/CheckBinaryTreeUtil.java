package com.qc.algo.basic.binaryTree;

/**
 * description
 *
 * @author qinc 2020/10/21 9:23
 */
public class CheckBinaryTreeUtil {

    public static TreeNode createTreeNode(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > 1 && (level > maxLevel || Math.random() < 0.1)) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
}
