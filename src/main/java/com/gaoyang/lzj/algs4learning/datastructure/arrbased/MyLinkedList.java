package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

import com.gaoyang.lzj.algs4learning.common.Node;

/**
 * Desc: MyLinkedList, 实现顺序插入
 *
 * @author Cruiser_L
 * @date 2019/9/6
 */
public class MyLinkedList {
    private Node head;

//    private MyLinkedList(){
//        head = new Node(0);
//        head.setNextNode(null);
//    }

    public Node offer(){
        if(head == null){
            return null;
        }else{
            Node temp = head;
            head = head.getNextNode();
            return temp;
        }
    }

    public void add(Comparable comparable){
        Node node = new Node(comparable);
        Node previous = null;
        Node current = head;

        while(current!=null && node.getComparable().compareTo(current.getComparable())>0){
            previous = current;
            current = current.getNextNode();
        }
        // 此时如果previous==null，有两种情况：
        // 1. 链表为空
        // 2. 被插入的位置在链表头部。
        if(previous == null){
            head = node;
        }else{
            previous.setNextNode(node);
        }
        node.setNextNode(current);
    }

//    public void add(Comparable comparable){
//        Node node = new Node(comparable);
//        Node previous = null;
//        Node current = head;
//        while(current != null && node.getComparable().compareTo(current.getComparable())>0){
//            previous = current;
//            current = current.getNextNode();
//        }
//
//        if(previous == null){
//            head = node;
//        }else{
//            previous.setNextNode(node);
//        }
//        node.setNextNode(current);
//
//    }
//
//    public Node offer(){
//        if(head == null){
//            return null;
//        }
//        Node first = head;
//        head = head.getNextNode();
//        return first;
//    }


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(100);
        myLinkedList.add(10);
        myLinkedList.add(1000);
        myLinkedList.add(10000);
        myLinkedList.add(-10);
        myLinkedList.add(-1000);
        myLinkedList.add(-100);
        myLinkedList.add(-10000);
        myLinkedList.add(0);
        myLinkedList.add(100000);
        myLinkedList.add(-100000);
        myLinkedList.add(1000000);
        while(myLinkedList.head != null){
            System.out.println(myLinkedList.offer().getComparable());
        }

    }
}


