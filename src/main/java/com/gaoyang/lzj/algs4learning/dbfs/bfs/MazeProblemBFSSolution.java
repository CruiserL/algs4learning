package com.gaoyang.lzj.algs4learning.dbfs.bfs;

import com.alibaba.fastjson.JSON;
import com.gaoyang.lzj.algs4learning.dbfs.problems.MazeProblem;

/**
 * Desc: 迷宫问题的广度优先遍历解法
 *
 * @author Cruiser_L
 * @date 2019/9/25
 */
public class MazeProblemBFSSolution {

    private BFSNode[] nodeList;

    private MazeProblem mazeProblem;

    private int head =0;
    private int tail =0;

    public MazeProblemBFSSolution(MazeProblem mazeProblem){
        this.mazeProblem = mazeProblem;
        this.nodeList = new BFSNode[mazeProblem.getArr().length * mazeProblem.getArr()[0].length];
        for(int i = 0;i<nodeList.length;i++){
            nodeList[i] = new BFSNode();
        }
    }

    public void solveMazeProblemByBFS(int startX, int StartY){
        BFSNode tailNode = nodeList[tail];
        BFSNode headNode = nodeList[head];
        int[][] next = mazeProblem.getNext();
        int[][] arr = mazeProblem.getArr();
        boolean[][] book = mazeProblem.getBook();
        tailNode.setX(startX);
        tailNode.setY(StartY);
        tailNode.setParent(0);
        tailNode.setStepLength(0);
        tail++;
        mazeProblem.getBook()[startX][StartY] = true;

        int flag = 0;

        while(head < tail){

            for(int k=0;k<=3;k++){
                int[] nextK = next[k];
                int nextX = headNode.getX() + nextK[0];
                int nextY = headNode.getY() + nextK[1];

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length) {
                    continue;
                }
                if (arr[nextX][nextY] == 0 && !book[nextX][nextY]) {
                    book[nextX][nextY] = true;
                    BFSNode tailN = nodeList[tail];
                    tailN.setX(nextX);
                    tailN.setY(nextY);
                    tailN.setParent(head);
                    tailN.setStepLength(nodeList[head].getStepLength()+1);
                    tail++;
                }
                if (nextX == mazeProblem.getP() && nextY == mazeProblem.getQ()) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            head++;
        }

        System.out.println(nodeList[tail-1].getStepLength());
        for(int i = 0;i<nodeList.length;i++){
            System.out.println(nodeList[i]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][4];
        arr[0][2] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[4][3] = 1;
        MazeProblem mazeProblem = new MazeProblem(arr, 3, 2);
        MazeProblemBFSSolution mazeProblemBFSSolution = new MazeProblemBFSSolution(mazeProblem);
        mazeProblemBFSSolution.solveMazeProblemByBFS(0, 0);
    }


}
