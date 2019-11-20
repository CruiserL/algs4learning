package com.gaoyang.lzj.algs4learning.leetcode;

class MyLinkedList1 {
//    private Node head;
//    private int len = 0;
//
//    /** Initialize your data structure here. */
//    public MyLinkedList() {
//        head = new Node(0);
//    }
//
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//        if(index<0||index>=len){
//            return -1;
//        }
//
//        Node temp = head;
//        int i = 0;
//        while(i<=index){
//            temp = temp.next;
//            i++;
//        }
//        // 此时i=index+1,但是temp为第index个元素
//        return temp.val;
//    }
//
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//        Node temp = head.next;
//        Node newNode = new Node(val);
//        newNode.next = temp;
//        head.next = newNode;
//        len++;
//    }
//
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//        Node newNode = new Node(val);
//        Node temp = head;
//
//        while(temp.next!=null){
//            temp = temp.next;
//        }
//        temp.next = newNode;
//        len++;
//    }
//
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//        if(index>len){
//            return;
//        }
//        if(index<0){
//            addAtIndex(0, val);
//        }
//        Node newNode = new Node(val);
//        Node temp = head;
//        int i = 0;
//        while(i<index){
//            temp = temp.next;
//            i++;
//        }
//        // 此时temp为第index-1个元素
//        newNode.next = temp.next;
//        temp.next = newNode;
//        len++;
//    }
//
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        if(index<0||index>=len){
//            return;
//        }
//        Node temp = head;
//        int i = 0;
//        while(i<index){
//            temp = temp.next;
//            i++;
//        }
//        // 此时temp为第index-1个元素
//        temp.next = temp.next.next;
//        len--;
//    }

    private Node head;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList1() {
        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        return indexthNode(index).val;

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

        Node prev = indexthNode(index-1);
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
        Node prev = indexthNode(index-1);
        prev.next = prev.next.next;
        size--;
    }


    public Node indexthNode(int index){
        if(index == -1){
            return head;
        }
        int i = 0;
        Node temp = head;
        while(i<index){
            temp = temp.next;
            i++;
        }
        return temp.next;
    }



    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", len=" + size +
                '}';
    }
}