package tony.leetcode.feature.array.double_pointer;

// 88. 合并两个有序数组
// 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

// 示例:
// 输入:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3=
// 输出: [1,2,2,3,5,6]

public class Merge_Sorted_Array {

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        // 从大到小排
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = nums1.length;
        // 先把nums1中的内容移到最后
        for (int i = 0; i < m; i++){
            nums1[t-1-i] = nums1[m-1-i];
        }
        // 挨个置入
        int i = t-m, j = 0, cursor = 0;
        while (i < t || j < n){
            if (i == t){
                nums1[cursor++] = nums2[j++];
            } else if (j == n){
                nums1[cursor++] = nums1[i++];
            } else {
                if (nums2[j] > nums1[i]){
                    nums1[cursor++] = nums1[i++];
                } else {
                    nums1[cursor++] = nums2[j++];
                }
            }
        }
    }
}
