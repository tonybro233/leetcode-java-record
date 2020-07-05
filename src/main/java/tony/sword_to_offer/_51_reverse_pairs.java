package tony.sword_to_offer;

// 51. 数组中的逆序对
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组，求出这个数组中的逆序对的总数。
//
// 示例 1:
// 输入: [7,5,6,4]
// 输出: 5

public class _51_reverse_pairs {

    // 利用归并排序，比较难想得到。。
    public int reversePairs(int[] nums) {
        return sortAndCalc(nums, 0, nums.length - 1);
    }

    private int sortAndCalc(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = (lo + hi) / 2;
        int c1 = sortAndCalc(nums, lo, mid);
        int c2 = sortAndCalc(nums, mid + 1, hi);
        return c1 + c2 + merge(nums, lo, mid, hi);
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int count = 0;

        int leftCursor = lo;
        int rightCursor = mid + 1;

        int[] helper = new int[hi - lo + 1];
        int idx = 0;
        while (leftCursor <= mid && rightCursor <= hi) {
            if (nums[leftCursor] <= nums[rightCursor]) {
                helper[idx++] = nums[leftCursor++];
            } else {
                helper[idx++] = nums[rightCursor++];
                count += mid - leftCursor + 1; // 比num[rightCursor] 大的有几个
            }
        }

        while (leftCursor <= mid) {
            helper[idx++] = nums[leftCursor++];
        }
        while (rightCursor <= hi) {
            helper[idx++] = nums[rightCursor++];
        }

        int i = lo;
        for (int ea : helper) {
            nums[i++] = ea;
        }

        return count;
    }

}
