package com.gaoyang.lzj.algs4learning.leetcode;

class MyLinkedList {
    private Node head;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        return indexthPrevNode(index+1).val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0){
            addAtIndex(0, val);
        }
        if(index>size){
            return;
        }

        Node prev = indexthPrevNode(index);
        Node cur = new Node(val);
        cur.next = prev.next;
        prev.next = cur;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        Node prev = indexthPrevNode(index);
        prev.next = prev.next.next;
        size--;
    }


    public Node indexthPrevNode(int index){
        int i = 0;
        Node temp = head;
        while(i<index){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        MyLinkedList1 myLinkedList = new MyLinkedList1();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList);
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList);
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList);
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList);
        myLinkedList.get(1);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", len=" + size +
                '}';
    }
}

class Node{
    public int val;
    public Node next;
    
    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
