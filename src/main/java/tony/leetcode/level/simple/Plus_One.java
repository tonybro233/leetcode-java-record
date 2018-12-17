package tony.leetcode.level.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 66 加一
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
// 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
// 输入: [1,2,3]
// 输出: [1,2,4]
// 解释: 输入数组表示数字 123。

// 示例 2:
// 输入: [4,3,2,1]
// 输出: [4,3,2,2]
// 解释: 输入数组表示数字 4321。

public class Plus_One {

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>(digits.length+1);
        int left = 1;
        for (int i = digits.length -1 ; i >= 0;i--){
            int val = digits[i] + left;
            if (val > 9){
                left = val / 10;
                val %= 10;
            } else {
                left = 0;
            }
            list.add(val);
        }
        if (left > 0){
            list.add(left);
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
