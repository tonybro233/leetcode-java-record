package tony.leetcode.feature.greedy;

// 334. 递增的三元子序列
// 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
//
// 数学表达式如下:
// 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
// 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。

// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
//
// 示例 1:
// 输入: [1,2,3,4,5]
// 输出: true

// 示例 2:
// 输入: [5,4,3,2,1]
// 输出: false

public class Increasing_Triplet_Subsequence {

    public boolean increasingTriplet2(int[] nums) {
        // 需要给MAX，而不是null
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        if(nums.length < 3){
            return false;
        }
        // 考虑 3,4,1,2的情况可以发现尽管存在中间态：first小于second，但是first下标大于second
        // 但second总是满足前面有一个比他小的，因此只要有大于second，必然满足条件
        for (int num : nums){
            if (first > num){
                first = num;
            } else if (first < num && second > num){
                second = num;
            }else if (num > second){
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2){
            return false;
        }
        boolean[] mark = new boolean[nums.length];
        Integer min = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > min){
                mark[i] = true;
            } else {
                min = nums[i];
            }
        }
        min = null;
        for (int i = 0; i < nums.length; i++){
            if (!mark[i]){
                continue;
            }
            if (min == null){
                min = nums[i];
                continue;
            }
            if (nums[i] > min){
                return true;
            } else {
                min = nums[i];
            }
        }
        return false;
    }

}
