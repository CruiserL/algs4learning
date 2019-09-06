package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

/**
 * Desc: myQueue
 *
 * @author Cruiser_L
 * @date 2019/9/4
 */
public class MyQueue {
    private int front;
    private int rear;
    private int[] queArr;

    public MyQueue(int rear, int[] queArr){
        this.queArr = queArr;
        this.front = 0;
        this.rear = rear;
    }

    public int offer(){
        return queArr[front++];
    }

    public void add(int elem){
        queArr[rear++] = elem;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getQueArr() {
        return queArr;
    }

    public void setQueArr(int[] queArr) {
        this.queArr = queArr;
    }
}
