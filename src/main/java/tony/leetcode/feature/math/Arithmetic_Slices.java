package tony.leetcode.feature.math;

import java.util.ArrayList;
import java.util.List;

// 413. 等差数列划分
// 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
// 例如，以下数列为等差数列:
// 1, 3, 5, 7, 9
// 7, 7, 7, 7
// 3, -1, -5, -9
// 以下数列不是等差数列。
// 1, 1, 2, 5, 7

// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
// 如果满足以下条件，则称子数组(P, Q)为等差数组：
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
// 函数要返回数组 A 中所有为等差数组的子数组个数。

// 示例:
//
// A = [1, 2, 3, 4]
// 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。

public class Arithmetic_Slices {

    public int numberOfArithmeticSlices2(int[] A) {
        int ans = 0;
        if(A.length<3) {
            return ans;
        }
        for (int i = 0; i < A.length - 2; i++){
            if (A[i+2]-A[i+1] == A[i+1]-A[i]){
                ans++;
                for (int j = i+3; j <A.length ; j++){
                    if (A[j]-A[j-1]==A[j-1]-A[j-2]){
                        ans++;
                    } else {
                        break;
                    }
                }
            }

        }
        return ans;
    }

    public int numberOfArithmeticSlices(int[] A) {
        List<List<Integer>> record = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int gap = 0;

        // 求出所有个数大于3的等差数列
        for (int i = 0; i < A.length; i++){
            int val = A[i];
            if (current.size() == 0){
                current.add(val);
            } else if (current.size() == 1) {
                current.add(val);
                gap = current.get(1) - current.get(0);
            } else {
                if (val - current.get(current.size() - 1) == gap){
                    current.add(val);
                } else {
                    if (current.size() > 2){
                        record.add(current);
                        current = new ArrayList<>();
                        current.add(val);
                    } else {
                        int last = current.get(current.size() - 1);
                        current = new ArrayList<>();
                        current.add(last);
                        current.add(val);
                        gap = val - last;
                    }
                }
            }
        }
        if (current.size() > 2){
            record.add(current);
        }

        int result = 0;
        // 求出每个等差数列的子等差数列（1+2+...+n-2）
        for (List<Integer> slice : record){
            int each = (1+ slice.size()-2)*(slice.size()-2)/2;
            result += each;
        }


        return result;
    }
}
