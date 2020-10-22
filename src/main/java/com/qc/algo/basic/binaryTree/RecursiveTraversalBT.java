package com.qc.algo.basic.binaryTree;

/**
 * description
 *
 * @author qinc 2020/10/20 23:08
 */
public class RecursiveTraversalBT {

    public static void pre(TreeNode head){
        if (head==null){
            return;
        }
        System.out.println(head.getValue());
        pre(head.getLeft());
        pre(head.getRight());
    }

    public static void in(TreeNode head){
        if (head==null){
            return;
        }
        in(head.getLeft());
        System.out.println(head.getValue());
        in(head.getRight());
    }

    public static void pos(TreeNode head){
        if (head==null){
            return;
        }
        pos(head.getLeft());
        pos(head.getRight());
        System.out.println(head.getValue());
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

//        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
//        pos(head);
        System.out.println("========");

    }
}
