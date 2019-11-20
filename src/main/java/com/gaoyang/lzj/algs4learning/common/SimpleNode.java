package com.gaoyang.lzj.algs4learning.common;

/**
 * Desc: 链表简单节点
 *
 * @author Cruiser_L
 * @date 2019/10/21
 */
public class SimpleNode {
    private Comparable data;
    private SimpleNode next;

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public SimpleNode getNext() {
        return next;
    }

    public void setNext(SimpleNode next) {
        this.next = next;
    }
}
