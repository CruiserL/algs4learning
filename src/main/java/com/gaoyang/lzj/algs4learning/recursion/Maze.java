package com.gaoyang.lzj.algs4learning.recursion;

/**
 * Desc: 迷宫问题
 *
 * @author Cruiser_L
 * @date 2019/11/5
 */
public class Maze {

    private static int walked = 7;

    private static int deadPot = 11;

    private static int[][] orient = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int[][] mazeArea;
    private int[][] blocked;

    public static void main(String[] args) {
        int mazeLen = 6;
        int blockedLen = 10;
        Maze maze = new Maze(mazeLen, blockedLen);

        maze.initMaze(maze.blocked, maze.mazeArea);

        System.out.println();
        int[] target = {mazeLen - 2, mazeLen - 2};
//        maze.stepForward(maze.mazeArea, 1, 1, target);
        if (!maze.stepForward(maze.mazeArea, 1, 1, target)) {
            System.out.println("迷宫为封闭迷宫，无法走出");
            maze.printMaze(maze.mazeArea);
        }
//        if (maze.mazeArea[target[0]][target[1]] != walked) {
//            System.out.println("迷宫为封闭迷宫，无法走出");
//            maze.printMaze(maze.mazeArea);
//        }
        System.out.println();
        maze.printMaze(maze.mazeArea);

    }

    private Maze(int mazeLen, int blockedLen) {
        this.mazeArea = new int[mazeLen][mazeLen];
        this.blocked = new int[blockedLen][2];
        for (int i = 0; i < blockedLen; i++) {
            blocked[i][0] = (int) (mazeLen * Math.random());
            blocked[i][1] = (int) (mazeLen * Math.random());
        }
    }

    private boolean stepForward(int[][] mazeArea, int i, int j, int[] target){
        if(mazeArea[target[0]][target[1]] == walked){
            return true;
        }
        else {
            if(mazeArea[i][j] == 0){
                mazeArea[i][j] = walked;
                for (int k = 0; k < orient.length; k++) {
                    if(stepForward(mazeArea, i+orient[k][0], j+orient[k][1], target)){
                        return true;
                    }
                }
                mazeArea[i][j] = deadPot;
            }
            return false;
        }
    }


//    private boolean stepForward(int[][] mazeArea, int i, int j, int[] target) {
//        if (i == target[0] && j == target[1]) {
//            System.out.println("存在路径可以走出迷宫");
//            mazeArea[i][j] = walked;
//            printMaze(mazeArea);
//            return true;
//        } else {
//            if (mazeArea[i][j] == 0) {
//                mazeArea[i][j] = walked;
//                for (int k = 0; k < orient.length; k++) {
//                    boolean flag = false;
//                    if (i + 1 == target[0] && j == target[1]) {
//                        System.out.println("存在路径可以走出迷宫");
//                        mazeArea[i + 1][j] = walked;
//                        printMaze(mazeArea);
//                        flag = true;
//                    } else {
//                        if (mazeArea[i + 1][j] == 0) {
//                            mazeArea[i + 1][j] = walked;
//                            for (int m = 0; m < orient.length; m++) {
//                                boolean flag1 = false;
//
//                                if (i + 2 == target[0] && j == target[1]) {
//                                    System.out.println("存在路径可以走出迷宫");
//                                    mazeArea[i + 2][j] = walked;
//                                    printMaze(mazeArea);
//                                    flag1 = true;
//                                } else {
//                                    if (mazeArea[i + 2][j] == 0) {
//                                        mazeArea[i + 2][j] = walked;
//                                        for (int n = 0; n < orient.length; n++) {
//                                            boolean flag2 = false;
//
//
//                                            if (flag) {
//                                                return true;
//                                            }
//                                        }
//                                        mazeArea[i + 2][j] = deadPot;
//                                    }
//                                    return false;
//                                }
//                                if (flag) {
//                                    return true;
//                                }
//                            }
//                            mazeArea[i + 1][j] = deadPot;
//                        }
//                        return false;
//                    }
//                    if (flag) {
//                        return true;
//                    }
//                }
//                mazeArea[i][j] = deadPot;
//            }
//            return false;
//        }
//    }


//    private boolean stepForward(int[][] mazeArea, int i, int j, int[] target) {
//        if (mazeArea[target[0]][target[1]] == walked) {
//            System.out.println("存在路径可以走出迷宫");
//            printMaze(mazeArea);
//            return true;
//        } else {
//            if (mazeArea[i][j] == 0) {
//                mazeArea[i][j] = walked;
//                for (int k = 0; k < orient.length; k++) {
//                    if (stepForward(mazeArea, i + orient[k][0], j + orient[k][1], target)) {
//                        return true;
//                    }
//                }
//                mazeArea[i][j] = deadPot;
//            }
//            return false;
//        }
//    }
//

    /**
     * 有问题的解法：得到正确解之后不能立刻退出
     */
//    public void stepForward(int[][] mazeArea, int i , int j, int[] target){
////        System.out.println();
////        printMaze(mazeArea);
//            mazeArea[i][j] = walked;
////            if(mazeArea[target[0]][target[1]] == walked){
////                System.out.println("存在路径可以走出迷宫");
////                printMaze(mazeArea);
////                return;
////            }
//
//            if(i == target[0] && j == target[1]){
//                System.out.println("存在路径可以走出迷宫");
//                printMaze(mazeArea);
//                return;
//            }
//            int k = 0;
//            for (; k < orient.length; k++) {
//                if(mazeArea[i+orient[k][0]][j+orient[k][1]] == 0){
//                    stepForward(mazeArea, i+orient[k][0], j+orient[k][1], target);
//                }
//            }
//            if(k == orient.length){
//                mazeArea[i][j] = deadPot;
//            }
////        return false;
//
//    }

//    public boolean setWay(int[][] mazeArea, int i, int j, int[] target) {
//        if (mazeArea[target[0]][target[1]] == walked) {
//            return true;
//        }
//        if (mazeArea[i][j] == 0) {
//
//            mazeArea[i][j] = walked;
//            for (int k = 0; k < orient.length; k++) {
//                if (setWay(mazeArea, i+orient[k][0], j+orient[k][1], target)) {
//                    return true;
//                }
//            }
//            mazeArea[i][j] = deadPot;
//        }
//
//        return false;
//    }


    /**
     * 初始化迷宫
     *
     * @param blocked  障碍物所在的点
     * @param mazeArea 初始迷宫
     */
    public void initMaze(int[][] blocked, int[][] mazeArea) {
        int mazeLen = mazeArea.length;
        for (int i = 0; i < blocked.length; i++) {
            mazeArea[blocked[i][0]][blocked[i][1]] = 1;
        }
        for (int i = 0; i < mazeLen; i++) {
            mazeArea[0][i] = 1;
            mazeArea[mazeLen - 1][i] = 1;
        }
        for (int j = 0; j < mazeLen; j++) {
            mazeArea[j][0] = 1;
            mazeArea[j][mazeLen - 1] = 1;
        }
        mazeArea[1][1] = 0;
        mazeArea[mazeLen - 2][mazeLen - 2] = 0;
        printMaze(mazeArea);
    }

    private void printMaze(int[][] mazeArea) {
        for (int i = 0; i < mazeArea.length; i++) {
            for (int j = 0; j < mazeArea[0].length; j++) {
                System.out.print(mazeArea[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //    public boolean setWay(int[][] map, int[] source, int[] target){
//        // 如果目标点值为2，则说明已经找到一条通路
//        if(map[target[0]][target[1]] == 2){
//            return true;
//        }
//
//        map[source[0]][source[1]] = 2;
//        if(setWay(map, map[source[0]+orient[0][0]], target)){
//            setWay(map, source, target);
//        }
//    }

//    public boolean check(int[][] map, int i, int j){
//        if(map[i][j]==0){
//            return true;
//        }else {
//            return false;
//        }
//    }

    //    public boolean setWay(int[][] map, int i, int j, int[] target) {
//        // 如果目标点值为walked，则说明已经找到一条通路
//        if (map[target[0]][target[1]] == walked) {
//            return true;
//        }
//
//        if (map[i][j] == 0) {
//            map[i][j] = walked;
//            for (int k = 0; k < orient.length; k++) {
//                if (setWay(map, i + orient[k][0], j + orient[k][1], target)) {
//                    return true;
//                }
//            }
//            map[i][j] = deadSpot;
//        }
//        return false;
//    }

}
