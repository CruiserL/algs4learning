package com.gaoyang.lzj.algs4learning.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Desc: 表达式字符串的计算
 *
 * @author Cruiser_L
 * @date 2019/11/4
 */
public class NotationCalculator {

    private static final Logger logger = LoggerFactory.getLogger("test");

    public static char left = '(';
    public static char right = ')';
    public static char plus = '+';
    public static char minus = '-';
    public static char multi = '*';
    public static char devide = '/';

    public int calculate(String s) {
        // 1. 首先使用两个栈，一个用来存储数字，一个用来存储操作符
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        // 2. 再使用一个变量用来存储多位整数
        String mulInt = "";
        // 3. 从左向右开始扫描表达式
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            // 3.1 如果是数字，则mulInt拼接
            if (c >= '0' && c <= '9') {
                mulInt += String.valueOf(c);
                i++;
            }
            // 3.2 如果不是数字，则
            else {
                // 3.3.1 判断此时mulInt是否为空，如果不为空，则将mulInt压入数栈, 此步骤要注意将mulInt还原为空字符串
                if (!"".equals(mulInt)) {
                    intStack.push(Integer.parseInt(mulInt));
                    mulInt = "";
                } else {
                    // 3.3.2 如果mulInt为空，则进入字符判断
                    //      1）如果为左括号，直接入符号栈
                    if (left == c) {
                        charStack.push(c);
                    }
                    //      2）如果为右括号：则开始循环：从数栈顶取两个数字，从符号栈顶取一个符号，计算结果，计算完成后将结果入数栈，直到符号栈取到左括号为止
                    if (right == c) {
                        while (charStack.peek() != left) {
                            calPush(intStack, charStack);
                        }
                        charStack.pop();
                    }
                    //      3）如果为各种操作符，则如果操作符优先级大于栈顶，则直接入栈；
                    if (plus == c || minus == c || multi == c || devide == c) {
                        if (charStack.isEmpty() || getPrior(c) > getPrior(charStack.peek())) {
                            charStack.push(c);
                        } else {
                            // 如果操作符优先级小于或等于栈顶，则先计算，然后再比较当前操作符与栈顶操作符
                            while (!charStack.isEmpty() && getPrior(c) <= getPrior(charStack.peek())) {
                                calPush(intStack, charStack);
                            }
                            charStack.push(c);
                        }
                    }
                    i++;
                }
            }
            logger.info("charStack={}", charStack);
            logger.info("intStack={}", intStack);
            System.out.println();
        }
        // 4. 扫描完毕，如果此时mulInt不为空，则将mulInt入数栈
        if (!"".equals(mulInt)) {
            intStack.push(Integer.parseInt(mulInt));
        }

        // 5. 开始计算：从数栈中取两个值，从符号栈中取一个值，计算后将结果压入数栈，直到符号栈栈空
        while (!charStack.isEmpty()) {
            logger.info("charStack={}", charStack);
            logger.info("intStack={}", intStack);
            System.out.println();
            calPush(intStack, charStack);
        }
        // 6. 此时计算完毕，数栈中最后一个数字即为表达式结果
        logger.info("charStack={}", charStack);
        logger.info("intStack={}", intStack);
        System.out.println();
        return intStack.pop();
    }

    private void calPush(Stack<Integer> intStack, Stack<Character> charStack) {
        int num2 = intStack.pop();
        int num1 = intStack.pop();
        char oper = charStack.pop();
        intStack.push(cal(num1, num2, oper));
    }

    private int cal(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                System.out.println("操作符有误，操作符为 " + oper);
                return 0;
        }
    }

    private int getPrior(char oper) {
        switch (oper) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                System.out.println("操作符有误，操作符为 " + oper);
                return 100;
        }
    }

    /**
     * 中缀表达式转后缀表达式（逆波兰表达式）
     * @param s 中缀表达式
     * @return 逆波兰表达式
     */
    private ArrayList<String> infix2posFix(String s){
        // 1. 首先定义一个列表，用于正序存储后缀表达式的各项
        ArrayList<String> reverseNotation = new ArrayList<>();
        // 2. 再定义一个字符串栈，用于存储中间的操作符
        Stack<String> operStack = new Stack<>();
        // 3. 定义一个mulInt，用于存储多位整数
        String mulInt = "";
        // 4. 从左到右开始扫描中缀表达式
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            String c = String.valueOf(ch);
        //  4.1 如果是数字，则mulInt加一位
            if(ch>='0'&&ch<='9'){
                mulInt = mulInt+c;
                i++;
            }
        //  4.2 如果不是数字
            else {
            // 如果此时mulInt不为空，则将数字入列表
                if(!"".equals(mulInt)){
                    reverseNotation.add(mulInt);
                    mulInt = "";
                }else{
            // 如果此时mulInt为空，则此时为操作符
                    if(left == ch){
            // 1）. 如果为左括号，则直接入栈
                        reverseNotation.add(c);
                    }
            // 2）. 如果为右括号，则将右括号到左括号之间的操作符全部入栈
                    if(right == ch){
                        while(left != operStack.peek().charAt(0)){
                            reverseNotation.add(operStack.pop());
                        }
                        operStack.pop();
                    }
            // 3）. 如果为符号，则再次判断
                    if (plus == ch || minus == ch || multi == ch || devide == ch) {
            //      1.如果当前操作符优先级高于栈顶或栈空，则直接入栈
                        if(operStack.isEmpty() || getPrior(ch)>getPrior(operStack.peek().charAt(0))){
                            operStack.push(c);
                        }else{
            //      2.否则，将符号栈中元素依次弹出，加到列表尾部。
                            while(!(operStack.isEmpty() || getPrior(ch)>getPrior(operStack.peek().charAt(0)))){
                                reverseNotation.add(operStack.pop());
                            }
                            operStack.push(c);
                        }
                    }
                    i++;
                }
            }
        }
        // 5. 循环完毕，如果此时mulInt不为空，则将此数字入列表
        if(!"".equals(mulInt)){
            reverseNotation.add(mulInt);
        }
        // 6. 此时得到的列表即为后缀表达式
        while(!operStack.isEmpty()){
            reverseNotation.add(operStack.pop());
        }
        return reverseNotation;
    }

    public int calculate(ArrayList<String> arr){
        // 需要两个栈，一个数栈，一个符号栈
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        // 从左到右遍历列表
        for(String str : arr){
        // 如果是操作符，计算后入数栈
            char c = str.charAt(0);
            if (plus == c || minus == c || multi == c || devide == c) {
                int num2 = integerStack.pop();
                int num1 = integerStack.pop();
                int newNum = cal(num1, num2, c);
                integerStack.push(newNum);
            }
        // 如果是数字，直接入数栈
            else{
                integerStack.push(Integer.parseInt(str));
            }
        }
        return integerStack.pop();
    }



    public static void main(String[] args) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        NotationCalculator calculator = new NotationCalculator();
        System.out.println(calculator.calculate(s));
        ArrayList<String> postFixNotation = calculator.infix2posFix(s);
        System.out.println(postFixNotation);
        System.out.println(calculator.calculate(postFixNotation));
    }
}
