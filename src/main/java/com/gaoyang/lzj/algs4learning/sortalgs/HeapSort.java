package com.gaoyang.lzj.algs4learning.sortalgs;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

import static com.gaoyang.lzj.algs4learning.common.SortUtil.sortCompareDouble;

/**
 * Desc: 堆排序
 *
 * @author Cruiser_L
 * @date 2019/6/27
 */
public class HeapSort implements SortAlgo {



    private void sink(Comparable[] arr, int k, int arrLen) {
        while (2 * k <= arrLen) {
            int j = 2 * k;
            if (j < arrLen && SortUtil.arrLess(arr, j - 1, j)) {
                j++;
            }
            if (!SortUtil.arrLess(arr, k - 1, j - 1)) {
                break;
            }
            SortUtil.exchange(k - 1, j - 1, arr);
            k = j;
        }
    }

    public static void main(String[] args) {

        sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new HeapSort());
    }

    @Override
    public void sort(Comparable[] arr) {

    }

    //    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        for (int k = arrLen / 2; k > 0; k--) {
//            sink(arr, k, arrLen);
//        }
//
//        while (arrLen > 1) {
//            SortUtil.exchange(0, arrLen-- - 1, arr);
//            sink(arr, 1, arrLen);
//        }
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
}
