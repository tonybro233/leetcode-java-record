package tony.leetcode.feature.stack;

// 402. 移掉 K 位数字
// 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
// 请你以字符串形式返回这个最小的数字。
//
// 示例 1 ：
// 输入：num = "1432219", k = 3
// 输出："1219"
// 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。

// 示例 2 ：
// 输入：num = "10200", k = 1
// 输出："200"
// 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

// 示例 3 ：
// 输入：num = "10", k = 2
// 输出："0"
// 解释：从原数字移除所有的数字，剩余为空就是 0 。
//  
//
// 提示：
// 1 <= k <= num.length <= 105
// num 仅由若干位数字（0 - 9）组成
// 除了 0 本身之外，num 不含任何前导零

public class Remove_K_Digits {

    public String removeKdigits(String num, int k) {
        // 这不刷过能想出来？
        // 移除的逻辑可以使用单调栈来归纳描述
        // 要使得数字最小，首先，左边的数字影响力比右边大，所以可以从左到右扫描
        // 其次，移除掉一个数后，该数后面的数将会补位，如果数字递增，则显然应该移除最后一个数
        // 如果数字不递增，则应该移除非递增开始的第一个数，比如 1 4 3 , 应该移除4而不是1或者3
        // 这恰好就是单调栈的性质
        if (k == 0) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(num.charAt(i));
        }
        while (k > 0 && sb.length() > 0) {
            k--;
            sb.deleteCharAt(sb.length() - 1);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return "0";
        }
    }

}
