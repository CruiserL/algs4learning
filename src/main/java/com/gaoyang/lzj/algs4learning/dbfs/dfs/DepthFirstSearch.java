package com.gaoyang.lzj.algs4learning.dbfs.dfs;

/**
 * Desc: 实现n个数字的全排列
 *
 * @author Cruiser_L
 * @date 2019/9/20
 */
public class DepthFirstSearch {

    private int[] book;
    private int[] arr;
    private int n;
    private int num;


    public void dfs(int step) {
        if (step == n + 1) {
            if((arr[1] * 100 + arr[2]*10+arr[3]+arr[4]*100+arr[5]*10+arr[6])==(arr[7]*100+arr[8]*10+arr[9])){
                for (int i = 1; i <= n; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                num++;
            }
        }


        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                arr[step] = i;
                book[i] = 1;
                dfs(step + 1);
                book[i] = 0;
            }
        }
    }

    /**
     * 用于理解深度优先遍历
     */
    public void dfs(){
        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                arr[1] = i;
                book[i] = 1;
                for (int j = 1; j <= n; j++) {
                    if (book[j] == 0) {
                        arr[2] = j;
                        book[j] = 1;
                        for (int k = 1; k <= n; k++) {
                            if (book[k] == 0) {
                                arr[3] = k;
                                book[k] = 1;
                                for (int m = 1; m <= n; m++) {
                                    System.out.print(arr[m]);
                                }
                                System.out.println();
                                num++;
                                book[k] = 0;
                            }
                        }
                        book[j] = 0;
                    }
                }
                book[i] = 0;
            }
        }
    }

    public DepthFirstSearch(int n) {
        this.n = n;
        this.book = new int[n+1];
        this.arr = new int[n+1];
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(3);
        depthFirstSearch.dfs();
        System.out.println(depthFirstSearch.num);

    }
}
