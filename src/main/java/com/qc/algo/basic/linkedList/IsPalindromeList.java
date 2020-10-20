package com.qc.algo.basic.linkedList;

import java.util.Stack;

/**
 * description
 *
 * @author qinc 2020/10/19 16:00
 */
public class IsPalindromeList {

    public static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        Node node = head;
        Node mid = LinkedListMid.upMid(head);
        Node midHead = reverse(mid.getNext());
        Node midNode = midHead;

        boolean b = true;
        while (midNode != null) {
            if (!node.getValue().equals(midNode.getValue())) {
                b = false;
                break;
            }
            node = node.getNext();
            midNode = midNode.getNext();
        }

        midHead = reverse(midHead);
        mid.setNext(midHead);
        return b;
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public static boolean right(Node head) {
        if (head == null) {
            return false;
        }
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }

        node = head;
        while (node != null) {
            if (!node.getValue().equals(stack.pop().getValue())) {
                return false;
            }
            node = node.getNext();
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 2, 1};
        Node head = CheckLinkedList.createNode(arr);
        System.out.println(isPalindrome(head));
        System.out.println(right(head));
    }


}
