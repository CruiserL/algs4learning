package com.gaoyang.lzj.algs4learning.leetcode;

/**
 * Desc: 翻转链表的部分节点 leetCode第92题
 * 注意此题中head节点为有效节点
 *
 * @author Cruiser_L
 * @date 2019/10/29
 */
public class ReverseList {

//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if(n<=1){
//            return head;
//        }
//        ListNode temp = head;
//        int i = 1;
//        while(i<m-1){
//            temp = temp.next;
//            i++;
//        }
//        // 此时temp为第m个实际节点
//        ListNode q, p = temp.next;
//        ListNode r = null;
//        while(i<n){
//            q = temp.next;
//            temp.next = q.next;
//            q.next = r;
//            r=q;
//            i++;
//        }
//        ListNode s = temp.next;
//        temp.next = r;
//        p.next = s;
//        return head;
//
//    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n<=1){
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        int i = 0;
        while(i<m-1){
            temp = temp.next;
            i++;
        }
        // 此时temp为第m个实际节点
        ListNode q=null, p = temp.next;
        ListNode r = null;
        while(i<n){
            q = temp.next;
            temp.next = q.next;
            q.next = r;
            r=q;
            i++;
        }
        if (temp.next != null) {
            ListNode s = temp.next;
            temp.next = r;
            p.next = s;
            return head;
        }
        return q;

    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode temp = dummyHead;
            int i = 0;
            while(i<m-1){
                temp = temp.next;
                i++;
            }
            ListNode r= null;
            ListNode q = null;
            ListNode p = temp.next;

            while(i<n){
                i++;
                q = temp.next;
                temp.next = q.next;
                q.next = r;
                r = q;
            }

            p.next = temp.next;
            temp.next=r;
            return dummyHead.next;

        }
    }


    public static void main(String[] args) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        for (int i = 0; i < 1; i++) {
            ListNode listNode = new ListNode(i+1);
            temp.next = listNode;
            temp = temp.next;
        }
        temp = head;
        System.out.println("原数组：");
        while (temp!=null){
            System.out.print(temp.val+ "\t");
            temp = temp.next;
        }
        System.out.println();
        ReverseList reverseList = new ReverseList();
        reverseList.reverseBetween(head, 1, 2);
        temp = head;
        System.out.println("逆转后数组：");
        while (temp!=null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }

    }
}
