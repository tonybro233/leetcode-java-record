package tony.leetcode.feature.math;

// 365. 水壶问题
// 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
// 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
//
// 你允许：
// 装满任意一个水壶
// 清空任意一个水壶
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空

// 示例 1: (From the famous "Die Hard" example)
// 输入: x = 3, y = 5, z = 4
// 输出: True

// 示例 2:
// 输入: x = 2, y = 6, z = 5
// 输出: False
public class Water_and_Jug_Problem {

    // z是x，y最大公约数的倍数即可
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x+y){
            return false;
        }
        if (z == 0){
            return true; // 倒空
        }
        if (y == 0){
            // 不能对0取余
            return x == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}
