package tony.leetcode.feature.greedy;

// 376. 摆动序列
// 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
// 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
//
// 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
// 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
// 第二个序列是因为它的最后一个差值为零。
//
// 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
// 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

// 示例 1:
// 输入: [1,7,4,9,2,5]
// 输出: 6
// 解释: 整个序列均为摆动序列。

// 示例 2:
// 输入: [1,17,5,10,13,15,10,5,16,8]
// 输出: 7
// 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。

// 示例 3:
// 输入: [1,2,3,4,5,6,7,8,9]
// 输出: 2

// 进阶:
// 你能否用 O(n) 时间复杂度完成此题?

public class Wiggle_Subsequence {

    public int wiggleMaxLength(int[] nums) {
        // 贪心。连续的递增取最后一个值，中间值舍弃，连续递减也是一样。
        // 这种题就是容易陷入思想误区，觉得删除元素会导致摆动变化，但其实第一个数是可以必选的

        if (nums.length < 2) {
            return nums.length;
        }
        int delta = nums[1] - nums[0];
        int result = delta == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int newDelta = nums[i] - nums[i - 1];
            if ((delta == 0 && newDelta != 0) || newDelta * delta < 0) {
                result++;
                delta = newDelta;
            }
            // 注意这个赋值不能放在这里，因为可能存在平顶的情况，delta要保持原来的正值或者负值
            //   ___/
            //  /

            // delta = newDelta
        }
        return result;
    }

    // 动态规划的解法
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] n = new int[nums.length]; // 从递减开始的最大序列
        int[] p = new int[nums.length]; // 从递增开始的最大序列
        n[0] = 1;
        p[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                p[i] = n[i - 1] + 1;
                n[i] = n[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                n[i] = p[i - 1] + 1;
                p[i] = p[i - 1];
            } else {
                n[i] = n[i - 1];
                p[i] = p[i - 1];
            }
        }
        return Math.max(n[nums.length - 1], p[nums.length - 1]);
    }

    public static void main(String[] args){
        int i = new Wiggle_Subsequence().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        System.out.println(i);
    }
}
