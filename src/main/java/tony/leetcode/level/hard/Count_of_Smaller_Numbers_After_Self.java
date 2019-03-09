package tony.leetcode.level.hard;

import java.util.*;

// 315. 计算右侧小于当前元素的个数
// 给定一个整数数组 nums，按要求返回一个新数组 counts。
// 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
//
// 示例:
// 输入: [5,2,6,1]
// 输出: [2,1,1,0]
// 解释:
// 5 的右侧有 2 个更小的元素 (2 和 1).
// 2 的右侧仅有 1 个更小的元素 (1).
// 6 的右侧有 1 个更小的元素 (1).
// 1 的右侧有 0 个更小的元素.

public class Count_of_Smaller_Numbers_After_Self {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length ;
        int[] a = Arrays.copyOf(nums, nums.length);
        Arrays.sort(a);
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0 ;
        // 值为key，序号(从小到大)为value的map
        for(int i = 0;i < a.length;i++){
            // 相同的值取最小的下标
            if(!map.containsKey(a[i])){
                map.put(a[i], ++sum) ;
            }
        }

        BitArray bitArray = new BitArray(n) ;
        List<Integer> result = new ArrayList<>(nums.length);
        // 从右往左遍历处理
        for(int i = nums.length-1;i >= 0;i--){
            // 取得序号
            int nn = map.get(nums[i]);
            // 获取小于这个序号的且已经入列的个数
            result.add(bitArray.get(nn - 1));
            // 把自身的序号添加入树状数组
            bitArray.add(nn, 1);
        }
        // 由于是从右往左遍历，因此需要反向
        Collections.reverse(result);
        return result;
    }

    // 使用树状数组，辅助计算实际数组A，A[i]表示序号为i的个数，get(i)表示A[1] ~ A[i]之和
    // add和get方法时间复杂度均为logN
    class BitArray{
        int[] tree ;
        int n ;
        BitArray(int n){
            tree = new int[n+1] ;
            this.n = n ;
        }
        public void add(int x,int add){
            while(x < n){
                tree[x] += add ;
                x += (x&(-x)) ;
            }
        }
        public int get(int x){
            int ans = 0 ;
            while(x > 0){
                ans += tree[x] ;
                x -= (x&(-x)) ;
            }
            return ans ;
        }
    }

    public static void main(String[] args){
        List<Integer> list = new Count_of_Smaller_Numbers_After_Self().countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(list);
    }
}
