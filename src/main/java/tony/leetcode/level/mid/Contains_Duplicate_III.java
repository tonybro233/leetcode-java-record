package tony.leetcode.level.mid;

import java.util.TreeSet;

// 220. 存在重复元素 III
// 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
// 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
// 示例 1:
// 输入: nums = [1,2,3,1], k = 3, t = 0
// 输出: true

// 示例 2:
// 输入: nums = [1,0,1,1], k = 1, t = 2
// 输出: true

// 示例 3:
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
// 输出: false

public class Contains_Duplicate_III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length;i++){
            // 利用treeset来取出滑动窗口中最接近的大值和小值
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && (long)ceiling - nums[i] <= (long) t){
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && (long)nums[i] - floor <= (long) t){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
