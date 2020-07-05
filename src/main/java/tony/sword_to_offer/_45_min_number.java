package tony.sword_to_offer;

// 45. 把数组排成最小的数
// 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 示例 1:
// 输入: [10,2]
// 输出: "102"

// 示例 2:
// 输入: [3,30,34,5,9]
// 输出: "3033459"

import java.util.Arrays;

public class _45_min_number {

    public String minNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "";
        }
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length;i++) {
            ss[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(ss, (a, b) -> (a + b).compareTo(b + a));
        return String.join("", ss);
    }

}
