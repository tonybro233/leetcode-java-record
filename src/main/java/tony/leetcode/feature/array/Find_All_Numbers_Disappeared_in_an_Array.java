package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.List;

// 448. 找到所有数组中消失的数字
// 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
// 数组中的元素一些出现了两次，另一些只出现一次。
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
// 你可以假定返回的数组不算在额外空间内。
//
// 示例:
// 输入:
// [4,3,2,7,8,2,3,1]
// 输出:
// [5,6]

public class Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length / 2 + 1);
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int judge = nums[val - 1];
            if (judge > 0) {
                nums[val - 1] = -judge;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
