package tony.leetcode.feature.array;

// 4 两个排序数组的中位数

// 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
// 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
// 你可以假设 nums1 和 nums2 不同时为空。

// 示例 2:
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// 中位数是 (2 + 3)/2 = 2.5

public class Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int v1 = 0, v2 = 0, v = 0;
        int p1 = 0, p2 = 0;
        if (sum % 2 == 0) {
            int mid1 = sum / 2;
            int mid2 = mid1 - 1;
            for (int i = 0; i <= mid1; i++) {
                if (p1 == nums1.length) {
                    v = nums2[p2++];
                } else if (p2 == nums2.length) {
                    v = nums1[p1++];
                } else if (nums1[p1] > nums2[p2]) {
                    v = nums2[p2++];
                } else {
                    v = nums1[p1++];
                }
                if (i == mid2) {
                    v2 = v;
                }
            }
            v1 = v;
            return (v1 + v2) / 2.0;
        } else {
            int mid1 = sum / 2;
            for (int i = 0; i <= mid1; i++) {
                if (p1 == nums1.length) {
                    v = nums2[p2++];
                } else if (p2 == nums2.length) {
                    v = nums1[p1++];
                } else if (nums1[p1] > nums2[p2]) {
                    v = nums2[p2++];
                } else {
                    v = nums1[p1++];
                }
            }
            return v;
        }
    }

    // 符合时间复杂度
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        // 保证num1是更短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len = nums1.length + nums2.length;

        // 如果num1是空的，直接取num2
        if (nums1.length == 0) {
            if (len % 2 == 0) {
                return (nums2[len / 2 - 1] + nums2[len / 2]) / 2.0;
            } else {
                return nums2[len / 2];
            }
        }

        // 中位数可以把一组数分成两段长度相差小于等于1的部分(前一段>=后一段)
        // 在本题中，每一段可以分别由两个数组提供
        // 针对前一段，如果从nums1取n个，则nums2取m个，n+m值是可以确定的
        // 此时由于中位数的性质，nums1提供的n个数字的最大值必须小于等于nums1的后段最小值、
        // 小于等于nums2的后段最小值，第一个条件是直接成立的，nums2同理
        // 所以设nums1前一段的最大值为L1，后一段最小值为R1，nums2的为L2、R2
        // 必须满足R1 <= L2 and R2 <= L1
        // 这样R1的取值就可以用二分查找

        // num1做二分
        int low = 0, high = nums1.length; // 这里high取的是length
        int leftCount1 = 0, leftCount2 = 0;
        while (low <= high) {
            leftCount1 = low + (high - low) / 2;
            leftCount2 = (len + 1) / 2 - leftCount1;

            double L1 = leftCount1 == 0 ? Integer.MIN_VALUE : nums1[leftCount1 - 1];
            double R1 = leftCount1 == nums1.length ? Integer.MAX_VALUE : nums1[leftCount1];
            double L2 = leftCount2 == 0 ? Integer.MIN_VALUE : nums2[leftCount2 - 1];
            double R2 = leftCount2 == nums2.length ? Integer.MAX_VALUE : nums2[leftCount2];

            if (L1 > R2) {
                high = leftCount1 - 1;
            } else if (L2 > R1) {
                low = leftCount1 + 1;
            } else {
                if (len % 2 == 0) {
                    // 偶数
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    // 奇数
                    return Math.max(L1, L2);
                }
            }
        }
        return 0;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int b1 = nums1.length % 2 == 0 ? 2 : 1; // 偶数取2个值
        int b2 = nums2.length % 2 == 0 ? 2 : 1;

        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        if (nums1[l1 - 1] <= nums2[0]) {
            if (sum % 2 == 0) {
                int mid1 = sum / 2;
                int mid2 = sum / 2 - 1;
                return ((mid1 >= l1 ? nums2[mid1 - l1] : nums1[mid1]) + (mid2 >= l1 ? nums2[mid2 - l1] : nums1[mid2])) / 2.0;
            } else {
                int mid = sum / 2;
                return mid >= l1 ? nums2[mid - l1] : nums1[mid];
            }
        } else if (nums2[l2 - 1] <= nums1[0]) {
            if (sum % 2 == 0) {
                int mid1 = sum / 2;
                int mid2 = sum / 2 - 1;
                return ((mid1 >= l1 ? nums1[mid1 - l1] : nums2[mid1]) + (mid2 >= l1 ? nums1[mid2 - l1] : nums2[mid2])) / 2.0;
            } else {
                int mid = sum / 2;
                return mid >= l1 ? nums1[mid - l1] : nums2[mid];
            }
        } else {
            int min1 = nums2[0];
            int cross = 0;
            for (int i : nums2) {
                if (i <= min1)
                    cross++;
                else
                    break;
            }
            if (sum % 2 == 0) {
                int mid1 = sum / 2;
                int mid2 = sum / 2 - 1;
            } else {

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays go = new Median_of_Two_Sorted_Arrays();
        //go.findMedianSortedArrays();
    }
}
