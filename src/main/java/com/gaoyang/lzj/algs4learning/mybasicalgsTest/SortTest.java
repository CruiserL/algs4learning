package com.gaoyang.lzj.algs4learning.mybasicalgsTest;

import com.alibaba.fastjson.JSON;
import com.gaoyang.lzj.algs4learning.sortalgs.InsertionSort;
import com.gaoyang.lzj.algs4learning.sortalgs.MergeSort;
import com.gaoyang.lzj.algs4learning.sortalgs.QuickSort;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Desc: 测试comparable接口
 *
 * @author Cruiser_L
 * @date 2019/5/14
 */
public class SortTest {

    public static void main(String[] args) {
//        In in = new In("H:\\algs4-data\\tinyUF.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(new Date());
        int arrLen = 1000;

        Double[] linksArr = new Double[arrLen];
        for (int i = 0; i < arrLen; i++) {
            linksArr[i] = (double) arrLen - i;
        }
        StdRandom.shuffle(linksArr);
        System.out.println("排序前数组：");
        System.out.println(JSON.toJSONString(linksArr));
        new QuickSort().sort(linksArr);
//        InsertionSort.staticSort(linksArr, 0, arrLen-1);
        System.out.println("数组排序完成：");
        System.out.println(JSON.toJSONString(linksArr));
        for (int i = 0; i < arrLen - 1; i++) {
            if (linksArr[i] > linksArr[i + 1]) {
                System.out.println("算法排序出错");
                break;
            }
        }
        System.out.println(stopwatch.elapsedTime());
        System.out.println(new Date());
    }

}
//        int n = in.readInt();
//        System.out.println(n);
//        ArrayList<Link> links = new ArrayList<>();
//        while (!in.isEmpty()) {
//            int p = in.readInt();
//            int q = in.readInt();
//            Link link;
//            if (p > q) {
//                link = new Link(q, p);
//            }else{
//                link = new Link(p, q);
//            }
//            links.add(link);
//        }
//        System.out.println(links);
//        Link[] linksArr = (Link[])links.toArray(new Link[links.size()]);
