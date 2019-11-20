package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

class MyCircularQueue {

    public int[] circleQueue;
    int front = 0;
    int rear = 0;
    int maxSize;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        maxSize = k;
        circleQueue = new int[k+1];
        for(int i = 0;i<circleQueue.length;i++){
            circleQueue[i] = 0;
        }
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
        return circleQueue[(rear+maxSize)%(maxSize+1)];
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
        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        myCircularQueue.enQueue(6);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
    }
}