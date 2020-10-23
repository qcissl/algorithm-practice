package com.qc.algo.basic.binaryTreeDP;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * description
 *
 * @author qinc 2020/10/22 16:54
 */
public class LowestAncestor {

    public static class Info {
        boolean isFind;
        TreeNode head;
        TreeNode node;

        public Info(boolean isFind, TreeNode head, TreeNode node) {
            this.isFind = isFind;
            this.head = head;
            this.node = node;
        }
    }

    public static TreeNode findAncestor(TreeNode head, TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        if (node1 == node2) {
            return node1;
        }
        return process(head, node1, node2).head;
    }

    public static Info process(TreeNode head, TreeNode node1, TreeNode node2) {
        if (head == null) {
            return new Info(false, null, null);
        }

        Info left = process(head.getLeft(), node1, node2);
        Info right = process(head.getRight(), node1, node2);

        boolean isFind = left.isFind || right.isFind;
        if (isFind) {
            return left.isFind ? left : right;
        } else {
            if (node1 == head || node2 == head) {
                if (left.node != null || right.node != null) {
                    return new Info(true, head, null);
                } else {
                    return new Info(false, null, head);
                }
            } else {
                if (left.node != null && right.node != null) {
                    return new Info(true, head, null);
                } else {
                    return new Info(false, null, left.node == null ? right.node : left.node);
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = CheckBinaryTreeUtil.createTreeNode(maxLevel, maxValue);
            TreeNode o1 = pickRandomOne(head);
            TreeNode o2 = pickRandomOne(head);
            if (lowestAncestor1(head, o1, o2) != findAncestor(head, o1, o2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static TreeNode lowestAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return null;
        }
        // key的父节点是value
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
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
        return cur;
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

    public static TreeNode pickRandomOne(TreeNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    public static void fillPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }
}
