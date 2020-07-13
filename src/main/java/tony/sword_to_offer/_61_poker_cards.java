package tony.sword_to_offer;

// 61. 扑克牌中的顺子
// 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//
// 示例 1:
// 输入: [1,2,3,4,5]
// 输出: True
//
// 示例 2:
// 输入: [0,0,1,2,5]
// 输出: True

import java.util.Arrays;

public class _61_poker_cards {

    // 这他妈的大小王是癞子？？？
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;

        for (int num : nums) {
            if (num != 0) {
                break;
            } else {
                zeros++;
            }
        }

        for (int i = zeros; i < nums.length - 1;i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return nums[nums.length - 1] - nums[zeros] + 1 <= nums.length;
    }

}
