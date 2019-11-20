package com.gaoyang.lzj.algs4learning.dbfs.problems;

/**
 * Desc: 迷宫问题
 *
 * @author Cruiser_L
 * @date 2019/9/24
 */
public class MazeProblem {

    /**
     * 用于存储迷宫
     */
    private int arr[][];
    /**
     * 用于记录某个点是否已经走过
     */
    private boolean book[][];
    /**
     * 用于记录方向
     */
    private int next[][];
    private int minStep = Integer.MAX_VALUE;
    /**
     * 迷宫内要查找的点的坐标
     */
    private int p;
    private int q;

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public boolean[][] getBook() {
        return book;
    }

    public void setBook(boolean[][] book) {
        this.book = book;
    }

    public int[][] getNext() {
        return next;
    }

    public void setNext(int[][] next) {
        this.next = next;
    }

    public int getMinStep() {
        return minStep;
    }

    public void setMinStep(int minStep) {
        this.minStep = minStep;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public MazeProblem(int[][] maze, int p, int q) {
        this.arr = maze;
        //{{0,1},{1,0},{0,-1},{-1,0}}
        this.next = new int[4][2];
        next[0][0] = 0;
        next[0][1] = 1;
        next[1][0] = 1;
        next[1][1] = 0;
        next[2][0] = 0;
        next[2][1] = -1;
        next[3][0] = -1;
        next[3][1] = 0;
        this.book = new boolean[maze.length][maze[0].length];
        this.p = p;
        this.q = q;
    }




}
