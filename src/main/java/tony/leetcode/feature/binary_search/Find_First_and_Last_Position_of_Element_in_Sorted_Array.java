package tony.leetcode.feature.binary_search;

import java.util.Arrays;

// 34. 在排序数组中查找元素的第一个和最后一个位置
// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: [3,4]

// 示例 2:
// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: [-1,-1]

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0, right = nums.length - 1;
        boolean got = false;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                got = true;
                if (nums[left] < target){
                    left++;
                }
                if (nums[right] > target){
                    right--;
                }
                if (nums[left] == target && nums[right] == target){
                    break;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (got) {
            result[0] = left;
            result[1] = right;
        }

        return result;
    }

    public static void main(String[] args){
        int[] ints = new Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}, 8
        );
        System.out.println(Arrays.toString(ints));
    }
}
