package tony.leetcode.feature.array;

// 16. 最接近的三数之和
// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
// 找出 nums 中的三个整数，使得它们的和与 target 最接近。
// 返回这三个数的和。假定每组输入只存在唯一答案。
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
// 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

public class _3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        Integer result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            int one = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int current = one + nums[left] + nums[right];
                if (Math.abs(target-current) < Math.abs(target - result)){
                    result = current;
                }
                if (current < target){
                    left++;
                } else if (current > target){
                    right--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int i = new _3Sum_Closest().threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1);
        System.out.println(i);
    }
}
