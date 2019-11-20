package com.gaoyang.lzj.algs4learning.sortalgs.bucketsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 *
 * @author Cruiser_L
 * @date 2019/11/9
 */
public class BucketSort {

    public List<Integer> sortArray(int[] nums) {
        int[] buckets = new int[100002];
        int len = nums.length;
        for(int i =0;i<len;i++){
            buckets[nums[i]+50000]++;
        }

        List<Integer> sortedList = new ArrayList<>();
        for(int i =0;i<100002;i++){
            if(buckets[i]>0){
                for(int j = 0; j<buckets[i];j++){
                    sortedList.add(i-50000);
                }
            }
        }
        return sortedList;
    }
}
