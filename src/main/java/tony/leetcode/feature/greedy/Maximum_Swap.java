package tony.leetcode.feature.greedy;

import java.util.*;

// 670. 最大交换
// 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 :
// 输入: 2736
// 输出: 7236
// 解释: 交换数字2和数字7。

// 示例 2 :
// 输入: 9973
// 输出: 9973
// 解释: 不需要交换。

// 注意:
// 给定数字的范围是 [0, 108]

public class Maximum_Swap {

    public int maximumSwap2(int num) {
        if (num <= 11) {
            return num;
        }
        char[] chars = Integer.toString(num).toCharArray();
        int len = chars.length;
        // 计算当前下标到末尾的最大值
        int[] maxIds = new int[len];
        maxIds[len - 1] = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            // 使用 > 保证取下标最大的大值
            if (chars[i] > chars[maxIds[i + 1]]) {
                maxIds[i] = i;
            } else {
                maxIds[i] = maxIds[i + 1];
            }
        }
        for (int i = 0; i < len - 1; i++) {
            // 发现后面有大值则进行交换，由于前面用了大于号，这里要判断是否相同
            if (maxIds[i] > i && chars[maxIds[i]] > chars[i]) {
                char val = chars[maxIds[i]];
                chars[maxIds[i]] = chars[i];
                chars[i] = val;
                break;
            }
        }

        return Integer.parseInt(new String(chars));
    }

    public int maximumSwap(int num) {
        int[] record = new int[10];
        SortedSet<Integer> treeSet = new TreeSet<>();
        char[] chars = Integer.toString(num).toCharArray();
        int len = chars.length;

        for (char c : chars) {
            record[c - '0']++;
            treeSet.add(c - '0');
        }
        for (int i = 0; i < len - 1;i++){
            int n = chars[i] - '0';
            record[n]--;
            if (record[n] == 0){
                treeSet.remove(n);
            }
            Integer top = treeSet.last();
            if (top > n){
                for (int j = len-1;j > i;j--){
                    if (chars[j] - '0' == top){
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                        return Integer.parseInt(new String(chars));
                    }
                }
            }
        }
        return num;
    }

}
