package com.gaoyang.lzj.algs4learning.search;

/**
 * Desc: 二分查找算法及其变体
 *
 * @author Cruiser_L
 * @date 2019/11/18
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (right == left) {
                if (nums[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }
            int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else {
                if (midNum > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
