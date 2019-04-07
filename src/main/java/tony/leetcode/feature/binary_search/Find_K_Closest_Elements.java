package tony.leetcode.feature.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 658. 找到 K 个最接近的元素
// 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
// 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
//
// 示例 1:
// 输入: [1,2,3,4,5], k=4, x=3
// 输出: [1,2,3,4]
//
// 示例 2:
// 输入: [1,2,3,4,5], k=4, x=-1
// 输出: [1,2,3,4]
//
// 说明:
// k 的值为正数，且总是小于给定排序数组的长度。
// 数组不为空，且长度不超过 104
// 数组里的每个元素与 x 的绝对值不超过 104

public class Find_K_Closest_Elements {

    // 最简单的思路是普通2分找到最接近的值然后再线性查找
    // 这种方法更加巧妙
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);
        int low = 0, high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // k总是小于数组长度
        high = low + k;
        for (int i = low; i < high;i++){
            result.add(arr[i]);
        }

        return result;
    }
}
