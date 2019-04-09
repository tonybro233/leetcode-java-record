package tony.leetcode.feature.binary_search;

// 154. 寻找旋转排序数组中的最小值 II
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 注意数组中可能存在重复的元素。
//
// 示例 1：
// 输入: [1,3,5]
// 输出: 1

// 示例 2：
// 输入: [2,2,2,0,1]
// 输出: 0

// 说明：
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

public class Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            // 使用上界来处理
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
