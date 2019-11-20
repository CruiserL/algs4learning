package com.gaoyang.lzj.algs4learning.recursion;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 全排列
 *
 * @author Cruiser_L
 * @date 2019/11/6
 */
public class FullPermutation {

//    public void permute(int[] nums) {
//
//        int[] temp = new int[3];
//
//        for (int i = 0; i < nums.length; i++) {
//            temp[0] = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    temp[1] = nums[j];
//                    for (int k = 0; k < nums.length; k++) {
//                        if (k != i && k != j) {
//                            temp[2] = nums[k];
//                            System.out.println(JSON.toJSONString(temp));
//                        }
//                    }
//                }
//            }
//        }
//    }


    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> arr = new ArrayList<>();
    List<Integer> tag = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        permute(0, nums);
        return res;
    }

    public void permute(int j, int nums[]) {
        if(j == nums.length){
            res.add(arr);
        }
//        else{
            for (int i = 0; i < nums.length; i++) {
                if(tag.get(i) == 0){
                    arr.set(j, nums[i]);
                    tag.set(i, 1);
                    permute(j+1, nums);
                    tag.set(i, 1);
                }
            }
//        }
    }




//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4 ,5,6};
//        FullPermutation fullPermutation = new FullPermutation();
//        fullPermutation.tag = new int[6];
//        fullPermutation.arr = new int[6];
//        fullPermutation.permute(0,nums);
//    }
}
