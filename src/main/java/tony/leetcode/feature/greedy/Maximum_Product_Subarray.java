package tony.leetcode.feature.greedy;

// 152. 乘积最大子序列
// 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
// 示例 1:
// 输入: [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。

// 示例 2:
// 输入: [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

public class Maximum_Product_Subarray {

    public int maxProduct2(int[] nums) {
        // 类似最大子数组的和这类动态规划
        // 考虑以i结尾的最大乘积，则以i+1结尾的最大乘积只与以i结尾的最大乘积和最小乘积相关
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mm = min;
            max = Math.max(nums[i], Math.max(mx * nums[i], mm * nums[i]));
            min = Math.min(nums[i], Math.min(mx * nums[i], mm * nums[i]));

            result = Math.max(result, max);
        }

        return result;
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            // 计算以第i个数为结尾的连续数组的最大乘积和最小乘积
            if (nums[i] < 0) {
                //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        new Maximum_Product_Subarray().maxProduct(new int[]{2, -5, -2, -4, 3});
    }
}
