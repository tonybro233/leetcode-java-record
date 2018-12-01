package tony.leetcode.feature.math;

// 227. 基本计算器 II
// 实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。整数除法仅保留整数部分。
//
// 示例 1:
// 输入: "3+2*2"
// 输出: 7

// 示例 2:
// 输入: " 3/2 "
// 输出: 1

// 示例 3:
// 输入: " 3+5 / 2 "
// 输出: 5

import java.util.ArrayDeque;
import java.util.Deque;

public class Basic_Calculator_II {

    // 写得比较丑陋
    public int calculate(String s) {
        s = s.replace(" ","");
        char[] chars = s.toCharArray();
        int i = 0;
        Integer eachNum = null;
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        while (i <= chars.length){
            if (i < chars.length && Character.isDigit(chars[i])){
                if (null != eachNum) {
                    eachNum = eachNum * 10 + (chars[i] - '0');
                } else {
                    eachNum = chars[i] - '0';
                }
            } else {
                if (null != eachNum) {
                    Character op = opStack.pollLast();
                    if (null == op) {
                        stack.addLast(eachNum);
                    } else if ('*' == op) {
                        eachNum *= stack.pollLast();
                        stack.addLast(eachNum);
                    } else if ('/' == op) {
                        eachNum = stack.pollLast() / eachNum;
                        stack.addLast(eachNum);
                    } else {
                        opStack.addLast(op);
                        stack.addLast(eachNum);
                    }
                    eachNum = null;
                    if (i < chars.length) {
                        opStack.addLast(chars[i]);
                    }
                }
            }
            i++;
        }
        while (opStack.size() !=0 ){
            Character op = opStack.pollFirst();
            Integer v1 = stack.pollFirst();
            Integer v2 = stack.pollFirst();
            if ('+' == op){
                stack.addFirst(v1+v2);
            } else {
                stack.addFirst(v1 - v2);
            }
        }
        if (stack.size() > 0) {
            return stack.poll();
        } else {
            return 0;
        }
    }

    // 相对简洁的写法，不过依然是两个循环，先计算乘除再计算加减
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num*10 + s.charAt(i) - '0';
            }
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9') && s.charAt(i) != ' ' || i == s.length()-1){
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num); // 直接取反使得后一个循环不需要判断+ - 号
                }
                if (sign == '*') {
                    stack.push(stack.pop()*num);
                }
                if (sign == '/') {
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }

        }
        int res = 0;
        for(Integer item: stack){
            res += item;
        }
        return res;
    }

    // 另一种思路，通过一个虚拟的+，将表达式用+-拆开，每一段
    public int calculate3(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0; // 返回值
        int curRes = 0; // 临时值
        char sign = '+'; // 表示上一个运算符，并且使得第一个运算符为+，表达式中的运算符从第二个开始
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ' && i != len - 1){
                continue;
            }
            if (c >= '0' && c <= '9'){
                num = num*10 + c - '0';
            }
            if (c == '+' || c == '-' || c== '*' || c == '/' || i == len-1){
                // 立即执行运算际，因为下面if语句，+-在这一步执行的时候curRes一定是0，这么写看起来优雅但不容易理解
                switch(sign){
                    case '+':curRes+=num;break; // curRes = num
                    case '-':curRes-=num;break; // curRes = -num
                    case '*':curRes*=num;break;
                    case '/':curRes/=num;break;
                }
                // 如果当前运算符是+-，表明进入下一个运算区间，更新返回值，清空临时值
                if (c == '+' || c == '-' || i == len-1){
                    res += curRes;
                    curRes = 0;
                }
                sign = c;
                num = 0;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int calculate = new Basic_Calculator_II().calculate3("1+3+2/2-3+2*2");
        System.out.println(calculate);
    }

}
