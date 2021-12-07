package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.List;

// 442. 数组中重复的数据
// 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
// 找到所有出现两次的元素。
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
//
// 示例：
// 输入:
// [4,3,2,7,8,2,3,1]
//
// 输出:
// [2,3]

public class Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {
        if (nums.length < 2) {
            return new ArrayList<>();
        }
        // 注意审题，直接用正负来复用数组
        List<Integer> result = new ArrayList<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                result.add(Math.abs(nums[i]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = new Find_All_Duplicates_in_an_Array().findDuplicates(new int[]{2, 2, 4});
        System.out.println(duplicates);
    }
}
