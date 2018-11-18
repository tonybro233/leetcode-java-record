package tony.leetcode.feature.hash;

import java.util.*;

public class Next_Greater_Element_I {

    // 496
    //给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
    // 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
    //
    // nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
    // 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    // 输出: [-1,3,-1]

    /**
     * 我一度想用LinkedHashSet，但是这个结构并不能获取下一个entryset，同样又想用treeset，但是很明显想歪了
     *
     * 关键点在于没有重复元素，且nums1是nums2的子集
     * 由于没有重复元素，使用map记录nums2中每个值对应的更大值的角标
     * 然后遍历nums1，根据上面的map进行寻找即可
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length;i++){
            int val = nums2[i];
            int next = -1;
            for (int j = i+1;j < nums2.length;j++){
                if (nums2[j] > val){
                    next = j;
                    break;
                }
            }
            map.put(val,next);
        }
        for (int i = 0; i < nums1.length;i++){
            if (-1 == map.get(nums1[i])){
                result[i] = -1;
            } else {
                result[i] = nums2[map.get(nums1[i])];
            }
        }

        return result;
    }
}
