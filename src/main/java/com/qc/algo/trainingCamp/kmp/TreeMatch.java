package com.qc.algo.trainingCamp.kmp;

import com.qc.algo.basic.binaryTree.CheckBinaryTreeUtil;
import com.qc.algo.basic.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/11/19 9:51
 */
public class TreeMatch {

    public static boolean f1(TreeNode head, TreeNode match) {
        if (match == null) {
            return true;
        }
        if (head == null) {
            return false;
        }
        if (compareTreeNode(head, match)) {
            return true;
        }
        return f1(head.left, match) || f1(head.right, match);
    }

    private static boolean compareTreeNode(TreeNode head, TreeNode match) {
        if ((head == null && match != null) || (head != null && match == null)) {
            return false;
        }
        if (head == null && match == null) {
            return true;
        }
        if ((head.value != match.value)) {
            return false;
        }
        return compareTreeNode(head.right, match.right) && compareTreeNode(head.left, match.left);
    }

    public static boolean f2(TreeNode head, TreeNode match) {
        if (match == null) {
            return true;
        }
        if (head == null) {
            return false;
        }
        List<String> headList = new ArrayList<>();
        List<String> matchList = new ArrayList<>();
        serializeTreeNode(head, headList);
        serializeTreeNode(match, matchList);

        int[] next = getNext(matchList);
        int hIndex = 0;
        int mIndex = 0;
        while (hIndex < headList.size() && mIndex < matchList.size()) {
            if (headList.get(hIndex).equals(matchList.get(mIndex))) {
                hIndex++;
                mIndex++;
            } else if (mIndex > 0) {
                mIndex = next[mIndex];
            } else {
                hIndex++;
            }
        }
        return mIndex == matchList.size() ? true : false;
    }

    private static int[] getNext(List<String> matchList) {
        int[] next = new int[matchList.size()];
        if (matchList.size() > 0) {
            next[0] = -1;
        }
        if (matchList.size() > 1) {
            next[1] = 0;
        }

        int index = 2;
        int cn = 0;
        while (index < matchList.size()) {
            if (matchList.get(index - 1).equals(matchList.get(cn))) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    private static void serializeTreeNode(TreeNode head, List<String> list) {
        if (head != null) {
            list.add(String.valueOf(head.value));
            serializeTreeNode(head.left, list);
            serializeTreeNode(head.right, list);
        } else {
            list.add("null");
        }
    }

    public static void main(String[] args) {
        int bigTreeLevel = 7;
        int smallTreeLevel = 4;
        int nodeMaxValue = 5;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            TreeNode big = CheckBinaryTreeUtil.createTreeNode(bigTreeLevel, nodeMaxValue);
            TreeNode small = CheckBinaryTreeUtil.createTreeNode(smallTreeLevel, nodeMaxValue);
            boolean ans1 = f1(big, small);
            boolean ans2 = f2(big, small);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish!");

    }
}
