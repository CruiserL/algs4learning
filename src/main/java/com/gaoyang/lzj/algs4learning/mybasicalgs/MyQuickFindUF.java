package com.gaoyang.lzj.algs4learning.mybasicalgs;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: 连通分量数目计算算法
 *
 * @author Cruiser_L
 * @date 2019/5/8
 */
public class MyQuickFindUF {
    public int[] arr;
    public int count;
    /**
     * 所有连接
     */
    public List<int[]> connectionList;

    public MyQuickFindUF(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        this.count = n;
    }

    public MyQuickFindUF(String fileName) {
        In in = new In(fileName);
        int n = in.readInt();
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        this.count = n;
        connectionList = new ArrayList<>();
        System.out.println(n);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if(p > q){
                int temp = p;
                p = q;
                q = temp;
            }
            int[] link = {p, q};
            connectionList.add(link);
        }
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    public int find(int p) {
        return arr[p];
    }

    public void union(int p, int q) {
            int temp = arr[p];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == temp) {
                arr[i] = arr[q];
            }
        }
        count--;
    }

    /**
     * largeUF.txt 6 components
     * 939.258
     * @param args
     */
//    public static void main(String[] args) {
//        In in = new In("H:\\algs4-data\\largeUF.txt");
//        Stopwatch stopwatch = new Stopwatch();
//        int n = in.readInt();
//        System.out.println(n);
//        MyQuickFindUF uf = new MyQuickFindUF(n);
//        int i = 0;
//        while (!in.isEmpty()) {
//            i++;
//            if(i % 10000 == 0){
//                System.out.println("当前已处理 " + i/10000 + " 万数据，处理时间：" + stopwatch.elapsedTime());
//            }
//            int p = in.readInt();
//            int q = in.readInt();
//            if (uf.connected(p, q)) continue;
//            uf.union(p, q);
////            StdOut.println(p + " " + q);
//        }
//        System.out.println(Arrays.toString(uf.arr));
//        StdOut.println(uf.count + " components");
//        System.out.println(stopwatch.elapsedTime());
//    }
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        MyQuickFindUF myQuickFindUF = new MyQuickFindUF("H:\\algs4-data\\largeUF.txt");
        int i = 0;
        for(int[] arr : myQuickFindUF.connectionList){
            i++;
            if(i % 10000 == 0){
                System.out.println("当前已处理 " + i/10000 + " 万数据，处理时间：" + stopwatch.elapsedTime());
            }
            int p = arr[0];
            int q = arr[1];
            if (myQuickFindUF.connected(arr[0], arr[1])) {
                continue;
            }
//            StdOut.println(p + " " + q);
            myQuickFindUF.union(p, q);
        }
    }
}
