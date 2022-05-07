package tony.leetcode.feature.bit_operation;

// 只出现一次的数字 变体
// 给定一个整数数组 nums，其中恰好有一个元素只出现一次，其余所有元素均出现两次。
// 这个数组是排好序的，要求复杂度O(logn)

import org.junit.Assert;
import org.junit.Test;

public class Single_Number_X {

    public int singleNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < nums.length -1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else {
                if (mid == 0) {
                    return nums[0];
                } else if (nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void test1() {
        Single_Number_X runner = new Single_Number_X();
        int res1 = runner.singleNumber(new int[]{1, 1, 3, 3, 4, 5, 5});
        Assert.assertEquals(4, res1);

        int res2 = runner.singleNumber(new int[]{1, 2, 2, 3, 3, 5, 5});
        Assert.assertEquals(1, res2);

        int res3 = runner.singleNumber(new int[]{1, 1, 2, 2, 3, 3, 5});
        Assert.assertEquals(5, res3);
    }
}
