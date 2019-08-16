package com.gaoyang.lzj.algs4learning.sortalgs.betterheapsort;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

import static com.gaoyang.lzj.algs4learning.common.SortUtil.*;

/**
 * Desc: 优化版堆排序
 *
 * @author Cruiser_L
 * @date 2019/6/27
 */
public class BetterHeapSort implements SortAlgo {

    public static void main(String[] args) {
        sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new BetterHeapSort());
    }

    @Override
    public void sort(Comparable[] arr) {

    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        for (int k = (arrLen - 2) / 2; k >= 0; k--) {
//            sink(arr, k, arrLen);
//        }
//        while (arrLen > 1) {
//            exchange(0, arrLen-- - 1, arr);
//            sink(arr, 0, arrLen);
//        }
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void sink(Comparable[] arr, int k, int arrLen) {
//        while (2 * k + 2 <= arrLen) {
//            int j = 2 * k + 1;
//            if (j < arrLen - 1 && arrLess(arr, j, j + 1)) {
//                j++;
//            }
//            if (!arrLess(arr, k, j)) {
//                break;
//            }
//            exchange(k, j, arr);
//            k = j;
//        }
//    }

    //    @Override
//    public long sort(Comparable[] arr) {
//        long end = System.currentTimeMillis();
//        int arrLen = arr.length;
//        for (int k = arrLen / 2; k >= 1; k--) {
//            sink(arr, k, arrLen);
//        }
//        while (arrLen > 1) {
//            exchange(0, arrLen-- - 1, arr);
//            sink(arr, 1, arrLen);
//        }
//        long start = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void sink(Comparable[] arr, int k, int arrLen) {
//        while (2 * k <= arrLen) {
//            int j = 2 * k;
//            if (j < arrLen && arrLess(arr, j - 1, j)) {
//                j++;
//            }
//            if (!arrLess(arr, k - 1, j - 1)) {
//                break;
//            }
//            exchange(k - 1, j - 1, arr);
//            k = j;
//        }
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        for (int k = (arrLen - 1) / 2; k >= 0; k--) {
//            sink(arr, k, arrLen);
//        }
//        while (arrLen > 0) {
//            SortUtil.exchange(0, arrLen-- - 1, arr);
//            sink(arr, 0, arrLen);
//        }
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void sink(Comparable[] arr, int k, int arrLen) {
//        while (2 * k + 1 < arrLen) {
//            int j = 2 * k + 1;
//            // 关注这里的边界为什么必须是j<arrLen-1
//            // 最边界情况，j = 1，arrlen = 2
//            if (j<arrLen-1 && SortUtil.arrLess(arr, j, j + 1)) {
//                j++;
//            }
//            if (!SortUtil.arrLess(arr, k, j)) {
//                break;
//            }
//            SortUtil.exchange(k, j, arr);
//            k = j;
//        }
//    }


}
