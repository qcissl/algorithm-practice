package com.qc.algo.basic.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * description
 *
 * @author qinc 2020/10/21 15:45
 */
public class TreeMaxWidth {

    public static int right(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head, 1);

        int currentLevel = 1;
        int level = 1;
        int size = 0;

        while (!queue.isEmpty()) {
            head = queue.poll();
            currentLevel = map.get(head);
            if (level == currentLevel) {
                size++;
            } else {
                max = Math.max(max, size);
                level++;
                size = 1;
            }
            if (head.getLeft() != null) {
                queue.add(head.getLeft());
                map.put(head.getLeft(), currentLevel + 1);
            }
            if (head.getRight() != null) {
                queue.add(head.getRight());
                map.put(head.getRight(), currentLevel + 1);
            }
        }
        return Math.max(max, size);
    }

    public static int maxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int max = 0;
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode endNode = head;
        TreeNode currentNode = head;

        while (!queue.isEmpty()) {
            head = queue.poll();
            size++;

            if (head.getLeft() != null) {
                queue.add(head.getLeft());
                endNode = head.getLeft();
            }
            if (head.getRight() != null) {
                queue.add(head.getRight());
                endNode = head.getRight();
            }

            if (head == currentNode) {
                max = Math.max(max, size);
                size = 0;
                currentNode = endNode;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            if ((size1 = right(head)) != (size2 = maxWidth(head))) {
                System.out.println(size1 + "--" + size2);
            }
        }
        System.out.println("finish!");

    }

}
