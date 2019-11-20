package com.gaoyang.lzj.algs4learning.leetcode;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: LeetCode51
 *
 * @author Cruiser_L
 * @date 2019/11/7
 */
public class LeetCode51 {

    private int[] arr;

    private int[] tag;

    private List<List<String>> res;
    /**
     * 皇后个数
     */
    private int n;

    private int count;

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51(5);
//        leetCode51.solveNQueens(5);
        leetCode51.totalNQueens(5);
//        System.out.println(leetCode51.res);
        System.out.println(leetCode51.count);

    }

    public LeetCode51(int n) {
        this.arr = new int[n];
        this.tag = new int[n];
        this.n = n;
        this.res = new ArrayList<>();
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        setQueen(0);
        return res;
    }

    public int totalNQueens(int n) {
        this.arr = new int[n];
        this.tag = new int[n];
        this.n = n;
        setQ(0);
        return count;
    }

    /**
     * set 第i个皇后
     *
     * @param i 第i个
     */
    private void setQueen(int i) {
        if (i == n) {
            add2Res(arr);
        } else {
            for (int j = 0; j < n; j++) {
                if (tag[j] == 0) {
                    arr[i] = j;
                    if (check(i)) {
                        tag[j] = 1;
                        setQueen(i + 1);
                        tag[j] = 0;
                    }
                }
            }
        }
    }

    private void setQ(int i){
        if (i == n) {
            count++;
        } else {
            for (int j = 0; j < n; j++) {
                if (tag[j] == 0) {
                    arr[i] = j;
                    if (check(i)) {
                        tag[j] = 1;
                        setQ(i + 1);
                        tag[j] = 0;
                    }
                }
            }
        }
    }

    private void add2Res(int[] arr){
        List<String> answer  = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(j==arr[i]){
                    str.append("Q");
                }else {
                    str.append(".");
                }
            }
            answer.add(str.toString());
        }
        res.add(answer);
    }

    private boolean check(int i) {
        for (int j = 0; j < i; j++) {
            int dif = i - j;
            int valDif = arr[i] - arr[j];
            if (arr[i] == arr[j] || dif == valDif || valDif == -dif) {
                return false;
            }
        }
        return true;
    }
}
