package com.gaoyang.lzj.algs4learning.sortalgs;

import com.gaoyang.lzj.algs4learning.common.SortAlgoCompare;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

/**
 * Desc: 希尔排序
 *
 * @author Cruiser_L
 * @date 2019/5/16
 */
public class ShellSort implements SortAlgo {

    public static void sortCompareDouble(int times, int minLen, int maxLen, int maxDur) {
        for (int arrLen = minLen; arrLen <= maxLen; arrLen *= 2) {
            long shellSortTime = SortAlgoCompare.sortTotalTime(times, arrLen, new ShellSort());
            if (shellSortTime >= maxDur) {
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
        // 最长等待时间, 单位ms
        int maxDur = 60000;

        sortCompareDouble(times, minLen, maxLen, maxDur);
    }

    @Override
    public long sort(Comparable[] arr) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        int stepLen = 1;
        while (stepLen < arrLen) {
            stepLen = 3 * stepLen + 1;
        }
        while (stepLen > 0) {
            for (int j = stepLen; j < arrLen; j++) {
//                int i = j;
                Comparable temp = arr[j];
                int k = j;
                for (; k - stepLen >= 0 && SortUtil.less(temp, arr[k - stepLen]); k -= stepLen) {
                    arr[k] = arr[k - stepLen];
                }
                arr[k] = temp;
            }
            stepLen /= 3;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

//    long start = System.currentTimeMillis();
//    int arrLen = arr.length;
//    long end = System.currentTimeMillis();
//    return end -start;


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//
//        int stepLen = 1;
//        while (stepLen < arrLen) {
//            stepLen = 3 * stepLen + 1;
//        }
//
//        while (stepLen > 0) {
//            for (int i = stepLen; i < arrLen; i++) {
//                Comparable temp = arr[i];
//                int j = i;
//                for (; j >= stepLen && SortUtil.less(temp, arr[j - stepLen]); j -= stepLen) {
//                    arr[j] = arr[j - stepLen];
//                }
//                arr[j] = temp;
//            }
//            stepLen = stepLen / 3;
//        }
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }


//    int stepLen = 1;
//        while (stepLen < arrLen) {
//        stepLen = 3 * stepLen + 1;
//    }
//
//        while (stepLen > 0) {
//        for (int i = stepLen; i < arrLen; i++) {
//            Comparable temp = arr[i];
//            int j = i;
//            for (; j >= stepLen && SortUtil.less(temp, arr[j-stepLen]); j -= stepLen) {
//                arr[j] = arr[j - stepLen];
//            }
//            arr[j] = temp;
//        }
//        stepLen /= 3;
//    }


//    int stepLen = 1;
//        while(stepLen < arrLen){
//        stepLen = stepLen *3 +1;
//    }
//
//        while(stepLen>0){
//        for(int i = stepLen;i<arrLen;i++){
//            Comparable temp = arr[i];
//            int j = i;
//            for(;j>=stepLen&& SortUtil.less(temp, arr[j-stepLen]);j-=stepLen){
//                arr[j] = arr[j-stepLen];
//            }
//            arr[j] = temp;
//        }
//        stepLen = stepLen/3;
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        int stepLen = 1;
//        while(3*stepLen+1 < arrLen){
//            stepLen = 3*stepLen+1;
//        }
//
//        while(stepLen > 0){
//            for(int i = stepLen; i < arrLen; i++){
//                Comparable temp = arr[i];
//                int j = i;
//                for(; j >= stepLen && SortUtil.less(temp, arr[j - stepLen]);j-=stepLen){
//                    arr[j] = arr[j-stepLen];
//                }
//                arr[j] = temp;
//            }
//            stepLen = stepLen/3;
//        }
//
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }

//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        int stepLen = 1;
//
//        while(stepLen < arrLen){
//            stepLen = stepLen * 3 + 1;
//        }
//
//        while(stepLen >= 1){
//            for(int i = stepLen; i < arrLen; i++){
//                Comparable temp = arr[i];
//                int j = i;
//                for(;j >= stepLen && SortUtil.less(temp, arr[j-stepLen]); j-=stepLen){
//                    arr[j] = arr[j-stepLen];
//                }
//                arr[j] = temp;
//            }
//
//            stepLen = stepLen/3;
//        }
//
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }

//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        int stepLen = 1;
//
//        while(stepLen < arrLen){
//            stepLen = stepLen * 3+1;
//        }
//
//        while(stepLen >= 1){
//            for(int i = stepLen; i<arrLen;i++){
//                Comparable temp = arr[i];
//                int j = i;
//                for(j = i; j >=stepLen && SortUtil.less(temp, arr[j-stepLen]); j-=stepLen){
//                    arr[j] = arr[j-stepLen];
//                }
//                arr[j] = temp;
//            }
//
//            stepLen = stepLen/3;
//        }
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        // 步长
//        int steplen = 1;
//        while(steplen < arrLen/3){
//            steplen = 3*steplen + 1;
////            System.out.println(steplen);
//        }
//
//        while(steplen >= 1){
//            for(int i = steplen; i < arrLen; i++){
//                int j;
//                Comparable temp = arr[i];
//                for(j = i; j>=steplen && SortUtil.less(temp, arr[j-steplen]); j-=steplen){
//                    arr[j] = arr[j-steplen];
////                    SortUtil.exchange(j, j-steplen, arr);
//                }
//                arr[j] = temp;
////                System.out.println(JSON.toJSONString(arr));
//            }
//
//            steplen = steplen / 3;
//        }
//        long end = System.currentTimeMillis();
//        return end - start;
//    }


}
