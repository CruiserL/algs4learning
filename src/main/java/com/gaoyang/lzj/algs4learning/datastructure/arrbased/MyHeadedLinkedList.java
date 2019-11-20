package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

import com.gaoyang.lzj.algs4learning.common.Node;

/**
 * Desc: 带头结点的有序linkedList
 *
 * @author Cruiser_L
 * @date 2019/9/6
 */
public class MyHeadedLinkedList {
    private Node head;

    private MyHeadedLinkedList() {
        head = new Node(Integer.MIN_VALUE);
        head.setNextNode(null);
    }

    public Node offer() {
        if(head.getNextNode() == null){
            return null;
        }
        Node temp = head.getNextNode();
        head.setNextNode(temp.getNextNode());
        return temp;
    }

    public void add(Comparable comparable) {
        Node node = new Node(comparable);
        Node current = head;

        while (current.getNextNode() != null && node.getComparable().compareTo(current.getNextNode().getComparable()) > 0) {
//            previous = current;
            current = current.getNextNode();
        }
        // 此时有两种情况
        // 1. current已经是末尾节点
        // 2. node节点值小于current下一个节点值
        if (current.getNextNode() == null) {
            current.setNextNode(node);
        } else {
            Node temp = current.getNextNode();
            current.setNextNode(node);
            node.setNextNode(temp);
        }
    }

    @Override
    public String toString() {
        return "MyHeadedLinkedList{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args) {

        MyHeadedLinkedList myLinkedList = new MyHeadedLinkedList();
//        myLinkedList.add(100);
//        myLinkedList.add(10);
//        myLinkedList.add(1000);
//        myLinkedList.add(10000);
//        myLinkedList.add(-10);
//        myLinkedList.add(-1000);
//        myLinkedList.add(-100);
//        myLinkedList.add(-10000);
//        myLinkedList.add(0);
//        myLinkedList.add(100000);
//        myLinkedList.add(-100000);
//        myLinkedList.add(1000000);

        for (int i = 0; i < 1000; i++) {
            myLinkedList.add((int)(Math.random()*1000));
        }
        
//        while (myLinkedList.head.getNextNode() != null) {
//            System.out.println(myLinkedList.offer().getComparable());
//        }
        while(true){
            Node temp = myLinkedList.offer();
            if(temp != null){
                System.out.println(temp);
                continue;
            }
            break;
        }


    }
}


