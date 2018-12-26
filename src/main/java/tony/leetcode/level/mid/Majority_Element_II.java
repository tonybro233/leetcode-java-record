package tony.leetcode.level.mid;

import java.util.ArrayList;
import java.util.List;

// 229. 求众数 II
// 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
//
// 示例 1:
// 输入: [3,2,3]
// 输出: [3]

// 示例 2:
// 输入: [1,1,1,3,3,2,2,2]
// 输出: [1,2]

public class Majority_Element_II {

    // 麻烦在复杂度的要求，需要采用BM投票法（Boyer-Moore Majority Vote Algorithm）
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n1 = 0, n2 = 0;
        int c1 = 0, c2 = 0;
        // 获取可能符合条件的2个值
        for (int i : nums){
            if (n1 == i){
                c1++;
            } else if (n2 == i){
                c2++;
            } else if (c1 == 0){
                c1++;
                n1 = i;
            } else if (c2 == 0){
                c2++;
                n2 = i;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums){
            if (i == n1){
                c1++;
            } else if (i == n2){
                c2++;
            }
        }
        if (c1 > nums.length / 3){
            result.add(n1);
        }
        if (c2 > nums.length / 3){
            result.add(n2);
        }

        return result;
    }

    public static void main(String[] args){
        new Majority_Element_II().majorityElement(new int[]{8,8,7,7,7});
    }
}
