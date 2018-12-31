package tony.leetcode.feature.hash;

import java.util.HashMap;
import java.util.Map;

// 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组。

// 输入: [0,1,0]
// 输出: 2
// 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。

public class Contiguous_Array {

    public int findMaxLength(int[] nums) {
        // 把0替换为-1，这样可以根据求和进行处理
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        // 这里很骚
        // 获取每种sum的最小角标，如果发现sum，则从最小角标到当前角标的这一段子数组的和为0
        // 注意0的最小角标是-1
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length;i++){
            sum += nums[i];
            if (map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
        return max;
    }
}
