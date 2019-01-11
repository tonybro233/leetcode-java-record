package tony.leetcode.level.mid;

// 33. 搜索旋转排序数组
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
// 输入: nums = [4,5,6,7,0,1,2], target = 0
// 输出: 4

// 示例 2:
// 输入: nums = [4,5,6,7,0,1,2], target = 3
// 输出: -1

import java.util.Arrays;

public class Search_in_Rotated_Sorted_Array {

    public int search2(int[] nums, int target) {
        if(nums.length == 1 && target == nums[0]){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (target == nums[left]){
                return left;
            }
            if (target == nums[right]){
                return right;
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target > nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if (target > nums[mid]) {
                    if (target < nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int lo, int hi){
        if (lo > hi){
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (nums[mid] >= nums[lo]){
            // mid左边有序
            int i = Arrays.binarySearch(nums, lo,mid+1, target);
            if (i >= 0){
                return i;
            }
            i = search(nums, target, mid + 1, hi);
            if (i >= 0){
                return i;
            } else{
                return -1;
            }
        } else {
            // mid右边有序
            int i = Arrays.binarySearch(nums, mid , hi+1, target);
            if (i >= 0){
                return i;
            }
            i = search(nums, target, lo, mid - 1);
            if (i >= 0){
                return i;
            } else{
                return -1;
            }
        }
    }

    public static void main(String[] args){
        int search = new Search_in_Rotated_Sorted_Array().search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println(search);
    }
}
