package tony.leetcode.feature.dynamic_program;

// 416. 分割等和子集
// 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200

// 示例 1:
// 输入: [1, 5, 11, 5]
// 输出: true
// 解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
// 示例 2:
// 输入: [1, 2, 3, 5]
// 输出: false
// 解释: 数组不能分割成两个元素和相等的子集.

public class Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length;i++){
            sum += nums[i];
        }

        // 必须为偶数才可能平分
        if (0 != (sum & 1)) {
            return false;
        }

        sum /= 2;
        int[] dp = new int[sum + 1];

        // 转化为背包问题，dp[i]表示容量为i的背包最多能放的元素之和
        for (int i = 0; i < nums.length; i++) {
            // 从大到小
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        // 半数容量的背包能放的元素之和正好为半数则表示可以对半分
        return dp[sum] == sum;
    }

    // 二维数组的dp解法
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for (int num:nums) {
            sum+= num;
        }
        if(sum % 2 == 1) {
            return false;
        }

        sum /=2;
        int n = nums.length;
        // dp[i][j] 表示 如果我们取前i+1个数字，且背包容量为j的情况下，最多能放入的数字和
        int dp[][]=new int[n][sum + 1];
        // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
        for(int i=nums[0];i<=sum;i++){
            dp[0][i] = nums[0];
        }
        //遍历n个数字，即视为n个产品
        for(int i=1;i < n;i++){
            //加入了这种物品后更新状态
            for(int j = nums[i];j <= sum;j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
            }
        }
        //放满了才能表示正好1/2
        return dp[n - 1][sum] == sum;
    }

    public static void main(String[] args){
        boolean b = new Partition_Equal_Subset_Sum().canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }
}
