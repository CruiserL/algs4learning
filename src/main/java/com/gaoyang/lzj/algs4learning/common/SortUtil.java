package com.gaoyang.lzj.algs4learning.common;

import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;
import com.gaoyang.lzj.algs4learning.sortinterface.SwitchSortAlgo;

/**
 * Desc: 封装各排序算法需要使用的基础方法
 *
 * @author Cruiser_L
 * @date 2019/5/16
 */
public class SortUtil {

    public static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /**
     * 比较数组ij索引值大小
     *
     * @param arr 数组
     * @param i i
     * @param j j
     * @return arr[i] < arr[j]则返回true，否则返回false
     */
    public static boolean arrLess(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    public static void exchange(int p, int q, Comparable[] arr) {
        Comparable temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static void sortCompareDouble(int times, int minLen, int maxLen, int maxDur, SortAlgo sortAlgo) {
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long sortTotalTime = SortAlgoCompare.sortTotalTime(times, arrLen, sortAlgo);
            if (sortTotalTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
    }

    public static void betterSortCompareDouble(int times, int minLen, int maxLen, int maxDur, SwitchSortAlgo switchSortAlgo) {
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long sortTotalTime = SortAlgoCompare.betterSortTotalTime(times, arrLen, switchSortAlgo);
            if (sortTotalTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
    }
}
