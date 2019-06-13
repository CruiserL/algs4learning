package com.gaoyang.lzj.algs4learning.sortalgs.betterMergeSort;

import com.gaoyang.lzj.algs4learning.common.Algs4Consts;
import com.gaoyang.lzj.algs4learning.common.SortUtil;
import com.gaoyang.lzj.algs4learning.common.SortAlgoCompare;
import com.gaoyang.lzj.algs4learning.sortalgs.InsertionSort;
import com.gaoyang.lzj.algs4learning.sortinterface.SortAlgo;

/**
 * Desc: 归并排序
 *
 * @author Cruiser_L
 * @date 2019/5/18
 */
public class Better14MergeSort implements SortAlgo {
    @Override
    public long sort(Comparable[] arr) {
        long start = System.currentTimeMillis();
        int arrLen = arr.length;
        Comparable[] tempArr = new Comparable[arrLen];
        System.arraycopy(arr, 0, tempArr, 0, arrLen);
        int left = 0, right = arrLen - 1, mid = (left + right) / 2;
        mergeSort(arr, tempArr, left, right);

        long end = System.currentTimeMillis();
        return end - start;

    }

    public static void mergeSort(Comparable[] arr, Comparable[] tempArr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        if (right - left < 14) {
            InsertionSort.staticSort(arr, left, right);
        } else {
            mergeSort(arr, tempArr, left, mid);
            mergeSort(arr, tempArr, mid + 1, right);
            merge(arr, tempArr, left, right, mid);
        }

    }

    public static void merge(Comparable[] arr, Comparable[] tempArr, int left, int right, int mid) {

        int i = left, j = mid + 1, k = left;
        if (!SortUtil.arrLess(arr, mid, mid + 1)) {
            System.arraycopy(arr, left, tempArr, left, right - left + 1);
            while (i <= mid && j <= right) {
                if (SortUtil.arrLess(tempArr, i, j)) {
                    arr[k++] = tempArr[i++];
                } else {
                    arr[k++] = tempArr[j++];
                }
            }
            while (i <= mid) {
                arr[k++] = tempArr[i++];
            }

            while (j <= right) {
                arr[k++] = tempArr[j++];
            }
        }
    }

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

        sortCompareDouble(Algs4Consts.times, Algs4Consts.minLen, Algs4Consts.maxLen, Algs4Consts.maxDur, new Better14MergeSort());
    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        Comparable[] tempArr = new Comparable[arrLen];
//        System.arraycopy(arr, 0, tempArr, 0, arrLen);
//        int left = 0;
//        int right = arrLen - 1;
//        mergeSort(arr, tempArr, left, right);
//
//
//        long end = System.currentTimeMillis();
//        return end - start;
//
//    }
//
//    private void mergeSort(Comparable[] arr, Comparable[] tempArr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (left + right) / 2;
//        mergeSort(arr, tempArr, left, mid);
//        mergeSort(arr, tempArr, mid + 1, right);
//        merge(arr, tempArr, left, mid, right);
//    }
//
//    public static void merge(Comparable[] arr, Comparable[] tempArr, int left, int mid, int right) {
//        System.arraycopy(arr, left, tempArr, left, right - left + 1);
//
//        int i = left;
//        int j = mid + 1;
//        int k = left;
//
//        while (i <= mid && j <= right) {
//            if (SortUtil.less(tempArr[i], tempArr[j])) {
//                arr[k++] = tempArr[i++];
//            } else {
//                arr[k++] = tempArr[j++];
//            }
//        }
//
//        while (i <= mid) {
//            arr[k++] = tempArr[i++];
//        }
//
//        while (j <= right) {
//            arr[k++] = tempArr[j++];
//        }
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        Comparable[] tempArr = new Comparable[arrLen];
//        for(int i = 0;i < arrLen;i++){
//            tempArr[i] = arr[i];
//        }
//
//        int left = 0, right = arrLen - 1, mid = (arrLen - 1)/2;
//        mergesort(arr, tempArr, left, right);
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void mergesort(Comparable[] arr, Comparable[] tempArr, int left, int right){
//        if(left >= right){
//            return;
//        }
//        int mid = (left + right)/2;
//        mergesort(arr, tempArr, left, mid);
//        mergesort(arr, tempArr, mid+1, right);
//        merge(arr, tempArr, left, right, mid);
//    }
//
//    private void merge(Comparable[] arr, Comparable[] tempArr, int left, int right, int mid){
//        for(int i = left; i <= right; i++){
//            tempArr[i] = arr[i];
//        }
//        int i = left, j = mid+1, k= left;
//
//        while(i < mid+1 && j < right + 1){
//            if(SortUtil.less(tempArr[i], tempArr[j])){
//                arr[k++] = tempArr[i++];
//            }
//            else{
//                arr[k++] = tempArr[j++];
//            }
//        }
//
//        while(i < mid+1){
//            arr[k++] = tempArr[i++];
//        }
//
//        while(j < right + 1){
//            arr[k++] = tempArr[j++];
//        }
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int arrLen = arr.length;
//        int left = 0, right = arrLen - 1;
//        Comparable[] tempArr = new Comparable[arrLen];
//        System.arraycopy(arr, 0, tempArr, 0, arrLen);
//        mergeSort(arr, tempArr, left, right);
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//
//    public void mergeSort(Comparable[] arr, Comparable[] tempArr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (left + right) / 2;
//        mergeSort(arr, tempArr, left, mid);
//        mergeSort(arr, tempArr, mid + 1, right);
//        merge(arr, tempArr, left, mid, right);
//    }
//
//    public void merge(Comparable[] arr, Comparable[] tempArr, int left, int mid, int right) {
//        System.arraycopy(arr, left, tempArr, left, right - left + 1);
//
//        int i = left, j = mid+1, k=left;
//
//        while(i <= mid && j <= right){
//            if(SortUtil.less(tempArr[i],tempArr[j])){
//                arr[k] = tempArr[i++];
//            }
//            else{
//                arr[k] = tempArr[j++];
//            }
//            k++;
//        }
//
//        while(i <= mid ){
//            arr[k++] = tempArr[i++];
//        }
//
//        while(j <= mid ){
//            arr[k++] = tempArr[j++];
//        }
//
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        int left = 0;
//        int arrLen = arr.length;
//        int right = arrLen - 1;
//        Comparable[] tempArr = new Comparable[arrLen];
//        for (int i = 0; i < arrLen; i++) {
//            arr[i] = Math.random();
//        }
//        mergeSort(arr, tempArr, left, right);
//
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void mergeSort(Comparable[] arr, Comparable[] tempArr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (left + right) / 2;
//        mergeSort(arr, tempArr, left, mid);
//        mergeSort(arr, tempArr, mid + 1, right);
//        merge(arr, tempArr, left, mid, right);
//    }
//
//
//    private void merge(Comparable[] arr, Comparable[] tempArr, int left, int mid, int right) {
//
//        for (int left1 = left; left1 <= right; left1++) {
//            tempArr[left1] = arr[left1];
//        }
//
////        mid = (left+right)/2;
//
//        int i = left, j = mid + 1, k = left;
//        for (; i <= mid && j <= right; k++) {
//            if(SortUtil.less(tempArr[i], tempArr[j])){
//                arr[k] = tempArr[i++];
//            }
//            else {
//                arr[k] = tempArr[j++];
//            }
//        }
//
//        while(i <= mid){
//            arr[k++] = tempArr[i++];
//        }
//
//        while(j <= right){
//            arr[k++] = tempArr[j++];
//        }
//    }


//    @Override
//    public long sort(Comparable[] arr) {
//        long start = System.currentTimeMillis();
//        Comparable[] tempArr = new Comparable[arr.length];
//        int left = 0;
//        int right = arr.length - 1;
//        for (int i = left; i <= right; i++) {
//            tempArr[i] = arr[i];
//        }
////        int mid = (left + right)/2;
////        mergesort(tempArr, 0, mid);
////        mergesort(tempArr, mid+1, right);
////        merge(arr, tempArr, left, mid, right);
//        mergeSort(arr, tempArr, left, right);
////        System.out.println(JSON.toJSONString(arr));
//        long end = System.currentTimeMillis();
//        return end - start;
//    }
//
//    private void mergeSort(Comparable arr[], Comparable[] tempArr, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = (left + right) / 2;
//        mergeSort(arr, tempArr, left, mid);
//        mergeSort(arr, tempArr, mid + 1, right);
//        merge(arr, tempArr, left, mid, right);
//    }
//
//    private void merge(Comparable[] arr, Comparable[] tempArr, int left, int mid, int right) {
//        int mergeStart = left;
//        int i = left, j = mid + 1;
//
//        for (int k = left; k <= right; k++) {
//            tempArr[k] = arr[k];
//        }
//        while (i < mid + 1 && j < right + 1) {
//            if (SortUtil.less(tempArr[i], tempArr[j])) {
//                arr[mergeStart++] = tempArr[i++];
//            } else {
//                arr[mergeStart++] = tempArr[j++];
//            }
//        }
//        while (i < mid + 1) {
//            arr[mergeStart++] = tempArr[i++];
//        }
//        while (j < right + 1) {
//            arr[mergeStart++] = tempArr[j++];
//        }
//
////        for(; mergeStart < right+1; mergeStart++){
////            if(i>mid){
////                arr[mergeStart] = tempArr[j++];
////            }
////            else if(j>right){
////                arr[mergeStart] = tempArr[i++];
////            }
////            else if(SortUtil.less(tempArr[i], tempArr[j])){
////                arr[mergeStart] = tempArr[i++];
////            }
////            else {
////                arr[mergeStart] = tempArr[j++];
////            }
////        }
//
//
//    }
}
