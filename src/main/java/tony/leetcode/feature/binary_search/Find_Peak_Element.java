package tony.leetcode.feature.binary_search;

// 162
// 峰值元素是指其值大于左右相邻值的元素。
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
// 你可以假设 nums[-1] = nums[n] = -∞。

// 你的解法应该是 O(logN) 时间复杂度的。

public class Find_Peak_Element {

    /**
     * 因为边界是负无穷，所以如果一个值大于右值则左边一定有一个峰值，反之右边一定有个峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int min=0, max=nums.length-1;
        while (min < max) {
            int mid = (min + max)/2;
            if (nums[mid] > nums[mid+1]) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
