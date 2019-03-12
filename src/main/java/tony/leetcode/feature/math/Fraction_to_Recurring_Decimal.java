package tony.leetcode.feature.math;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 166. 分数到小数
// 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
// 如果小数部分为循环小数，则将循环的部分括在括号内。
//
// 示例 1:
// 输入: numerator = 1, denominator = 2
// 输出: "0.5"

// 示例 2:
// 输入: numerator = 2, denominator = 1
// 输出: "2"

// 示例 3:
// 输入: numerator = 2, denominator = 3
// 输出: "0.(6)"

public class Fraction_to_Recurring_Decimal {

    public String fractionToDecimal2(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        //判断分子是否为0
        if (numerator == 0) {
            return "0";
        }

        //判断正负
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        } else {
            result.append("");
        }

        Long num =  Math.abs((long) numerator);
        Long den = Math.abs((long) denominator);

        //整数部分
        result.append(num / den);
        num = num % den;
        if (num == 0) {
            return result.toString();
        }

        //确定小数部分
        result.append(".");
        // key为余数，value为当前字符串的长度
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());


        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0){
            return "0";
        }
        boolean neg = (numerator > 0 && denominator < 0)
                || (numerator < 0 && denominator > 0);
        long newNumerator = Math.abs((long)numerator);
        long newdDenominator = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        if (neg){
            sb.append('-');
        }
        if (newNumerator % newdDenominator == 0){
            sb.append(newNumerator / newdDenominator);
            return sb.toString();
        }
        long remain;
        if (newNumerator < newdDenominator){
            sb.append("0.");
        } else {
            sb.append(newNumerator / newdDenominator).append('.');
            newNumerator = newNumerator % newdDenominator;
        }

        // key为余数，value为取得余数的商(扩大被除数后带0前缀的字符串)
        LinkedHashMap<Long, String> map = new LinkedHashMap<>();
        while (newNumerator != 0){
            newNumerator *= 10;
            String divide = "";
            while (newNumerator < newdDenominator){
                newNumerator *= 10;
                divide += "0";
            }
            long divideVal = newNumerator / newdDenominator;
            remain = newNumerator % newdDenominator;
            divide += divideVal;
            if (remain == 0){
                sb.append(divide);
                break;
            }
            if (map.containsKey(remain) && map.get(remain).equals(divide)) {
                int count = 0;
                boolean begin = false;
                for (Map.Entry<Long, String> entry : map.entrySet()) {
                    if (entry.getKey().equals(remain)){
                        begin = true;
                    }
                    if (begin){
                        count += entry.getValue().length();
                    }
                }
                int i = 1;
                while (sb.length() - count - i > 0){
                    if (sb.charAt(sb.length() - count - i) == sb.charAt(sb.length()-i)){
                        i++;
                    } else {
                        break;
                    }
                }
                if (i > 1){
                    sb.delete(sb.length() - i + 1, sb.length());
                }
                sb.insert(sb.length() - count, '(');
                sb.append(')');
                break;
            } else {
                sb.append(divide);
            }

            if (map.containsKey(remain)){
                map.remove(remain);
            }
            map.put(remain, divide);
            newNumerator = remain;
        }

        return sb.toString();
    }

    public static void main(String[] args){
        // String s = new Fraction_to_Recurring_Decimal().fractionToDecimal(4, 333);
        String s = new Fraction_to_Recurring_Decimal().fractionToDecimal(-1, -2147483648);
        System.out.println(s);
    }
}
