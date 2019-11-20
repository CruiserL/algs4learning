package com.gaoyang.lzj.algs4learning.classicalgsproblems;

/**
 * Desc: 汉诺塔问题
 *
 * @author Cruiser_L
 * @date 2019/11/19
 */
public class HanoiTower {

    public static int steps;

    public static void hanoi(int nums, char a, char b, char c){
        if(nums == 1){
//            System.out.println("第 " + ++steps + "步：");
            System.out.println(a + " -> " + c);
        }
        else {
            hanoi(nums-1, a, c, b);
//            System.out.println("第 " + ++steps + "步：");
            System.out.println(a + " -> " + c);
            hanoi(nums-1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hanoi(5, 'A', 'B', 'C');
    }
}
