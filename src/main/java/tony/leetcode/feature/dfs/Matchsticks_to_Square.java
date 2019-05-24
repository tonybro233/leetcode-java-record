package tony.leetcode.feature.dfs;

// 473. 火柴拼正方形
// 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，
// 请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，
// 可以把火柴连接起来，并且每根火柴都要用到。
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
//
// 示例 1:
// 输入: [1,1,2,2,2]
// 输出: true
//
// 解释: 能拼成一个边长为2的正方形，每边两根火柴。

// 示例 2:
// 输入: [3,3,3,3,4]
// 输出: false
//
// 解释: 不能用所有火柴拼成一个正方形。

// 注意:
// 给定的火柴长度和在 0 到 10^9之间。
// 火柴数组的长度不超过15。
// 在真实的面试中遇到过这道题？

import java.util.Arrays;

public class Matchsticks_to_Square {

    public boolean makesquare2(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0;i < nums.length;i++) {
            sum += nums[i];
        }
        if(sum % 4 != 0) {
            return false;
        }
        // 排序之后，从大值开始匹配，保证小值可以组成边
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];

        // 拆成4次dfs
        for(int i = 0;i < 4;i++){
            if(!dfs(nums,flag,nums.length -1,sum/4)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[] nums,boolean[] flag,int cursor,int target){
        if(target == 0){
            return true;
        }
        for(int i = cursor;i >= 0;i--){
            if(!flag[i]){
                if (target-nums[i] < 0) {
                    continue;
                }
                flag[i] = true;
                if(dfs(nums,flag,i-1,target-nums[i])){
                    return true;
                }
                flag[i] = false;
            }
        }
        return false;
    }

    // 超时解法
    public boolean makesquare(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return false;
        }
        int avg = 0;
        for (int i = 0; i < n; i++){
            avg += nums[i];
        }
        if (0 != avg % 4){
            return false;
        }
        avg /= 4;

        return dfs(nums, 0, 0, 0, 0, 0, avg);
    }

    private boolean dfs(int[] nums, int cursor, int left, int right, int top, int bottom, int avg){
        if (cursor == nums.length){
            return left == right && left == top && left == bottom;
        }
        if (left > avg || right > avg || top > avg || bottom > avg){
            return false;
        }
        int val = nums[cursor];
        if (dfs(nums, cursor+1, left+val, right, top, bottom, avg)){
            return true;
        }
        if (dfs(nums, cursor+1, left, right+val, top, bottom,avg)){
            return true;
        }
        if (dfs(nums, cursor+1, left, right, top+val, bottom,avg)){
            return true;
        }
        if (dfs(nums, cursor+1, left, right, top, bottom+val,avg)){
            return true;
        }

        return false;
    }
}
