package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 11:01
 */
public class CheckLinkedList {

    public static Node<Integer> createSingleList(int size, int maxValue) {
        Node<Integer> head = new Node<>(Double.valueOf(Math.random() * (maxValue + 1)).intValue());
        Node pre = head;
        for (int i = 1; i < size; i++) {
            int value = Double.valueOf(Math.random() * (maxValue + 1)).intValue();
            Node current = new Node(value);
            pre.setNext(current);
            pre = current;
        }
        return head;
    }

    public static DoubleNode<Integer> createDoubleList(int size, int maxValue) {
        DoubleNode<Integer> head = new DoubleNode<>(Double.valueOf(Math.random() * (maxValue + 1)).intValue());
        DoubleNode pre = head;
        for (int i = 1; i < size; i++) {
            int value = Double.valueOf(Math.random() * (maxValue + 1)).intValue();
            DoubleNode current = new DoubleNode(value);
            pre.setNext(current);
            current.setPre(pre);
            pre = current;
        }
        return head;
    }

    public static Node createNode(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node node = head;
        for (int i = 1; i < arr.length; i++) {
            node.setNext(new Node(arr[i]));
            node = node.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = createSingleList(5, 100);

        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }
}
