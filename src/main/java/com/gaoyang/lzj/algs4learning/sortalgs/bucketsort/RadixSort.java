package com.gaoyang.lzj.algs4learning.sortalgs.bucketsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 基数排序
 *
 * @author Cruiser_L
 * @date 2019/11/9
 */
public class RadixSort {
    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        int[][] buckets = new int[10][len];
        int[] bucketLen = new int[10];

        int maxNum = nums[0];
        int maxLen = 0;
        List<Integer> sortedList = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]>maxNum){
                maxNum = nums[i];
            }
            sortedList.add(nums[i]);
        }
        maxLen = (maxNum+50000+"").length();

        int devider = 1;
        // 每次的除数
        // 开始遍历nums
        for (int m = 0; m < maxLen; m++) {
            for (Integer k : sortedList) {
                int digitLen = ((k+50000)/devider)%10;
                buckets[digitLen][bucketLen[digitLen]++] = k+50000;
            }
            sortedList.clear();
            // 依次取出每个桶中的数字；
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketLen[i]; j++) {
                    sortedList.add(buckets[i][j]-50000);
                }
            }
            devider = devider*10;
            for (int i = 0; i < 10; i++) {
                bucketLen[i]=0;
            }
        }



        return sortedList;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};

//        int[] nums = new int[100];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int)(Math.random()*10000000);
//        }
        RadixSort radixSort = new RadixSort();
        System.out.println(radixSort.sortArray(nums));
    }
}
