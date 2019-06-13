package com.gaoyang.lzj.algs4learning.sortalgs;

import com.alibaba.fastjson.JSON;
import com.gaoyang.lzj.algs4learning.mybasicalgsTest.Link;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

import java.util.List;

/**
 * Desc: 选择排序实现
 *
 * @author Cruiser_L
 * @date 2019/5/15
 */
public class SelectionSort implements SortAlgo {

    private static boolean less(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }



    private static void exch(int p, int q, List list){
        Link temp = (Link)list.get(p);
        list.set(p, list.get(q));
        list.set(q, temp);
    }

    private static void exchange(int p, int q, Comparable[] list){
        Comparable temp = list[p];
        list[p] = list[q];
        list[q] = temp;
    }

    /**
     * 排序
     */
    public static void staticSort(List list) {
        for (int i = 0; i < list.size(); i++) {
            Link linkI = (Link) list.get(i);
            int min = i;
            for (int j = i; j < list.size(); j++) {
                Link linkJ = (Link) list.get(j);
                if (less(linkJ, (Link) list.get(min))){
                    min = j;
                }
            }
            if(min != i || !less(linkI, (Link)list.get(min))){
                exch(i, min, list);
            }
            System.out.println(JSON.toJSONString(list));
        }
    }

    @Override
    public long sort(Comparable[] comparables) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < comparables.length; i++) {
            Comparable linkI = comparables[i];
            int min = i;
            for (int j = i; j < comparables.length; j++) {
                Comparable linkJ = comparables[j];
                if (less(linkJ, comparables[min])){
                    min = j;
                }
            }
            if(min != i || !less(linkI, comparables[min])){
                exchange(i, min, comparables);
            }
//            System.out.println(JSON.toJSONString(comparables));
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
