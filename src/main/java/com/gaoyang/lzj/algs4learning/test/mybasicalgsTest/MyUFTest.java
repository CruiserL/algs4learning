package com.gaoyang.lzj.algs4learning.test.mybasicalgsTest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Desc: 加权UF算法复习
 *
 * @author Cruiser_L
 * @date 2019/5/12
 */
public class MyUFTest {

    public int[] arr;

    public int[] size;

    public int count;

    public MyUFTest(int n) {
        arr = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public int find(int x) {
        int temp = x;
        while (x != arr[x]) {
            x = arr[x];
        }
        arr[temp] = x;
        return x;
    }

    public boolean connected(int p, int q) {
        if (find(p) == find(q)) {
            return true;
        }
        return false;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ){
            return;
        }

        else if(size[rootP] > size[rootQ]){
            arr[rootQ] = rootP;
            size[rootP] += size[rootQ];
            count--;
        }
        else {
            arr[rootP] = rootQ;
            size[rootQ] += size[rootP];
            count--;
        }

    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        In in = new In("H:\\algs4-data\\tinyUF.txt");
        int n = in.readInt();
        System.out.println(n);
        MyUFTest myUFTest = new MyUFTest(n);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (myUFTest.connected(p, q)) {
                continue;
            } else {
                myUFTest.union(p, q);
            }
        }
        System.out.println(myUFTest.count + " components found.");
        System.out.println("耗时：" + stopwatch.elapsedTime() + " s");
    }
}
