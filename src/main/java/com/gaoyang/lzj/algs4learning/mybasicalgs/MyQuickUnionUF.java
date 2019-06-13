package com.gaoyang.lzj.algs4learning.mybasicalgs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.*;

/**
 * Desc: 快速UF
 *
 * @author Cruiser_L
 * @date 2019/5/8
 */
public class MyQuickUnionUF {
    /**
     * 触点
     */
    public int[] arr;
    /**
     * 所有连接
     */
    public List<int[]> connectionList;
    /**
     * 连通分量个数
     */
    public int count;

    public MyQuickUnionUF(String fileName) {
        In in = new In(fileName);
        int n = in.readInt();
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        this.count = n;
        connectionList = new ArrayList<>();
        System.out.println(n);
//        MyQuickUF myQuickUF = new MyQuickUF();
        int i = 0;
        while (!in.isEmpty()) {
//            if(i % 1000 == 0){
//                System.out.println(i);
//            }
//            i++;
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

    public int find(int p){
        while(p != arr[p]){
            p = arr[p];
        }
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ){
            return;
        }
        else{
            // 注意这里不能使用arr[p] = rootQ,这样会导致本来已经生效的连接被切断
            arr[rootP] = rootQ;
            count--;
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        MyQuickUnionUF myQuickUnionUF = new MyQuickUnionUF("H:\\algs4-data\\largeUF.txt");

//        System.out.println(JSON.toJSONString(myQuickUF.connectionList));
        // 排序
//        MergeSort.staticSort(myQuickUF.connectionList);

//        System.out.println(JSON.toJSONString(myQuickUF.connectionList));
        int i = 0;
        for(int[] arr : myQuickUnionUF.connectionList){
            i++;
            if(i % 10000 == 0){
                System.out.println("当前已处理 " + i/10000 + " 万数据，处理时间：" + stopwatch.elapsedTime());
            }
            int p = arr[0];
            int q = arr[1];
            if (myQuickUnionUF.connected(arr[0], arr[1])) {
                continue;
            }
//            StdOut.println(p + " " + q);
            myQuickUnionUF.union(p, q);
        }
        System.out.println(Arrays.toString(myQuickUnionUF.arr));
        StdOut.println(myQuickUnionUF.count + " components");
        System.out.println(stopwatch.elapsedTime());
    }
}
