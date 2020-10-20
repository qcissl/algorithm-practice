package com.qc.algo.basic.linkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author qinc 2020/10/19 19:11
 */
public class LinkedListPartition {

    public static Node partition(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        int value = head.getValue();
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;

        while (head != null) {
            if (head.getValue().equals(value)) {
                if (eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.setNext(head);
                    et = head;
                }
            }

            if (head.getValue() < value) {
                if (sh == null) {
                    sh = head;
                    st = head;
                } else {
                    st.setNext(head);
                    st = head;
                }
            }

            if (head.getValue() > value) {
                if (bh == null) {
                    bh = head;
                    bt = head;
                } else {
                    bt.setNext(head);
                    bt = head;
                }
            }
            head = head.getNext();
        }

        head = sh;
        if (sh != null) {
            if (eh != null) {
                st.setNext(eh);
                et.setNext(bh);
            } else {
                st.setNext(bh);
            }
        } else {
            head = eh;
            if (eh != null) {
                et.setNext(bh);
            } else {
                head = bh;
            }
        }

        if (bt!=null){
            bt.setNext(null);
        }

        return head;
    }

    public static Node right(Node<Integer> head) {
        List<Node> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.getNext();
        }
        Node<Integer>[] arr = list.toArray(new Node[]{});
        arr = arrayPartition(arr);

        head = arr[0];
        Node node = head;
        for (int i = 1; i < arr.length; i++) {
            node.setNext(arr[i]);
            node = node.getNext();
        }
        node.setNext(null);
        return head;
    }

    public static Node[] arrayPartition(Node<Integer>[] arr) {
        int value = arr[arr.length - 1].getValue();
        int left = -1;
        int right = arr.length;

        int index = 0;
        while (index < right) {
            if (arr[index].getValue() < value) {
                swap(index, ++left, arr);
                index++;
            } else if (arr[index].getValue() > value) {
                swap(index, --right, arr);
            } else {
                index++;
            }
        }
        return arr;
    }

    private static void swap(int index, int left, Node<Integer>[] arr) {
        Node temp = arr[index];
        arr[index] = arr[left];
        arr[left] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{34, 54, 36, 54, 76, 8, 34};
        Node head = CheckLinkedList.createNode(arr);
        head = right(head);
        Node head2 = CheckLinkedList.createNode(arr);
        head2 = partition(head2);
        System.out.println(head2);
    }
}
