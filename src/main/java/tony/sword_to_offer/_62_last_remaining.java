package tony.sword_to_offer;

// 62. 圆圈中最后剩下的数字
// 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
// 求出这个圆圈里剩下的最后一个数字。
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
// 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

public class _62_last_remaining {

    /**
     * 以n = 5, m = 3 为例
     * 0 1 2 3 4 |
     * 3 4 | 0 1 3 4
     * 1 3 4 | 1 3
     * 1 3 | 1 3
     * 3
     *
     * 观察3在每一步中的位置，最后的位置一定是0 (剩下的最后一个数字)
     * 从后往前查看规律：向前移动3位, 然后对上一轮数字个数取余 即可的出3在上一轮中的位置
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}