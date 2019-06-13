package com.gaoyang.lzj.algs4learning.mybasicalgs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Desc: MyQuickUF
 *
 * @author Cruiser_L
 * @date 2019/5/9
 */
public class MyQuickUF {

    public int[] arr;
    public int[] size;
    public int count;

    public MyQuickUF(int n){
        this.arr = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        this.count = n;
    }

    public int find(int x){
        int temp = x;
        while(arr[x] != x){
            // 实现路径压缩方法1，算法第四版给的官方建议写法。
            // 感觉只是减半，并不是所有的都连到了根节点
//            arr[x] = arr[arr[x]];
            x = arr[x];
        }
        // 实现路径压缩方法2：
        // 只要保证当前查找的节点直接连在根节点上即可。
        // 只要每次find都使某节点连到根节点上，则所有的节点都会连接到当前能找到的根节点上
        // 这里肯定只连到了当前的根节点。如果两个树合并，则原根节点将可能不再是根节点。
        // 不会侦测到树的合并。
//        arr[temp] = x;

        // 实现路径压缩方法3：实际上不对？
        // 但是仍然不能保证树合并之后所有节点自动更新根节点
        // 比方法2多了一重。如果发生了树的合并而且侦测到了该合并，则会更新根节点
        // 但是即使使用此方法，在100万触点200万连接的输入下，执行时间并没有比非压缩的加权算法更短，甚至有了些微的延长。
        while(temp != arr[temp]){
            temp = arr[temp];
            arr[temp] = x;
        }
        return x;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ){
            return;
        }
        if(size[rootP] <= size[rootQ]){
            arr[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }else{
            arr[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    /**
     * 使用不压缩路径的加权UF算法，100万个触点， 200万条连接，算出6个分量，只需要4s左右。
     * 而quick-find算法需要900s左右。
     * @param args
     */
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        In in = new In("H:\\algs4-data\\largeUF.txt");
        int n = in.readInt();
        MyQuickUF myQuickUF = new MyQuickUF(n);
        int i = 0;
        while(!in.isEmpty()){
            i++;
            if(i % 10000 == 0){
                System.out.println("当前已处理 " + i/10000 + " 万条数据，处理时间：" + stopwatch.elapsedTime());
            }
            int p = in.readInt();
            int q = in.readInt();
            if(myQuickUF.connected(p, q)){
                continue;
            }
            myQuickUF.union(p, q);
        }
        System.out.println(Arrays.toString(myQuickUF.arr));
        System.out.println(myQuickUF.count + " components");
        System.out.println(stopwatch.elapsedTime());

    }
}
