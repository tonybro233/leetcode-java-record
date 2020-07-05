package tony.sword_to_offer;

// 53 - III. 数组中数值和下标相等的元素
// 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
// 请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
// 例如，在数组[-3, -1, 1, 3, 5]中，数字3和它的下标相等

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class _53_3_find_num_equal_index {

    public int find(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        _53_3_find_num_equal_index obj = new _53_3_find_num_equal_index();
        int[] input;

        input = new int[]{-3, -1, 1, 3, 5};
        Assert.assertEquals(obj.find(input), 3);

        input = new int[]{-4, 0, 2, 3, 5};
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        Assert.assertTrue(set.contains(obj.find(input)));

        input = new int[]{0, 10, 11, 12, 13};
        Assert.assertEquals(obj.find(input), 0);

        input = new int[]{-3, -2, -1, 0, 4};
        Assert.assertEquals(obj.find(input), 4);

        input = new int[]{0};
        Assert.assertEquals(obj.find(input), 0);

        input = new int[]{1};
        Assert.assertEquals(obj.find(input), -1);

    }

}
