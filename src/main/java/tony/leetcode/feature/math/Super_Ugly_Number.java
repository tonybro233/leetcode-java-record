package tony.leetcode.feature.math;

// 313. 超级丑数
// 编写一段程序来查找第 n 个超级丑数。
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
//
// 示例:
// 输入: n = 12, primes = [2,7,13,19]
// 输出: 32
// 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，
// 前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。

// 说明:
// 1 是任何给定 primes 的超级丑数。
//  给定 primes 中的数字以升序排列。
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
// 第 n 个超级丑数确保在 32 位有符整数范围内。

public class Super_Ugly_Number {

    // 为每个质数维护一个指针，数值为丑数数组的下标，每个子循环比较 ugly[pointer[j]]和 primes[j]的最小值
    public int nthSuperUglyNumbe2r(int n, int[] primes) {
        int[] pointer = new int[primes.length]; // 指针数组
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < primes.length; j++){
                if(ugly[pointer[j]] * primes[j] < min){
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                } else if(ugly[pointer[j]] * primes[j] == min){
                    pointer[j]++;
                }
            }
            ugly[i] = min;
            pointer[minIndex]++;
        }
        return ugly[n - 1];
    }

    // 暴力解法超时
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (primes == null || primes.length == 0){
            return 0;
        }
        int current = 0;
        while (n > 0){
            current++;
            if (match(current, primes)){
                System.out.println(current);
                n--;
            }
        }
        return current;
    }

    private boolean match(int input, int[] primes){
        while (true){
            boolean got = false;
            for (int ea : primes){
                if (input / ea * ea == input){
                    input /= ea;
                    got = true;
                }
                if (input == 1){
                    return true;
                }
            }
            if (!got){
                return false;
            }
        }
    }

    public static void main(String[] args){
        new Super_Ugly_Number().nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}
