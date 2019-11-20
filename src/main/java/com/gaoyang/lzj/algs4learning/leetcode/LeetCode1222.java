package com.gaoyang.lzj.algs4learning.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:LeetCode1222：可以攻击国王的皇后
 *
 * @author Cruiser_L
 * @date 2019/11/8
 */
public class LeetCode1222 {

    private static int[][] orient = {
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1}
    };

    private int[][] chessBoard;

    private int n;

    public LeetCode1222(int n) {
        this.chessBoard = new int[n][n];
        this.n = n;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        // 将所有皇后set到棋盘中
        for (int[] queen : queens) {
            chessBoard[queen[0]][queen[1]] = 1;
        }
        for (int[] ints : chessBoard) {
            for (int i = 0; i < ints.length; i++) {
                System.out.printf("%d\t", ints[i]);
            }
            System.out.println();
        }
        // 在每一个方向上向远处查找

        for (int[] ori : orient) {
            int j = king[0];
            int k = king[1];
            while(j+ori[0] < 8 && j+ori[0]>=0 && k+ori[1] < 8 && k+ori[1]>=0){
                j += ori[0];
                k += ori[1];
                if(chessBoard[j][k] == 1){
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(k);
                    res.add(list);
                    break;
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode1222 leetCode1222 = new LeetCode1222(8);
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0, 0};
        leetCode1222.queensAttacktheKing(queens, king);
    }

}
