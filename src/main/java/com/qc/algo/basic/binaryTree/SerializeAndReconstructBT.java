package com.qc.algo.basic.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/21 9:08
 */
public class SerializeAndReconstructBT {

    public static Queue<String> serialized(TreeNode head) {
        Queue<String> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head != null) {
                queue.add(String.valueOf(head.getValue()));
                stack.push(head.getRight());
                stack.push(head.getLeft());
            } else {
                queue.add("null");
            }
        }
        return queue;
    }

    public static TreeNode buildByQueue(Queue<String> queue){
        if (queue==null || queue.isEmpty()){
            return null;
        }
        return build(queue,null);
    }

    public static TreeNode build(Queue<String> queue,TreeNode head){
        String t = queue.poll();
        if (t.equals("null")){
            return null;
        }else{
            head = new TreeNode(Integer.valueOf(t));
        }
        head.setLeft(build(queue,head.getLeft()));
        head.setRight(build(queue,head.getRight()));
        return head;
    }

    public static void main(String[] args) {
        TreeNode head = CheckBinaryTreeUtil.createTreeNode(5,500);
        System.out.println(serialized(head));
        System.out.println(isSameValueStructure(buildByQueue(serialized(head)),head));

        System.out.println("========");
    }

    public static boolean isSameValueStructure(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.value != head2.value) {
            return false;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }
}
