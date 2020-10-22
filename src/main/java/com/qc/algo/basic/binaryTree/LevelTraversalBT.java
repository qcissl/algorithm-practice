package com.qc.algo.basic.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description
 *
 * @author qinc 2020/10/21 9:01
 */
public class LevelTraversalBT {

    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.getValue());
            if (head.getLeft() != null) {
                queue.add(head.getLeft());
            }
            if (head.getRight() != null) {
                queue.add(head.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        level(head);
        System.out.println("========");
    }
}
