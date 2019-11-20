package com.gaoyang.lzj.algs4learning.leetcode;

/**
 * Desc: leetcode155 最小栈
 *
 * @author Cruiser_L
 * @date 2019/10/31
 */
public class MinStack {

    NodeWithMin dummyHead;

    /** initialize your data structure here. */
    public MinStack() {
        dummyHead = new NodeWithMin(Integer.MAX_VALUE);
    }

    public void push(int x) {
        NodeWithMin cur = new NodeWithMin(x);
        if(dummyHead.next == null){
            dummyHead.next = cur;
            cur.min = x;
            return;
        }
        if(x < dummyHead.next.min){
            cur.min = x;
        }else{
            cur.min = dummyHead.next.min;
        }
        NodeWithMin temp = dummyHead.next;
        dummyHead.next = cur;
        cur.next = temp;
    }

    public void pop() {
        if(dummyHead.next == null){
            throw new RuntimeException("栈空");
        }
        dummyHead.next = dummyHead.next.next;
    }

    public int top() {
        if(dummyHead.next == null){
            throw new RuntimeException("栈空");
        }
        return dummyHead.next.val;
    }

    public int getMin() {
        return dummyHead.next.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}


class NodeWithMin{
    public int val;
    public int min;
    public NodeWithMin next;
    public NodeWithMin(int n){
        this.val = n;
    }
}
