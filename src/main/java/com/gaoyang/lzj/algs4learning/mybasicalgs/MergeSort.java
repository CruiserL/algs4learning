package com.gaoyang.lzj.algs4learning.mybasicalgs;

import java.util.Arrays;
import java.util.List;

/**
 * Desc: 网上代码
 * 
 * @author chengxiao
 * @date 2019/5/9
 */
public class MergeSort {
    public static void main(String []args){
//        int[] arr = {9,8,7,6,5,4,3,2,1};
//        staticSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public static void sort(List list){
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[][] temp = new int[list.size()][];
        sort(list,0,list.size()-1,temp);
    }
    private static void sort(List arr,int left,int right,int[][] temp){
        if(left<right){
            int mid = (left+right)/2;
            //左边归并排序，使得左子序列有序
            sort(arr,left,mid,temp);
            //右边归并排序，使得右子序列有序
            sort(arr,mid+1,right,temp);
            //将两个有序子数组合并操作
            merge(arr,left,mid,right,temp);
        }
    }
    private static void merge(List<int[]> list,int left,int mid,int right,int[][] temp){
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid+1;
        //临时数组指针
        int t = 0;
        while (i<=mid && j<=right){
            if(list.get(i)[0] <= list.get(j)[0]){
                temp[t] = list.get(i);
                t++;
                i++;
            }else {
                temp[t] = list.get(j);
                t++;
                j++;
            }
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            temp[t] = list.get(i);
            t++;
            i++;
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[t] = list.get(j);
            t++;
            j++;
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            list.set(left, temp[t]);
            left++;
            t++;
        }
    }
}