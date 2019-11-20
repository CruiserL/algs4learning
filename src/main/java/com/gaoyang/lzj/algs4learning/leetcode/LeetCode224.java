package com.gaoyang.lzj.algs4learning.leetcode;

import java.util.Stack;

/**
 * Desc: LeetCode224
 *
 * @author Cruiser_L
 * @date 2019/11/2
 */
public class LeetCode224 {

    private static String PLUS = "+";
    private static String MINUS = "-";
    private static String LEFT = "(";
    private static String RIGHT = ")";
    private static String MUL = "*";
    private static String DEVIDE = "/";

    public int calculate(String s) {
        Stack<String> operStack = new Stack<>();
        Stack<String> numStack = new Stack<>();
        // 用于存储多位整数
        String bigInt = "";
        // 1. 从左到右遍历
        int i = 0;
        while (i < s.length()) {
            String subStr = s.substring(i, i + 1);
            char c = subStr.charAt(0);
            if (c >= '0' && c <= '9') {
                bigInt = bigInt + subStr;
                i++;
            } else {
                if (!"".equals(bigInt)) {
                    numStack.push(bigInt);
                    bigInt = "";
                } else {

                    if (LEFT.equals(subStr)) {
                        operStack.push(subStr);
                    }
                    if (RIGHT.equals(subStr)) {
                        while (!LEFT.equals(operStack.peek())) {
                            calPush(operStack, numStack);
                        }
                        // 将左括号出栈
                        operStack.pop();
                    }
                    // 如果是+或者-
                    if (PLUS.equals(subStr) || MINUS.equals(subStr) || MUL.equals(subStr)|| DEVIDE.equals(subStr)) {
                        // 如果符号栈空，直接push
                        if (operStack.isEmpty()) {
                            operStack.push(subStr);
                        } else {
                            // 如果符号栈非空，则判断优先级：
                            // 如果当前符号优先级<=栈顶优先级，计算一轮，当前符号入栈
                            // 如果当前符号>栈顶优先级，当前符号入栈
                            if (getPrior(subStr) <= getPrior(operStack.peek())) {
                                calPush(operStack, numStack);
                            }
                            operStack.push(subStr);
                        }
                    }
                    i++;
                }
            }
        }

        if (!"".equals(bigInt)) {
            numStack.push(bigInt);
        }
        // 计算剩余内容
        while (!operStack.isEmpty()) {
            calPush(operStack, numStack);
        }
        return Integer.parseInt(numStack.pop());
    }


    private int getPrior(String oper) {
        if (LEFT.equals(oper)) {
            return 0;
        }
        if (PLUS.equals(oper) || MINUS.equals(oper)) {
            return 1;
        }
        if(MUL.equals(oper) || DEVIDE.equals(oper)){
            return 2;
        }
        System.out.println("操作符非法");
        return 0;
    }

    private int cal(String num1, String num2, String oper) {
        if (PLUS.equals(oper)) {
            return Integer.parseInt(num1) + Integer.parseInt(num2);
        }
        if (MINUS.equals(oper)) {
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        }
        if (MUL.equals(oper)) {
            return Integer.parseInt(num1) * Integer.parseInt(num2);
        }
        if (DEVIDE.equals(oper)) {
            return Integer.parseInt(num1) / Integer.parseInt(num2);
        }
        System.out.println("非法计算，oper="+oper);
        return 0;
    }

    private void calPush(Stack<String> operStack, Stack<String> numStack) {
        String oper = operStack.pop();
        String num2 = numStack.pop();
        String num1 = numStack.pop();
        int newNum = cal(num1, num2, oper);
        numStack.push(String.valueOf(newNum));
    }

    public static void main(String[] args) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        LeetCode224 leetCode224 = new LeetCode224();
        System.out.println(leetCode224.calculate(s));
//        String subStr = "-";
//        String subStr1 = "-";
//        System.out.println(leetCode224.getPrior(subStr)<=leetCode224.getPrior(subStr1));
    }

}
