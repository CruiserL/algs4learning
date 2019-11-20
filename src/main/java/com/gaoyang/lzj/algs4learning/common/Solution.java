package com.gaoyang.lzj.algs4learning.common;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)*(target-nums[left])/(nums[right]-nums[left]);
            if(nums[mid] == target){
                return mid;
            }
            else{
                if(nums[mid] < target){
                    left = mid+1;
                }
                else if(nums[mid] > target){
                    right = mid-1;
                }
            }
        }

        return -1;

    }



    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        Solution solution = new Solution();
        System.out.println(solution.search(arr, 9));
    }
    
}