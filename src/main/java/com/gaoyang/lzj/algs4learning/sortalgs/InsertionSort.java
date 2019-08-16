package com.gaoyang.lzj.algs4learning.sortalgs;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

import static com.gaoyang.lzj.algs4learning.common.SortUtil.sortCompareDouble;

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
            for (; j > 0 && less(temp, comparables[j - 1]); j--) {
                comparables[j] = comparables[j - 1];
            }
            comparables[j] = temp;
        }
    }

    /**
     * 插入排序，对数组部分排序
     *
     * @param comparables 待排序数组
     * @param left        左边界
     * @param right       右边界
     */
    public static void staticSort(Comparable[] comparables, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Comparable temp = comparables[i];
            int j = i;
            for (; j > left && less(temp, comparables[j - 1]); j--) {
                comparables[j] = comparables[j - 1];
            }
            comparables[j] = temp;
        }
    }

    public static void main(String[] args) {
        sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new InsertionSort());
    }

    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            Comparable temp = arr[i];
            int j = i;
            for(; j>0 && less(temp, arr[j-1]);j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

//        int len = arr.length;
//        for(int i = 1 ; i<len;i++){
//            Comparable pointer = arr[i];
//            int j = i;
//            for(; j>0&&less(pointer, arr[j-1]); j--){
//                arr[j] = arr[j-1];
//            }
//            arr[j] = pointer;
//        }

//    @Override
//    public void sort(Comparable[] arr) {
//        int len = arr.length;
//        for(int i = 1;i<len;i++){
//            Comparable temp = arr[i];
//            int j = i-1;
//            for(; j>=0 && SortUtil.less(temp, arr[j]);j--){
//                arr[j+1] = arr[j];
//            }
//            arr[j+1] = temp;
//        }
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        for(int i = 1; i < arrLen; i++){
//            Comparable temp = arr[i];
//            int j = i;
//            for(; j > 0 && SortUtil.less(temp, arr[j-1]) ; j--){
//                    arr[j] = arr[j-1];
//            }
//            arr[j] = temp;
//        }
//        long end = System.currentTimeMillis();
//        return end - start;
//    }

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

//    /**
//     * 低效算法，需要3个for循环
//     * @param arr 待排序的数组
//     */
//    @Override
//    public void sort(Comparable[] arr) {
//        int arrLen = arr.length;
//        for (int i = 1; i < arrLen; i++) {
//            Comparable temp = arr[i];
//            for (int j = 0; j < i; j++) {
//                if (SortUtil.arrLess(arr, i, j)) {
//                    int point = j;
//                    for (int k = i; k > j; k--) {
//                        arr[k] = arr[k-1];
//                    }
//                    arr[point] = temp;
//                }
//            }
//        }
//    }
}
