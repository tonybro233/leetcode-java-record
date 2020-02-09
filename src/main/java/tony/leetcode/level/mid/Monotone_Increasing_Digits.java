package tony.leetcode.level.mid;

import java.util.Deque;
import java.util.LinkedList;

// 738. 单调递增的数字
// 给定一个非负整数 N，找出小于或等于 N 的最大的整数，
// 同时这个整数需要满足其各个位数上的数字是单调递增。
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
// 示例 1:
// 输入: N = 10
// 输出: 9

// 示例 2:
// 输入: N = 1234
// 输出: 1234

// 示例 3:
// 输入: N = 332
// 输出: 299

// 说明: N 是在 [0, 10^9] 范围内的一个整数。

public class Monotone_Increasing_Digits {

    public int monotoneIncreasingDigits(int N) {
        int result = N;
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        do {
            deque.addLast(N % 10);
            N /= 10;
            count++;
        } while (N != 0);

        int[] nums = new int[count];
        int fallbackPos = -1;
        int i = 0;
        nums[i] = deque.pollLast();
        while (!deque.isEmpty()) {
            i++;
            if (fallbackPos == -1) {
                nums[i] = deque.pollLast();
                if (nums[i] < nums[i - 1]) {
                    // 取第一个非递增点
                    fallbackPos = i;
                    // 退一位
                    nums[fallbackPos - 1]--;
                    nums[fallbackPos] = 9;
                }
            } else {
                // 出现退位后必然取9
                nums[i] = 9;
                deque.pollLast();
            }
        }
        if (fallbackPos != -1) {
            // 循环检查退位
            for (i = fallbackPos - 2; i >= 0; i--) {
                if (nums[i] > nums[i + 1]) {
                    nums[i]--;
                    nums[i + 1] = 9;
                }
            }
            result = 0;
            for (int j = 0; j < count; j++) {
                result = result * 10 + nums[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new Monotone_Increasing_Digits().monotoneIncreasingDigits(333332);
        System.out.println(i);
    }
}
