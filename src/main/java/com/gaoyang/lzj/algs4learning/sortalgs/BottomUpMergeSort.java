package com.gaoyang.lzj.algs4learning.sortalgs;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.common.SortAlgoCompare;
import com.gaoyang.lzj.algs4learning.sortalgs.bettermergesort.BetterMergeSort;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

/**
 * Desc:
 *
 * @author Cruiser_L
 * @date 2019/6/6
 */
public class BottomUpMergeSort implements SortAlgo {



    public static void sortCompareDouble(int times, int minLen, int maxLen, int maxDur, SortAlgo sortAlgo) {
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long shellSortTime = SortAlgoCompare.sortTotalTime(times, arrLen, sortAlgo);
            if (shellSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
    }

    public static void main(String[] args) {

        sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new BottomUpMergeSort());
    }

    @Override
    public void sort(Comparable[] arr) {

    }

//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        Comparable[] tempArr = new Comparable[arrLen];
//
//        for (int stepLen = 1; stepLen < arrLen; stepLen *= 2) {
//            for (int j = 0; j + stepLen < arrLen; j += 2 * stepLen) {
//                BetterMergeSort.merge(arr, tempArr, j, Math.min(arrLen-1, j + 2 * stepLen-1), j + stepLen-1);
//            }
//        }
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        Comparable[] tempArr = new Comparable[arrLen];
//        for (int i = 1; i < arrLen; i += i) {
//            for (int j = 0; j + i < arrLen; j += 2 * i) {
//                BetterMergeSort.merge(arr, tempArr, j, Math.min(j + 2 * i - 1, arrLen - 1), j + i - 1);
//            }
//        }
//
//
//        long end = System.currentTimeMillis();
//        return end - start;
//
//    }

//    Comparable[] tempArr = new Comparable[arrLen];
//        System.arraycopy(arr, 0, tempArr, 0, arrLen);
//        for (int i = 1; i < arrLen; i += i) {
//        for (int j = 0; j + i < arrLen; j += i * 2) {
//            MergeSort.merge(arr, tempArr, j, Math.min(j + 2 * i - 1, arrLen - 1), j + i - 1);
//        }
//    }

//    Comparable[] tempArr = new Comparable[arrLen];
//        for (int i = 1; i < arrLen; i += i) {
//        for (int j = 0; j < arrLen - i + 1; j += 2 * i) {
//            MergeSort.merge(arr, tempArr, j, j + i - 1, Math.min(j + 2 * i - 1, arrLen - 1));
//        }
//    }


//    Comparable[] tempArr = new Comparable[arrLen];
//
//        for(int i = 1; i < arrLen; i+=i){
//        for(int j=0;j < arrLen -i; j += 2*i){
//            MergeSort.merge(arr, tempArr, j, j+i-1, Math.min(j+2*i-1, arrLen-1));
//        }
//    }


//    Comparable[] tempArr = new Comparable[arrLen];
//        System.arraycopy(arr, 0, tempArr, 0, arrLen);
//
//        for(int i = 1; i < arrLen; i+=i){
//        for(int j = 0; j < arrLen-i; j+=2*i){
//            MergeSort.merge(arr, tempArr, j, j+i-1, Math.min(j+i*2-1, arrLen-1));
//        }
//    }
}
