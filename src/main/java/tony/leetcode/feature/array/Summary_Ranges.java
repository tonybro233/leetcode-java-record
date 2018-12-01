package tony.leetcode.feature.array;

import java.util.ArrayList;
import java.util.List;

// 228 汇总区间
// 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
// 示例 1:
// 输入: [0,1,2,4,5,7]
// 输出: ["0->2","4->5","7"]
// 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。

// 示例 2:
// 输入: [0,2,3,4,6,8,9]
// 输出: ["0","2->4","6","8->9"]
// 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

public class Summary_Ranges {

    // 写的跟屎一样
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (null == nums || nums.length == 0){
            return result;
        }
        Integer cursor = null;
        int ea = 0;
        for (int i = 0; i < nums.length; i++){
            if (null == cursor){
                ea = nums[i];
                if (i == nums.length-1){
                    result.add(ea+"");
                }
            } else if (nums[i] - cursor == 1) {
                if (i == nums.length-1){
                    result.add(ea + "->"+nums[i]);
                }
            } else {
                if (ea == cursor) {
                    result.add(ea+"");
                } else {
                    result.add(ea + "->" + cursor);
                }
                ea = nums[i];
                if (i == nums.length-1){
                    result.add(ea+"");
                }
            }
            cursor = nums[i];
        }

        return result;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        int i=0, j=0;
        while(j < nums.length){
            if (j < nums.length-1 && nums[j]+1 == nums[j+1]) {
                j++;
            } else{
                if (i==j) {
                    list.add(Integer.toString(nums[i]));
                } else{
                    String str=nums[i]+"->"+nums[j];
                    list.add(str);
                }
                i=j+1;
                j++;
            }
        }
        return list;
    }
}
