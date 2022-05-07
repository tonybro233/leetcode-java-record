package tony.leetcode.feature.dynamic_program;

// 718. 最长重复子数组
// 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
// 示例 1:
//
// 输入:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// 输出: 3
// 解释:
// 长度最长的公共子数组是 [3, 2, 1]。
// 说明:
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100

public class Maximum_Length_of_Repeated_Subarray {

    public int findLength(int[] A, int[] B) {
        int la = A.length;
        int lb = B.length;
        int result = 0;

        // D[i][j]表示以A[i-1]和B[j-1]结尾的最长公共子数组的长度
        int[][] D = new int[la + 1][lb + 1];

        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if (A[i - 1] == B[j - 1]) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                    result = Math.max(result, D[i][j]);
                }
            }
        }

        return result;
    }


    public int findLength2(int[] nums1, int[] nums2) {
        // 对齐两个数组然后获取最大的子数组
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            result = Math.max(result, maxLen(nums1, i, nums2, 0));
        }
        for (int i = 0; i < nums2.length; i++) {
            result = Math.max(result, maxLen(nums1, 0, nums2, i));
        }
        return result;
    }

    private int maxLen(int[] A, int sa, int[] B, int sb) {
        int res = 0;
        int k = 0;
        int incr = 0;
        while (A.length > sa + incr && B.length > sb + incr) {
            if (A[sa + incr] == B[sb + incr]) {
                k++;
            } else {
                k = 0;
            }
            res = Math.max(res, k);
            incr++;
        }
        return res;
    }

}
