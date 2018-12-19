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
        int sum  = nums1.length + nums2.length;
        int v1 = 0, v2 = 0, v = 0;
        int p1 = 0,p2 = 0;
        if (sum % 2 ==0){
            int mid1 = sum / 2;
            int mid2 = mid1 - 1;
            for (int i = 0 ; i <= mid1;i++){
                if (p1 == nums1.length){
                    v = nums2[p2++];
                }
                else if (p2 == nums2.length){
                    v = nums1[p1++];
                }
                else if (nums1[p1] > nums2[p2]){
                    v = nums2[p2++];
                }
                else{
                    v = nums1[p1++];
                }
                if (i == mid2) {
                    v2 = v;
                }
            }
            v1 = v;
            return (v1 + v2)/2.0;
        }
        else{
            int mid1 = sum / 2;
            for (int i = 0 ; i <= mid1;i++){
                if (p1 == nums1.length){
                    v = nums2[p2++];
                }
                else if (p2 == nums2.length){
                    v = nums1[p1++];
                }
                else if (nums1[p1] > nums2[p2]){
                    v = nums2[p2++];
                }
                else{
                    v = nums1[p1++];
                }
            }
            return v;
        }
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int b1 = nums1.length % 2 == 0 ? 2 : 1 ; // 偶数取2个值
        int b2 = nums2.length % 2 == 0 ? 2 : 1;

        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;
        if (nums1[l1-1] <= nums2[0]){
            if (sum % 2 == 0){
                int mid1 = sum / 2 ;
                int mid2 = sum / 2 -1 ;
                return ((mid1 >= l1 ? nums2[mid1-l1] : nums1[mid1]) + (mid2 >= l1 ? nums2[mid2-l1] : nums1[mid2]) )/ 2.0;
            }
            else{
                int mid = sum / 2;
                return mid >= l1 ? nums2[mid-l1] : nums1[mid];
            }
        }
        else if (nums2[l2 - 1] <= nums1[0]){
            if (sum % 2 == 0){
                int mid1 = sum / 2 ;
                int mid2 = sum / 2 -1 ;
                return ((mid1 >= l1 ? nums1[mid1-l1] : nums2[mid1]) + (mid2 >= l1 ? nums1[mid2-l1] : nums2[mid2]) )/ 2.0;
            }
            else{
                int mid = sum / 2;
                return mid >= l1 ? nums1[mid-l1] : nums2[mid];
            }
        }
        else{
            int min1 = nums2[0];
            int cross = 0;
            for (int i : nums2){
                if (i <= min1)
                    cross++;
                else
                    break;
            }
            if (sum % 2 == 0){
                int mid1 = sum / 2 ;
                int mid2 = sum / 2 -1 ;
            }
            else{

            }
        }

        return 0;
    }

    public static void main(String[] args){
        Median_of_Two_Sorted_Arrays go = new Median_of_Two_Sorted_Arrays();
        //go.findMedianSortedArrays();
    }
}
