package tony.leetcode.feature.stack;

// 739. 每日温度
// 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
// 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，
// 请在该位置用 0 来代替。
//
// 示例 1:
// 输入: temperatures = [73,74,75,71,69,72,76,73]
// 输出: [1,1,4,2,1,1,0,0]

// 示例 2:
// 输入: temperatures = [30,40,50,60]
// 输出: [1,1,1,0]

// 示例 3:
// 输入: temperatures = [30,60,90]
// 输出: [1,1,0]
//  
// 提示：
// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100

import java.util.Deque;
import java.util.LinkedList;

public class Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (null == temperatures || temperatures.length == 0) {
            return temperatures;
        }
        // 递减单调栈
        // 遇到比栈顶大的弹出栈顶，更新栈顶下标值的结果
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                Integer idx = stack.pollLast();
                res[idx] = i - idx;
            }
            stack.addLast(i);
        }

        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        // 倒序处理
        for (int i = n - 2; i >= 0; i--) {
            // T[j += result[j]]表现为递增
            for (int j = i + 1; j < n; j += result[j]) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }
}
