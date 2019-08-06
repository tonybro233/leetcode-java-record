package tony.leetcode.feature.math;

// 264. 丑数 II
// 编写一个程序，找出第 n 个丑数。
// 丑数就是只包含质因数 2, 3, 5 的正整数。
//
// 示例:
// 输入: n = 10
// 输出: 12
// 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

// 说明:  
// 1 是丑数。
// n 不超过1690。

public class Ugly_Number_II {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int idx2 = 0, idx3 = 0, idx5 = 0;
        for(int i = 1; i < n; i++){
            // 执行到这里时，这几个idx必然小于i
            // 表现为第i个丑数必然是 第idx2个丑数*2、第idx3个丑数*3、第idx5个丑数*5
            int min = Integer.MAX_VALUE;
            min = Math.min(ugly[idx2] * 2, min);
            min = Math.min(ugly[idx3] * 3, min);
            min = Math.min(ugly[idx5] * 5, min);

            // 产生第i个丑数
            ugly[i] = min;

            // 如果是第idx2个丑数*2产生了当前的丑数，那么下一个丑数起码是第(idx2+1)个丑数*2
            // 所以idx2++
            if (min == ugly[idx2] * 2){
                idx2++;
            }
            if (min == ugly[idx3] * 3){
                idx3++;
            }
            if (min == ugly[idx5] * 5){
                idx5++;
            }
        }


        return ugly[n-1];
    }
}
