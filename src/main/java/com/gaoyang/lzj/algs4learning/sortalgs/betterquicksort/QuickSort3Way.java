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
public class QuickSort3Way implements SwitchSortAlgo {

    private static int switchingPoint;

    @Override
    public long sort(Comparable[] arr, int switchingPoint) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        QuickSort3Way.switchingPoint = switchingPoint;
        sort(arr, 0, arrLen - 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private void sort(Comparable[] arr, int left, int right) {
        if (right - left < switchingPoint) {
            InsertionSort.staticSort(arr, left, right);
        } else {
            int lt = left;
            int gt = right + 1;
            int equal = left + 1;
            Comparable temp = arr[lt];
            while (lt < gt) {
                while (++lt < gt) {
                    if (SortUtil.less(temp, arr[lt])) {
                        break;
                    }
                    if (arr[lt].compareTo(temp) == 0) {
                        SortUtil.exchange(lt, equal++, arr);
                    }
                }

                while (--gt >= lt) {
                    if (arr[gt].compareTo(temp) == 0) {
                        SortUtil.exchange(lt, gt, arr);
                        SortUtil.exchange(equal++, lt, arr);
                    }
                    if (SortUtil.less(arr[gt], temp)) {
                        break;
                    }

                }
                if (lt < gt) {
                    SortUtil.exchange(lt, gt, arr);

                }
            }
            for (int i = left; i < equal; i++) {
                SortUtil.exchange(gt--, i, arr);
            }
            sort(arr, left, gt);
            sort(arr, gt + equal-left+1, right);
        }
    }

    public static void main(String[] args) {
        SortUtil.betterSortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen,
                Algs4Consts.maxDur, new QuickSort3Way());
    }
}
