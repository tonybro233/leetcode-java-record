package tony.leetcode.feature.linkedlist;

// 287. 寻找重复数
// 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
// 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//
// 示例 1:
// 输入: [1,3,4,2,2]
// 输出: 2

// 示例 2:
// 输入: [3,1,3,4,2]
// 输出: 3

// 说明：
// 不能更改原数组（假设数组是只读的）。
// 只能使用额外的 O(1) 的空间。
// 时间复杂度小于 O(n2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。

public class Find_the_Duplicate_Number {

    // 这题确实想不到这样的解法
    public int findDuplicate(int[] nums) {
        // 将数组看做链表(限定条件下不会越界)，使用快慢指针思想
        // 有重复元素则必有环，找到环的入口即是重复元素(为何?)
        // 按照寻找链表环入口的思想进行处理
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args){
        int duplicate = new Find_the_Duplicate_Number().findDuplicate(new int[]{1, 3, 4, 2, 3});
        System.out.println(duplicate);
    }
}
