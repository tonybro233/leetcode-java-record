package tony.leetcode.feature.stack;

import java.util.Deque;
import java.util.LinkedList;

// 907. 子数组的最小值之和
// 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
//
// 由于答案可能很大，因此返回答案模 10^9 + 7。
//
// 示例：
// 输入：[3,1,2,4]
// 输出：17
// 解释：
// 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
// 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
//
// 提示：
// 1 <= A <= 30000
// 1 <= A[i] <= 30000

public class Sum_of_Subarray_Minimums {

    public int sumSubarrayMins(int[] A) {
        final int MOD = (int)(1e9) + 7;
        int len = A.length;
        int[] left = new int[len], right = new int[len];
        Deque<Integer> s1 = new LinkedList<>(), s2 = new LinkedList<>();
        for(int i = 0; i < len; i++){
            while (null != s1.peek() && A[s1.peek()] > A[i]){
                s1.pop();
            }
            // left[i]：A[i]左边严格大于A[i]的个数 + 1
            left[i] = null == s1.peek() ? i + 1: i - s1.peek();
            s1.push(i);

            int j = len - 1 - i;
            while (null != s2.peek() && A[s2.peek()] >= A[j]){
                s2.pop();
            }
            // right[i]：A[i]右边大于等于A[i]的个数 + 1， 注意一个大于，一个大于等于
            right[i] = null == s2.peek() ? len - j : s2.peek() - j;
            s2.push(j);
        }
        int ans = 0;
        for(int i = 0; i < len; i++){
            // left[i] * right[i] 就等于以A[i]为最小值的子数组数量
            ans += (left[i] * right[i]) % MOD * A[i];
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args){
        int i = new Sum_of_Subarray_Minimums().sumSubarrayMins(new int[]{3, 1, 2, 4});
        System.out.println(i);
    }
}
