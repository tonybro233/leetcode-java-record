package tony.sword_to_offer;

// 56 - II. 数组中唯一只出现一次的数字
// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
// 示例 1：
// 输入：nums = [3,4,3,3]
// 输出：4

// 示例 2：
// 输入：nums = [9,1,7,9,7,9,7]
// 输出：1

public class _56_2_single_number {

    /**
     * 高级些的解法见{@link tony.leetcode.feature.bit_operation.Single_Number_II}
     */
    public int singleNumber(int[] nums) {
        int[] help = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num & (1 << i)) != 0 ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (1 << i) * (help[i] % 3);
        }
        return res;
    }


    public int singleNumber2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & mask) > 0) {
                    count++;
                }
            }
            if (count % 3 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            mask <<= 1;
        }
        return Integer.valueOf(sb.reverse().toString(), 2);
    }

}
