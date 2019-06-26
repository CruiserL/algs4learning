package com.gaoyang.lzj.algs4learning.sortalgs;

import com.alibaba.fastjson.JSON;
import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;
import edu.princeton.cs.algs4.QuickBentleyMcIlroy;

/**
 * Desc: 快速排序算法学习
 *
 * @author Cruiser_L
 * @date 2019/6/11
 */
public class QuickSort implements SortAlgo {

    @Override
    public long sort(Comparable[] arr) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        sort(arr, 0, arrLen-1);
        long end = System.currentTimeMillis();
        return end -start;
    }


    private void sort(Comparable[] arr, int left, int right){
        if(right - left <= 10){
            InsertionSort.staticSort(arr, left, right);
        }else{
//            if(right<=left){
//                return;
//            }
            int cuttingPoint = partition(arr, left, right);
            sort(arr, left, cuttingPoint-1);
            sort(arr, cuttingPoint+1, right);
        }
    }

    private int partition(Comparable[] arr, int left, int right){
        int i = left, j = right+1;

        while(i<j){
            while(++i<j && SortUtil.arrLess(arr, i, left)){}
            while(--j>=i && SortUtil.arrLess(arr, left, j)){}
            if(i<j){
                SortUtil.exchange(i, j, arr);
            }
        }
        SortUtil.exchange(left, j, arr);
//        System.out.println(JSON.toJSONString(arr));
        return j;
    }


    public static void main(String[] args) {

        SortUtil.sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new QuickSort());


    }



//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        sort(arr, 0, arrLen - 1);
//        long end = System.currentTimeMillis();
//        return end - start;
//
//    }
//
//    public void sort(Comparable[] arr, int left, int right) {
//        if(right - left <= 27){
//            InsertionSort.staticSort(arr, left, right);
//            return;
//        }
//        if (right <= left) {
//            return;
//        }
//        int cuttingPoint = partition(arr, left, right);
//        sort(arr, left, cuttingPoint - 1);
//        sort(arr, cuttingPoint + 1, right);
//    }
//
//    public static int partition(Comparable[] arr, int left, int right) {
//        int i = left;
//        int j = right + 1;
//        while (i < j) {
//            while (++i < j && SortUtil.arrLess(arr, i, left)) {
//            }
//            while (--j >= i && SortUtil.arrLess(arr, left, j)) {
//            }
//            if (i < j) {
//                SortUtil.exchange(i, j, arr);
//            }
//        }
//        SortUtil.exchange(j, left, arr);
//        return j;
//    }



//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        sort(arr, 0, arrLen - 1);
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    public static void sort(Comparable[] arr, int left, int right) {
//        if (left > right) {
//            return;
//        }
//
//        int cuttingPiont = partition(arr, left, right);
//        sort(arr, left, cuttingPiont - 1);
//        sort(arr, cuttingPiont + 1, right);
//    }
//
//    public static int partition(Comparable[] arr, int left, int right) {
//        int leftSentry = left, rightSentry = right + 1;
//        while (leftSentry < rightSentry) {
//            while (++leftSentry < rightSentry && SortUtil.arrLess(arr, leftSentry, left)) {
//            }
//            while (--rightSentry >= leftSentry && SortUtil.arrLess(arr, left, rightSentry)) {
//            }
//            if (leftSentry < rightSentry) {
//                SortUtil.exchange(leftSentry, rightSentry, arr);
//            }
//        }
//
//        SortUtil.exchange(rightSentry, left, arr);
//        return rightSentry;
//    }


//    private static void sort(Comparable[] arr, int left, int right) {
//        if (left > right) {
//            return;
//        }
//        if (right - left < 30) {
//            InsertionSort.staticSort(arr, left, right);
//        } else {
//            int cuttingPoint = partition(arr, left, right);
//            sort(arr, left, cuttingPoint - 1);
//            sort(arr, cuttingPoint + 1, right);
//        }
//    }
//
//    private static int partition(Comparable[] arr, int left, int right) {
//        int i = left, j = right + 1;
//        while (i < j) {
//            while (++i < j && SortUtil.arrLess(arr, i, left)) {
//            }
//            while (--j >= i && SortUtil.arrLess(arr, left, j)) {
//            }
//            if (i < j) {
//                SortUtil.exchange(i, j, arr);
//            }
//        }
//        SortUtil.exchange(j, left, arr);
//        return j;
//    }


//    private void sort(Comparable[] arr, int left, int right) {
//        if (right < left) {
//            return;
//        }
//        int cuttingPoint = partition(arr, left, right);
//        sort(arr, left, cuttingPoint - 1);
//        sort(arr, cuttingPoint + 1, right);
//    }
//
//    private int partition(Comparable[] arr, int left, int right) {
//        int i = left, j = right + 1;
//        while (i < j) {
//            while (--j >= i+1 && SortUtil.arrLess(arr, left, j)) {
//            }
//            while (++i <= j && SortUtil.arrLess(arr, i, left)) {
//            }
//            if (i < j) {
//                SortUtil.exchange(i, j, arr);
//            }
//        }
//        SortUtil.exchange(left, j, arr);
//        return j;
//    }

    //    private void sort(Comparable[] arr, int left, int right) {
//        exchTimes++;
//        System.out.println(exchTimes);
//        if (right < left) {
//            return;
//        }
//        int cuttingPoint = partition(arr, left, right);
//        sort(arr, left, cuttingPoint - 1);
//        sort(arr, cuttingPoint + 1, right);
//
//    }
//
//    private int partition(Comparable[] arr, int left, int right) {
////        exchTimes++;
//        int i = left, j = right + 1;
//        while (i < j) {
//            while (--j > i && SortUtil.arrLess(arr, left, j)) {
//
//            }
//            while (++i <= j && SortUtil.arrLess(arr, i, left)) {
//
//            }
//            if (i < j) {
//                SortUtil.exchange(i, j, arr);
//            }
//        }
//        SortUtil.exchange(left, j, arr);
//
//        return j;
//    }
}
