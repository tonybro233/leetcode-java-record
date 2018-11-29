package tony.leetcode.feature.math;

import java.util.ArrayList;
import java.util.List;

// 204 计数质数
// 统计所有小于非负整数 n 的质数的数量。
//
// 示例:
//
// 输入: 10
// 输出: 4
// 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

public class Count_Primes {

    // 埃拉托斯特尼筛法，去除质数所有的倍数
    public int countPrimes(int n) {
        boolean[] record = new boolean[n+1];
        record[0] = record[1] = true;
        for (int i = 2; i * i < n;i++){
            if (!record[i]){
                int c = i*i; // 由于是从小到大执行执行, i*1 i*2 ··· i*(i-1) 一定被标记过
                while (c < n) {
                    record[c] = true;
                    c += i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!record[i]) {
                ans ++;
            }
        }
        return ans;
    }

    // 超时解法
    public int countPrimes2(int n) {
        List<Integer> record = new ArrayList<>();
        for (int i = 2; i < n; i++){
            boolean isPrime = true;
            for (int j = 0;j < record.size();i++){
                int ea = record.get(i);
                if (i/ea * ea == i){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                record.add(i);
            }
        }
        return record.size();
    }
}
