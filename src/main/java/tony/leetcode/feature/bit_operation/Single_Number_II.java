package tony.leetcode.feature.bit_operation;

// 137. 只出现一次的数字 II
// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
// 找出那个只出现了一次的元素。
//
// 说明：
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
// 输入: [2,2,3,2]
// 输出: 3

// 示例 2:
// 输入: [0,1,0,1,0,1,99]
// 输出: 99

public class Single_Number_II {

    // 这解法...吃不消
    // 对于每一位出现1的次数到3时取0，这样每一位有出0,1,2次3种状态
    // 为了表示3种状态，需要使用两个位计数器，那么每一位都有两个计数器，也就是两个int
    // 00表示1次，01表示1次，10表示2次
    public int singleNumber(int[] nums) {
        // 两个计数器，a高位b低位
        int a = 0, b = 0;
        for (int c : nums) {
            // a = (a & ~b & ~c) + (~a & b & c)
            // b = (~a & ~b & c) + (~a & b & ~c)
            // 简化为如下
            b = ~a & (b ^ c);
            a = ~b & (a ^ c);
        }
        return b;
    }
}
