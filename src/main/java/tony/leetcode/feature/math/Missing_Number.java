package tony.leetcode.feature.math;


import java.util.HashSet;
import java.util.Set;

// 268 缺失数字
//  给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
// 示例 1:
// 输入: [3,0,1]
// 输出: 2

// 示例 2:
// 输入: [9,6,4,2,3,5,7,0,1]
// 输出: 8

// 说明:
// 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

public class Missing_Number {

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = (1+n)*n/2;
        for (int i = 0; i < n;i++){
            sum -= nums[i];
        }

        return sum;
    }

    // 哎，瓜皮
    public int missingNumber(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length;i++){
            record.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++){
            if (!record.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
