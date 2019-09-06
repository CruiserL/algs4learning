package com.gaoyang.lzj.algs4learning.datastructure.arrbased;

import edu.princeton.cs.algs4.In;

import java.util.Scanner;

/**
 * Desc: myStack
 *
 * @author Cruiser_L
 * @date 2019/9/5
 */
public class MyStack {
    char[] charArr;
    int top;

    public char[] getCharArr() {
        return charArr;
    }

    public void setCharArr(char[] charArr) {
        this.charArr = charArr;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public MyStack(String str){
        this.top = 0;
        this.charArr = new char[100];
        for(int i = 0;i<str.length();i++){
            this.insert(str.charAt(i));
        }
    }

    public MyStack(){}

    public boolean isPalindrom(String str){

        int strLen = str.length();
        if(strLen < 2){
            return false;
        }
        int halfStrLen = strLen/2;
        String leftHalf = str.substring(0,strLen/2);
//        System.out.println(leftHalf);

        String rightHalf = strLen%2==0?str.substring(halfStrLen):str.substring(halfStrLen+1);
//        System.out.println(rightHalf);
        MyStack myStack = new MyStack(leftHalf);
//        System.out.println(myStack.getCharArr());
        for(int i = 0; i< rightHalf.length() && myStack.getTop()>0;i++){
//            System.out.println(rightHalf.charAt(i));
//            System.out.println(myStack.offer());
            if(rightHalf.charAt(i)!=myStack.offer()){
//                System.out.println(str + " 不是回文");
                return false;
            }
        }
        System.out.println(str + " 是回文");

        return true;

    }

    public char offer(){
        return this.charArr[--this.top];
    }

    public void insert(char c){
        this.charArr[this.top++] = c;
    }

    public static void main(String[] args) {
        In in = new In("H:\\leipzig1M.txt");
        MyStack myStack = new MyStack();
        int num = 0;
        while(in.hasNextChar()){
            String str = in.readString();
            if(myStack.isPalindrom(str)){
                num++;
            }
        }
            System.out.println(num);
    }
}
