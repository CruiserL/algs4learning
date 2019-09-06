package com.gaoyang.lzj.algs4learning.test.datastructure;

import com.gaoyang.lzj.algs4learning.datastructure.arrbased.MyQueue;

import java.util.Arrays;

/**
 * Desc: myQueueTest
 *
 * @author Cruiser_L
 * @date 2019/9/4
 */
public class QueueTest {
    public static void main(String[] args) {

        int arr[] = {6, 3, 1, 7, 5, 8, 9, 2, 4};
        int rear = arr.length;
        arr = Arrays.copyOf(arr, 100);
        MyQueue myQueue = new MyQueue(rear, arr);
        System.out.println(Arrays.toString(myQueue.getQueArr()));
        System.out.println(myQueue.getFront());
        System.out.println(myQueue.getRear());



        while(myQueue.getFront()< myQueue.getRear()){
            System.out.print(myQueue.offer());
            myQueue.add(myQueue.offer());
        }
        System.out.println();
        System.out.println(Arrays.toString(myQueue.getQueArr()));
    }
}
