package com.gaoyang.lzj.algs4learning.recursion;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Desc: n皇后问题
 *
 * @author Cruiser_L
 * @date 2019/11/5
 */
public class NQueen {

    private int[][] chessBoard;

    private int[] arr;

    private int answers;

    public static void main(String[] args) {
        solveNQueen(10);
    }

    private static void solveNQueen(int n) {
        NQueen nQueen = new NQueen(n);
        nQueen.setQueen(0, n);
        System.out.println();
        System.out.printf("%d 皇后问题共有 %d 种解法", n, nQueen.answers);
    }

    /**
     * @param n 指定皇后个数及棋盘大小
     */
    public NQueen(int n) {
        this.chessBoard = new int[n][n];
        this.arr = new int[n];
    }

    private void setQueen(int i, int queenNum) {
        if (i == queenNum) {
            answers++;
            System.out.println(JSON.toJSONString(arr));
        } else {
            for (int j = 0; j < queenNum; j++) {
                arr[i] = j;
                if (check(i)) {
                    setQueen(i + 1, queenNum);
                }
            }
        }
    }

    private boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || ((arr[i] - arr[n]) == i - n) || ((arr[i] - arr[n]) == n - i) ){
                return false;
            }
        }
        return true;
    }


//    private void setQueen(int i, int queenNum){
//        if(i==queenNum){
//            answers++;
//            System.out.println(JSON.toJSONString(arr));
//            return;
//        }
//
//        for (int j = 0; j < queenNum; j++) {
//            arr[i] = j;
//            if(check(i)){
//                setQueen(i+1, queenNum);
//            }
//        }
//
//    }

//    private boolean check(int j) {
//        for (int i = 0; i < j; i++) {
//            if (arr[i] == arr[j] || Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
//                return false;
//            }
//        }
//        return true;
//    }
//

//    private void setQueen(int n, int QueenNum){
//        if(n == QueenNum){
//            answers++;
//            System.out.println(JSON.toJSONString(arr));
//            return;
//        }
//
//        for (int i = 0; i < QueenNum; i++) {
//            arr[n] = i;
//            if(judge(n)){
//                setQueen(n+1, QueenNum);
//            }
//        }
//    }

//    private boolean judge(int n){
//        for (int i = 0; i < n; i++) {
//            if(arr[i] == arr[n] || Math.abs(i-n) == Math.abs(arr[i]-arr[n])){
//                return false;
//            }
//        }
//        return true;
//    }

    public List<List<String>> solveNQueens(int n) {
        return null;
    }
}
