package com.qc.algo.basic.linkedList;

/**
 * description
 *
 * @author qinc 2020/10/12 9:20
 */
public class ReverseLinkedList {

    /**
     * 翻转单链表
     *
     * @param head
     * @return
     */
    public static Node<Integer> reverseSingleList(Node<Integer> head) {
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

    /**
     * 翻转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode<Integer> reverseDoubleList(DoubleNode<Integer> head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            head.setPre(next);
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node<Integer> head = CheckLinkedList.createSingleList(5, 100);
        Node<Integer> copy = head;
        while (head != null) {
            System.out.print(head.getValue()+",");
            head = head.getNext();
        }
        System.out.println("");

        head = reverseSingleList(copy);
        while (head != null) {
            System.out.print(head.getValue()+",");
            head = head.getNext();
        }

        System.out.println("-----------------------------------------");
        DoubleNode<Integer> doubleNode = CheckLinkedList.createDoubleList(5,100);
        DoubleNode<Integer> doubleCopy = doubleNode;
        while (doubleNode!=null){
            System.out.print(doubleNode.getValue()+",");
            doubleNode = doubleNode.getNext();
        }

        System.out.println("");

        doubleNode = reverseDoubleList(doubleCopy);
        while (doubleNode!=null){
            System.out.print(doubleNode.getValue()+",");
            doubleNode = doubleNode.getNext();
        }
    }
}
