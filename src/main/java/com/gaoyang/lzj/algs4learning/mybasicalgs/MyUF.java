package com.gaoyang.lzj.algs4learning.mybasicalgs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: MyUF问题算法
 *
 * @author Cruiser_L
 * @date 2019/5/8
 */
public class MyUF {
    /**
     * 存储所有数字的list
     */
    public List<Integer> intList;

    /**
     * 每一个连通分量使用一个list
     */
    public List<List> listList;

    /**
     * 连通分量个数
     */
    public int count;

    public MyUF(int n) {
        intList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intList.add(i);
        }
        listList = new ArrayList<>();
        count = n;
    }

//    public Boolean connected(int p, int q) {
//
//    }

    public void union(int p, int q){
        // x为p所在的list下标, y为q所在的list下标
        int x = -1;
        int y = -1;
        for (List list : listList) {
            if (list.contains(p)) {
                x = listList.indexOf(list);
            }
            if (list.contains(q)) {
                y = listList.indexOf(list);
            }

        }
        // 如果当前的listList中p和q都没有找到，则返回null;
        if (x == -1 && y == -1) {
            List<Integer> list = new ArrayList<>();
            list.add(p);
            list.add(q);
            listList.add(list);
            count--;
        }
        if(x != y){
            if(y == -1){
                listList.get(x).add(q);
            }
            else if(x == -1){
                listList.get(y).add(p);
            }
            else {
                listList.get(x).addAll(listList.get(y));
                listList.remove(listList.get(y));
            }
            count--;
        }
    }

    /**
     * 此算法效率比算法书上的quickfind基本版算法更低。
     * @param args
     */
    public static void main(String[] args) {
        In in = new In("H:\\algs4-data\\largeUF.txt");
        Stopwatch stopwatch = new Stopwatch();
        int n = in.readInt();
        System.out.println(n);
        MyUF myUF = new MyUF(n);
        int i = 0;
        while (!in.isEmpty()){
            System.out.println(i);
            i++;
            int p = in.readInt();
            int q = in.readInt();
            myUF.union(p, q);
//            System.out.println(p + " " + q);
        }
        System.out.println("连通分量个数：" + myUF.count);
//        for(List list: myUF.listList){
//            System.out.println(list);
//        }
//        StdOut.println(uf.count + " components");
        System.out.println(stopwatch.elapsedTime());
    }
}
