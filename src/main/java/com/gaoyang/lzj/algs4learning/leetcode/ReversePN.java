package com.gaoyang.lzj.algs4learning.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Desc: 逆波兰表达式相关
 *
 * @author Cruiser_L
 * @date 2019/11/4
 */
public class ReversePN {

    private static String PLUS = "+";
    private static String MINUS = "-";
    private static String LEFT = "(";
    private static String RIGHT = ")";
    private static String MUL = "*";
    private static String DEVIDE = "/";

    public ArrayList<String> infix2Postfix(String s) {
        Stack<String> operStack = new Stack<>();
        ArrayList<String> reversePNStack = new ArrayList<>();
        // 用于存储多位整数
        String bigInt = "";
        // 1. 从左到右遍历
        int i = 0;
        while (i < s.length()) {
            String subStr = s.substring(i, i + 1);
            System.out.println(reversePNStack);
            char c = subStr.charAt(0);
            if (c >= '0' && c <= '9') {
                bigInt = bigInt + subStr;
                i++;
            } else {
                if (!"".equals(bigInt)) {
                    reversePNStack.add(bigInt);
                    bigInt = "";
                } else {
                    if (LEFT.equals(subStr)) {
                        operStack.push(subStr);
                    }
                    if (RIGHT.equals(subStr)) {
                        while (!LEFT.equals(operStack.peek())) {
                            reversePNStack.add(operStack.pop());
                        }
                        // 将左括号出栈
                        operStack.pop();
                    }
                    // 如果是+
                    if (PLUS.equals(subStr) || MINUS.equals(subStr) || MUL.equals(subStr) || DEVIDE.equals(subStr)) {
                        // 如果符号栈空，直接push
                        if (operStack.isEmpty()) {
                            operStack.push(subStr);
                        } else{
                            while(!operStack.isEmpty() && getPrior(subStr) <= getPrior(operStack.peek())){
                                    reversePNStack.add(operStack.pop());
                            }
                            // 此时当前运算符的优先级肯定高于栈顶运算符
                            operStack.push(subStr);
                        }
                    }
                    i++;
                }
            }
        }

        if (!"".equals(bigInt)) {
            reversePNStack.add(bigInt);
        }
        // 将剩余的oper压入
        while (!operStack.isEmpty()) {
            reversePNStack.add(operStack.pop());
        }
        return reversePNStack;
    }

    private int getPrior(String oper) {
        if (LEFT.equals(oper)) {
            return 0;
        }
        if (PLUS.equals(oper) || MINUS.equals(oper)) {
            return 1;
        }
        if (MUL.equals(oper) || DEVIDE.equals(oper)) {
            return 2;
        }
        System.out.println("操作符非法");
        return 0;
    }

    private int cal(int num1, int num2, String oper) {
        if (PLUS.equals(oper)) {
            return num1 + num2;
        }
        if (MINUS.equals(oper)) {
            return num1 - num2;
        }
        if (MUL.equals(oper)) {
            return num1 * num2;
        }
        if (DEVIDE.equals(oper)) {
            return num1 / num2;
        }
        System.out.println("非法计算，oper="+oper);
        return 0;
    }

    public int calPNValue(ArrayList<String> reverseArr){
        Stack<Integer> integerStack = new Stack<>();
        for(String str : reverseArr){
            if (PLUS.equals(str) || MINUS.equals(str) || MUL.equals(str) || DEVIDE.equals(str)) {
                int num2 = integerStack.pop();
                int num1 = integerStack.pop();
                int x = cal(num1, num2, str);
                integerStack.push(x);
            }else{
                integerStack.push(Integer.parseInt(str));
            }
        }
        return  integerStack.pop();
    }

    public static void main(String[] args) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        ReversePN reversePN = new ReversePN();
        ArrayList<String> reverseArr = reversePN.infix2Postfix(s);
        System.out.println(reverseArr);
        System.out.println(reversePN.calPNValue(reverseArr));
    }

}
