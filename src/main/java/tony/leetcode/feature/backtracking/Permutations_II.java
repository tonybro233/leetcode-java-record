package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 47. 全排列 II
// 给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
// 输出:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

public class Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        getResult(result,nums,new ArrayList<>(),0, new int[nums.length]);
        return result;
    }

    public void getResult(List<List<Integer>> result,int[] nums,List<Integer> ans,int num,int[] pos){
        if( num == nums.length){
            result.add(new ArrayList<>(ans));
            return ;
        }
        for( int i = 0 ; i < nums.length;i++){
            if( pos[i] == 0 ){
                ans.add(nums[i]);
                pos[i] = 1;
                getResult(result,nums,ans,num+1,pos);
                pos[i] = 0;
                ans.remove(num);
                //在这里判断之后的数字是否一样，如果一样，就直接跳过。
                while(i<nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> permute = new Permutations_II().permuteUnique(new int[]{1, 1, 2, 2});
        System.out.println(permute.size());
    }

}
