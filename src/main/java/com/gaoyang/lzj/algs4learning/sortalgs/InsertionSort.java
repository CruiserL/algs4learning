package com.gaoyang.lzj.algs4learning.sortalgs;

import com.alibaba.fastjson.JSON;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

/**
 * Desc: 插入排序实现
 *
 * @author Cruiser_L
 * @date 2019/5/15
 */
public class InsertionSort implements SortAlgo {

    public static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    public static void exch(Comparable[] comparables, int i, int j) {
        Comparable temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }
    public static void staticSort(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            Comparable temp = comparables[i];
            int j = i;
            for (; j > 0 && less(temp, comparables[j-1]); j--) {
                comparables[j] = comparables[j-1];
            }
            comparables[j] = temp;
        }
    }

    /**
     * 插入排序，对数组部分排序
     * @param comparables 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void staticSort(Comparable[] comparables, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Comparable temp = comparables[i];
            int j = i;
            for (; j > left && less(temp, comparables[j-1]); j--) {
                comparables[j] = comparables[j-1];
            }
            comparables[j] = temp;
        }
    }


    @Override
    public long sort(Comparable[] arr) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        for(int i = 1; i < arrLen; i++){
            Comparable temp = arr[i];
            int j = i;
            for(; j > 0 && SortUtil.less(temp, arr[j-1]) ; j--){
                    arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

//    @Override
//    public long sort(Comparable[] comparables) {
//        long start = System.currentTimeMillis();
//        for (int i = 1; i < comparables.length; i++) {
//            Comparable temp = comparables[i];
//            int j = i;
//            for (; j > 0 && less(temp, comparables[j-1]); j--) {
//                comparables[j] = comparables[j-1];
//            }
//            comparables[j] = temp;
//        }
//        long end = System.currentTimeMillis();
//        return end - start;
//    }


}
