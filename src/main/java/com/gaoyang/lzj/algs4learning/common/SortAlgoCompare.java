package com.gaoyang.lzj.algs4learning.common;

import com.gaoyang.lzj.algs4learning.sortalgs.*;
import com.gaoyang.lzj.algs4learning.sortalgs.betterMergeSort.Better14MergeSort;
import com.gaoyang.lzj.algs4learning.sortalgs.betterMergeSort.Better16MergeSort;
import com.gaoyang.lzj.algs4learning.sortalgs.betterMergeSort.Better30MergeSort;
import com.gaoyang.lzj.algs4learning.sortalgs.betterMergeSort.BetterMergeSort;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;
import com.gaoyang.lzj.algs4learning.sortinterface.SwitchSortAlgo;

/**
 * Desc: 比较各种排序算法
 *
 * @author Cruiser_L
 * @date 2019/5/16
 */
public class SortAlgoCompare {


    public static long sortTotalTime(int times, int length, SortAlgo sortAlgo) {
        Double[] doubles = new Double[length];
        long total = 0;
        for (int time = 0; time < times; time++) {
            for (int i = 0; i < length; i++) {
                doubles[i] = Math.random();
            }
//            System.out.println(JSON.toJSONString(doubles));
            total += sortAlgo.sort(doubles);
            for (int i = 0; i < length - 1; i++) {
                if (doubles[i] > doubles[i + 1]) {
                    System.out.println(sortAlgo.getClass() + "算法排序出错");
                    System.out.println("出错位置i：" + i);
                    break;
                }
            }
//            System.out.println(JSON.toJSONString(doubles));
        }
        System.out.printf("使用%20s算法对%10d  个数字的double数组执行%10d  次排序, 执行耗时%10d  ms",
                sortAlgo.getClass().getSimpleName(), length, times, total);
        System.out.println();
        return total;
    }

    public static long betterSortTotalTime(int times, int length, SwitchSortAlgo switchSortAlgo) {
        Double[] doubles = new Double[length];
        long total = 0;
        int switchingPoint;
        for (switchingPoint = 3; switchingPoint < 61; switchingPoint++) {
            total = 0;
            for (int time = 0; time < times; time++) {
                for (int i = 0; i < length; i++) {
                    doubles[i] = Math.random();
                }
                total += switchSortAlgo.sort(doubles, switchingPoint);
                for (int i = 0; i < length - 1; i++) {
                    if (doubles[i] > doubles[i + 1]) {
                        System.out.println(switchSortAlgo.getClass() + "算法排序出错");
                        System.out.println("出错位置i：" + i);
                        break;
                    }
                }
            }
            System.out.printf("使用%20s算法对%10d  个数字的double数组执行%10d  次排序, 执行耗时%10d  ms, switchingPoint=%3d",
                    switchSortAlgo.getClass().getSimpleName(), length, times, total, switchingPoint);
            System.out.println();
        }
        System.out.println();
//        System.out.printf("使用%20s算法对%10d  个数字的double数组执行%10d  次排序, 执行耗时%10d  ms, switchingPoint=%3d",
//                switchSortAlgo.getClass().getSimpleName(), length, times, total, switchingPoint);
//        System.out.println();
        return total;
    }


    public static void sortCompare(int times, int minLen, int maxLen, int maxDur) {
        long quickSortTime = 0;
        long bettermerge7SortTime = 0, better14mergeSortTime = 0, better16mergeSortTime = 0, better30mergeSortTime = 0, bottomUpMergeSortTime = 0, mergeSortTime = 0, shellSortTime = 0, insertionSortTime = 0, slctSortTime = 0;

        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {

            if (quickSortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", QuickSort.class.getSimpleName());
                System.out.println();
            } else {
                quickSortTime = sortTotalTime(times, arrLen, new QuickSort());
            }

            if (bettermerge7SortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", BetterMergeSort.class.getSimpleName());
                System.out.println();
            } else {
                bettermerge7SortTime = sortTotalTime(times, arrLen, new BetterMergeSort());
            }

            if (better14mergeSortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", Better14MergeSort.class.getSimpleName());
                System.out.println();
            } else {
                better14mergeSortTime = sortTotalTime(times, arrLen, new Better14MergeSort());
            }

            if (better16mergeSortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", Better16MergeSort.class.getSimpleName());
                System.out.println();
            } else {
                better16mergeSortTime = sortTotalTime(times, arrLen, new Better16MergeSort());
            }

            if (better30mergeSortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", Better30MergeSort.class.getSimpleName());
                System.out.println();
            } else {
                better30mergeSortTime = sortTotalTime(times, arrLen, new Better30MergeSort());
            }

//            if(bottomUpMergeSortTime >= maxDur){
//                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", BottomUpMergeSort.class.getSimpleName());
//                System.out.println();
//            }else{
//                bottomUpMergeSortTime = sortTotalTime(times, arrLen, new BottomUpMergeSort());
//            }

            if (mergeSortTime >= maxDur) {
                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", MergeSort.class.getSimpleName());
                System.out.println();
            } else {
                mergeSortTime = sortTotalTime(times, arrLen, new MergeSort());
            }


//            if (shellSortTime >= maxDur) {
//                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", ShellSort.class.getSimpleName());
//                System.out.println();
//            }else{
//                shellSortTime = sortTotalTime(times, arrLen, new ShellSort());
//            }
//            if (insertionSortTime >= maxDur) {
//                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", InsertionSort.class.getSimpleName());
//                System.out.println();
//            }else{
//                insertionSortTime = sortTotalTime(times, arrLen, new InsertionSort());
//            }
//            if (slctSortTime >= maxDur) {
//                System.out.printf("%24s处理更大规模的数组时间太长，不再执行更大规模的排序", SelectionSort.class.getSimpleName());
//                System.out.println();
//            }else{
//                slctSortTime = sortTotalTime(times, arrLen, new SelectionSort());
//            }
            System.out.println();
        }
        System.out.println();
    }

    public static void sortCompareDouble(int times, int minLen, int maxLen, int maxDur) {
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long bottomUpMergeSortTime = sortTotalTime(times, arrLen, new BottomUpMergeSort());
            if (bottomUpMergeSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
        System.out.println();
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long mergeSortTime = sortTotalTime(times, arrLen, new MergeSort());
            if (mergeSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
        System.out.println();
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long shellSortTime = sortTotalTime(times, arrLen, new ShellSort());
            if (shellSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
        System.out.println();
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long insertionSortTime = sortTotalTime(times, arrLen, new InsertionSort());
            if (insertionSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
        System.out.println();
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long slctSortTime = sortTotalTime(times, arrLen, new SelectionSort());
            if (slctSortTime >= maxDur) {
                System.out.println("此算法处理更大规模的数组时间太长，不再执行更大规模的排序");
                break;
            }
        }
    }


    public static void main(String[] args) {
        // 排序次数
        int times = 10;
        // 数组最大长度
        int minLen = 10000;
        // 数组最大长度
        int maxLen = 40960000;
//        int maxLen = 10;
        // 最长等待时间, 单位ms
        int maxDur = 60000;

        sortCompare(times, minLen, maxLen, maxDur);

//        sortCompareDouble(times, minLen, maxLen, maxDur);
    }
}
