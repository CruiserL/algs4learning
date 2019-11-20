package com.gaoyang.lzj.algs4learning.leetcode;

import java.util.Stack;

/**
 * Desc: LeetCode224
 *
 * @author Cruiser_L
 * @date 2019/11/2
 */
public class SimpleCalculator {

    public static String PLUS = "+";
    public static String MINUS = "-";
    public static String LEFT_P = "(";
    public static String RIGHT_P = ")";


    public int calculate(String s) {
        // 操作符栈
        Stack<String> operStack = new Stack<>();
        // 数栈
        Stack<String> numStack = new Stack<>();
        // 多位整数
        String mulInt = "";
        int i = 0;
        while (i < s.length()) {
            String subStr = s.substring(i, i + 1);
            char c = subStr.charAt(0);
            if (c >= '0' && c <= '9') {
                mulInt += subStr;
                i++;
            } else {
                if (!"".equals(mulInt)) {
                    numStack.push(mulInt);
                    mulInt = "";
                }
                if(" ".equals(subStr)){
                    i++;
                    continue;
                }
                // 如果操作符栈空，直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(subStr);
                    i++;
                    continue;
                }
                // 如果为右括号
                if(RIGHT_P.equals(subStr)){
                    while (!operStack.peek().equals(LEFT_P)){
                        calPush(operStack, numStack);
                    }
                    operStack.pop();
                    i++;
                    continue;
                }
                if(LEFT_P.equals(subStr)){
                    operStack.push(subStr);
                    i++;
                    continue;
                }
                // 如果此时获得的运算符优先级小于oper栈顶运算符，则计算
                if (getPrior(subStr) <= getPrior(operStack.peek())) {
                    calPush(operStack, numStack);
                }
                // 如果此时获得的运算符大于栈顶运算符，则入栈
                else {
                    operStack.push(subStr);
                    i++;
                }
            }

        }
        if (!"".equals(mulInt)) {
            numStack.push(mulInt);
        }

        while (!operStack.isEmpty()) {
            calPush(operStack, numStack);
        }

        return Integer.parseInt(numStack.pop());
    }

    private int getPrior(String subStr) {
        if (LEFT_P.equals(subStr)) {
            return 0;
        }
        if (PLUS.equals(subStr) || MINUS.equals(subStr)) {
            return 1;
        }
        System.out.println("非法运算符");
        return 0;
    }

    public void calPush(Stack<String> operStack, Stack<String> numStack) {
        String num2 = numStack.pop();
        String num1 = numStack.pop();
        String oper = operStack.pop();
        int newNum = 0;
        if (oper.equals(PLUS)) {
            newNum = Integer.parseInt(num1) + Integer.parseInt(num2);
        } else if (oper.equals(MINUS)) {
            newNum = Integer.parseInt(num1) - Integer.parseInt(num2);
        } else {
            System.out.println("计算出错");
        }
        numStack.push(String.valueOf(newNum));
    }


    public static void main(String[] args) {
        String s = " 2-1 + 2 ";
        SimpleCalculator leetCode224 = new SimpleCalculator();
        System.out.println(leetCode224.calculate(s));
//        String subStr = "-";
//        String subStr1 = "-";
//        System.out.println(leetCode224.getPrior(subStr)<=leetCode224.getPrior(subStr1));
    }

}
