package tony.leetcode.level.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 179. 最大数
// 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
//
// 示例 1:
// 输入: [10,2]
// 输出: 210

// 示例 2:
// 输入: [3,30,34,5,9]
// 输出: 9534330

public class Largest_Number {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            list.add(Integer.toString(nums[i]));
        }
        Collections.sort(list, (a,b)->{
            int n1 = a.length(), n2 = b.length();
            int max = Math.max(n1, n2);
            for (int i = 0; i < max; i++){
                int ai = i % n1, bi = i % n2;
                if (a.charAt(ai) != b.charAt(bi)){
                    return a.charAt(ai) - b.charAt(bi);
                }
            }
            return a.charAt(n1-1) - b.charAt(n2 - 1);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
        }
        if (sb.length() == 0 || '0' == sb.charAt(0)){
            return "0";
        } else{
            return sb.toString();
        }
    }


    // 老代码，其实就是一个比较的逻辑，是一样的，但是其他写的很蠢
    public String largestNumber2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = getMaxx(nums);
            if (null == str) {
                break;
            } else{
                sb.append(str);
            }
        }
        if (sb.length() == 0){
            return "0";
        } else if ('0' == sb.charAt(0)){
            return "0";
        } else{
            return sb.toString();
        }
    }

    private String getMaxx(int[] nums){
        int pos = -1;
        int[] max = null;
        for (int i = 0; i < nums.length;i++){
            int tmp = nums[i];
            if (tmp < 0) {
                continue;
            }
            int[] each = getEach(tmp);
            if (max == null){
                max = each;
                pos = i;
            } else {
                if (cmp(each,max) > 0){
                    max = each;
                    pos = i;
                }
            }
        }
        if (pos != -1){
            String str = Integer.toString(nums[pos]);
            nums[pos]  = -1;
            return str;
        } else {
            return null;
        }
    }

    private int cmp(int[] a, int[] b){
        int max = Math.max(a.length,b.length);
        for (int i = 0; i < max; i++){
            int ai = i, bi = i;
            if (ai >= a.length){
                ai = ai % a.length;
            }
            if (bi >= b.length){
                bi = bi % b.length;
            }
            if (a[ai] != b[bi]){
                return a[ai] > b[bi] ? 1 : -1;
            }
        }
        if (a[a.length-1] == b[b.length-1]){
            return 0;
        } else {
            return a[a.length-1] > b[b.length-1] ? 1 : -1;
        }
    }

    private int[] getEach(int i){
        if (i < 10){
            return new int[]{i};
        }
        List<Integer> list = new ArrayList<>(32);
        int tmp = i;
        while (tmp != 0){
            list.add(tmp % 10);
            tmp /= 10;
        }
        Collections.reverse(list);
        int[] re = new int[list.size()];
        for (int j = 0; j < list.size();j++){
            re[j] = list.get(j);
        }
        return re;
    }
}
