package com.gaoyang.lzj.algs4learning.leetcode;

import java.util.Arrays;

/**
 * Desc: leetcode 670 最大交换
 *
 * @author Cruiser_L
 * @date 2019/10/30
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        String numStr = num + "";
        int len = numStr.length();
        char[] chars = numStr.toCharArray();
        int[] last = new int[10];

        for (int i = 0; i < len; i++) {
            last[numStr.charAt(i) - '0'] = i+1;
        }

        System.out.println(Arrays.toString(last));
        for (int i = 0; i < len; i++) {
            int cur = chars[i] - '0';
            for (int j = 9; j >=0 ; j--) {
                if(cur < j && i < last[j]-1){
                    // 替换第i位和第j位的字符
                    char temp = chars[i];
                    chars[i] = chars[last[j]-1];
                    chars[last[j]-1] = temp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
//        String s = "1927864";
//        char[] chars = s.toCharArray();
//        System.out.println(chars);
//        String str = new String(chars);
//        System.out.println(chars);

        MaximumSwap maximumSwap = new MaximumSwap();
//        int target = maximumSwap.maximumSwap(1927864);
        System.out.println(maximumSwap.maximumSwap(0));
    }
}
