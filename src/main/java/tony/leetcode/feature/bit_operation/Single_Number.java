package tony.leetcode.feature.bit_operation;

public class Single_Number {

    // 136
    // 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
    // 找出那个只出现了一次的元素。
    // 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？


    /**
     * 0异或任何数  = 任何数
     * 1异或任何数  = 任何数取反
     * 任何数异或自己 = 把自己置0
     * 运算结果与顺序无关
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int aA : A) {
            rst ^= aA;
        }
        return rst;
    }
}
