package com.gaoyang.lzj.algs4learning.mybasicalgsTest;


import com.gaoyang.lzj.algs4learning.mybasicalgs.MyQuickFindUF;
import com.gaoyang.lzj.algs4learning.mybasicalgs.MyUF;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc:
 *
 * @author Cruiser_L
 * @date 2019/5/8
 */
public class MyQuickFindUFTest {

    public static void main(String[] args) {
        In in = new In("H:\\algs4-data\\largeUF.txt");
        Stopwatch stopwatch = new Stopwatch();
        int n = in.readInt();
        System.out.println(n);
        QuickFindUF uf = new QuickFindUF(n);
        int i = 0;
        while (!in.isEmpty()) {
            System.out.println(i);
            i++;
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
        System.out.println(stopwatch.elapsedTime());
    }
}
