package com.gaoyang.lzj.algs4learning.sortalgs.betterquicksort;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.sortalgs.InsertionSort;
import com.gaoyang.lzj.algs4learning.sortinterface.SwitchSortAlgo;

/**
 * Desc:
 *
 * @author Cruiser_L
 * @date 2019/6/20
 */
public class QuickSort3WayAlgs4 implements SwitchSortAlgo {

    private static int switchingPoint;

    @Override
    public long sort(Comparable[] arr, int switchingPoint) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        QuickSort3WayAlgs4.switchingPoint = switchingPoint;
        sort(arr, 0, arrLen - 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private void sort(Comparable[] arr, int left, int right) {
        if (right - left < switchingPoint) {
            InsertionSort.staticSort(arr, left, right);
        } else {
            if (right <= left) {
                return;
            }
            int lt = left;
            int gt = right;
            int pointer = left + 1;
            Comparable temp = arr[left];
            while (pointer <= gt) {
                int cmpRes = arr[pointer].compareTo(temp);
                if (cmpRes < 0) {
                    SortUtil.exchange(pointer++, lt++, arr);
                } else if (cmpRes == 0) {
                    pointer++;
                } else {
                    SortUtil.exchange(pointer, gt--, arr);
                }
            }
            sort(arr, left, lt - 1);
            sort(arr, gt + 1, right);
        }
    }

    public static void main(String[] args) {
        SortUtil.betterSortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen,
                Algs4Consts.maxDur, new QuickSort3WayAlgs4());
    }
}
