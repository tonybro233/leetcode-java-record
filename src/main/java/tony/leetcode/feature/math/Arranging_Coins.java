package tony.leetcode.feature.math;

// 441
// 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
// 给定一个数字 n，找出可形成完整阶梯行的总行数。
// n 是一个非负整数，并且在32位有符号整型的范围内。

// n = 8
//
// 硬币可排列成以下几行:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
//
// 因为第四行不完整，所以返回3.

public class Arranging_Coins {

    public static void main(String[] args){
        int i = new Arranging_Coins().arrangeCoins(1804289383);
        System.out.println(i);
        System.out.println(Math.sqrt(14434315064L));
    }

    /**
     * 利用零点公式计算，要注意int超界问题
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        long nn = n;
        return (int)((Math.sqrt(1+8*nn) - 1)/2);
    }
}
