package com.gaoyang.lzj.algs4learning.dbfs.dfs;

import com.gaoyang.lzj.algs4learning.dbfs.problems.MazeProblem;

/**
 * Desc: 迷宫问题的深度优先遍历解法
 *
 * @author Cruiser_L
 * @date 2019/9/25
 */
public class MazeProblemDFSSolution {

    private MazeProblem maze;

    public MazeProblemDFSSolution(MazeProblem maze){
        this.maze = maze;
    }

    public void solveMazeProblem(int x, int y, int steps) {
        int next[][] = maze.getNext();
        int arr[][] = maze.getArr();
        boolean[][] book = maze.getBook();
        int nextX;
        int nextY;
        System.out.printf("x=%d,y=%d", x, y);
        System.out.println();
        if (x == maze.getP() && y == maze.getQ()) {
            if (steps < maze.getMinStep()) {
                maze.setMinStep(steps);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= 3; i++) {
            nextX = x + next[i][0];
            nextY = y + next[i][1];
//            System.out.printf("nextX=%d,nextY=%d", nextX, nextY);
//            System.out.println();
            if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length) {
                continue;
            }
            if (arr[nextX][nextY] == 0 && !book[nextX][nextY]) {
                book[nextX][nextY] = true;
                solveMazeProblem(nextX, nextY, steps + 1);
                book[nextX][nextY] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][4];
        arr[0][2] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[4][3] = 1;
        MazeProblem mazeProblem = new MazeProblem(arr, 3, 2);
        MazeProblemDFSSolution mazeProblemDFSSolution = new MazeProblemDFSSolution(mazeProblem);
        mazeProblemDFSSolution.solveMazeProblem(0, 0, 0);
        System.out.println(mazeProblemDFSSolution.maze.getMinStep());
    }
}
