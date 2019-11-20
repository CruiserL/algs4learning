package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

import com.gaoyang.lzj.algs4learning.common.Node;

/**
 * Desc: 实现链表逆序
 *
 * @author Cruiser_L
 * @date 2019/10/21
 */
public class ReverseList {


    public static void main(String[] args) {
        Node list = null;
        Node last = null;

        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            if (list == null) {
                list = node;

            } else {
                last.setNextNode(node);
            }
            last = node;
        }
        System.out.println("原始链表");
        printList(list);

        Node reverseList = reverse(list);

        System.out.println("逆序链表");
        printList(reverseList);

    }

    public static void printList(Node list){
        Node p = list;
        while (p != null) {
            System.out.println(p.getComparable());
            p = p.getNextNode();
        }
    }


    public static Node reverse(Node list) {
        Node p;
        Node q;
        Node r;
        p = list;
        q = null;
        while (p != null) {
            r = q;
            q = p;
            p = p.getNextNode();
            q.setNextNode(r);
        }
        return q;
    }
}
