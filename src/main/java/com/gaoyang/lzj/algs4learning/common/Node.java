package com.gaoyang.lzj.algs4learning.common;

/**
 * Desc: 链表节点
 *
 * @author Cruiser_L
 * @date 2019/9/6
 */
public class Node {
    private Comparable comparable;
    private Node nextNode;

    public Comparable getComparable() {
        return comparable;
    }

    public void setComparable(Comparable comparable) {
        this.comparable = comparable;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node(Comparable comparable) {
        this.comparable = comparable;
    }

    @Override
    public String toString() {
        return "Node{" +
                "comparable=" + comparable +
                '}';
    }
}