package tony.leetcode.feature.bit_operation;

// 693. 交替位二进制数
// 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
//
// 示例 1:
//
// 输入: 5
// 输出: True
// 解释:
// 5的二进制数是: 101
// 示例 2:
//
// 输入: 7
// 输出: False
// 解释:
// 7的二进制数是: 111

public class Binary_Number_with_Alternating_Bits {

    public boolean hasAlternatingBits(int n) {
        boolean before = (n & 1) != 0;
        n >>= 1;
        while (n > 0){
            boolean now = (n & 1) != 0;
            if ((now && before) || (!now && !before)){
                return false;
            }
            before = now;
            n >>= 1;
        }
        return true;
    }
}
