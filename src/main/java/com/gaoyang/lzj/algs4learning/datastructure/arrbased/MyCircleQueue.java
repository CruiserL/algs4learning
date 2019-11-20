package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

import java.util.Arrays;

/**
 * Desc: 我的循环队列实现
 *
 * @author Cruiser_L
 * @date 2019/10/26
 */
public class MyCircleQueue {

    public int[] circleQueue;
    int front = 0;
    int rear = 0;
    int maxSize;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircleQueue(int k) {
        maxSize = k;
        circleQueue = new int[k+1];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if(isFull()){
            System.out.println("循环队列已满");
            return false;
        }else {
            circleQueue[rear] = value;
            rear = (rear+1)%(maxSize+1);
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            front = (front+1)%(maxSize+1);
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return circleQueue[front];
//        front = (front+1)%maxSize;
//        return frontItem;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return circleQueue[(rear-1+maxSize)%maxSize];
//        rear = (rear-1+maxSize)%maxSize;
//        return rearItem;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (front+maxSize)%(maxSize+1)==rear;
    }

    public static void main(String[] args) {
        MyCircleQueue myCircleQueue = new MyCircleQueue(10);

        for (int i = 0; i < 10; i++) {
            myCircleQueue.enQueue(i);
        }
        for (int i = 0; i < 5; i++) {
            myCircleQueue.deQueue();
        }
        for (int i = 10; i <15 ; i++) {
            myCircleQueue.enQueue(i);
        }
        System.out.println(Arrays.toString(myCircleQueue.circleQueue));
    }
}
