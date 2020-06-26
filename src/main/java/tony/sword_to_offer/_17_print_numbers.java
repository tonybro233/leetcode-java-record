package tony.sword_to_offer;

// 17. 打印从1到最大的n位数
// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
// 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
// 输入: n = 1
// 输出: [1,2,3,4,5,6,7,8,9]
//  
//
// 说明：
// 用返回一个整数列表来代替打印
// n 为正整数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_print_numbers {

    // leetcode 返回int[] 会使题目毫无意义
    public List<String> printNumbers(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        char[] value = new char[n];
        int idx = n - 1;
        Arrays.fill(value, '0');
        value[idx] = '1';

        while (idx >= 0) {
            result.add(new String(value, idx, n - idx));
            idx = addOne(value, idx);
        }

        return result;
    }

    private int addOne(char[] value, int idx) {
        int i = value.length - 1;
        while (i >= idx) {
            if (value[i] == '9') {
                value[i] = '0';
            } else {
                value[i] ++;
                break;
            }
            i--;
        }
        if (i < idx && i >= 0) {
            value[i] = '1';
        }
        return Math.min(idx, i);
    }

}
