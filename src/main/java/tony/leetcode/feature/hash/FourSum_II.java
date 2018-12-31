package tony.leetcode.feature.hash;

import java.util.HashMap;
import java.util.Map;

// 454
// 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
// 使得 A[i] + B[j] + C[k] + D[l] = 0。
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
// 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

public class FourSum_II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A){
            for (int b : B){
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum,0) + 1);
            }
        }

        int res = 0;
        for (int c : C){
            for (int d : D ){
                int sum = c + d;
                res += map.getOrDefault(-1*sum,0);
            }
        }

        return res;
    }
}
