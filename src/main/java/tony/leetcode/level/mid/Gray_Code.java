package tony.leetcode.level.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 89. 格雷编码
// 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
//
// 示例 1:
// 输入: 2
// 输出: [0,1,3,2]
// 解释:
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
//
// 对于给定的 n，其格雷编码序列并不唯一。
// 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
// 00 - 0
// 10 - 2
// 11 - 3
// 01 - 1

// 示例 2:
// 输入: 0
// 输出: [0]
// 解释: 我们定义格雷编码序列必须以 0 开头。
//      给定编码总位数为 n 的格雷编码序列，其长度为 2的n次方。当 n = 0 时，长度为 2的0次 = 1。
//      因此，当 n = 0 时，其格雷编码序列为 [0]。

public class Gray_Code {

    // 这个方法有点骚的
    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int gap = 1;
        for(int i = 0; i < n; i++){
            for(int j = res.size()-1; j >= 0; j--){
                res.add(res.get(j) + gap); // 增加的时候已经在list中的数字的目标位都是0
            }
            gap <<= 1;
        }
        return res;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> record = new HashSet<>();
        find(n, 0, record, result);
        return result;
    }

    private void find(int n, int val, Set<Integer> record, List<Integer> result){
        if (record.contains(val)){
            return;
        }
        record.add(val);
        result.add(val);
        String str = Integer.toBinaryString(val);
        char[] chars = new char[n];
        int s = n - str.length();
        if (s < 0){
            return;
        }
        for (int i = 0; i < s;i++){
            chars[i] = '0';
        }
        for (int i = 0; i < str.length();i++){
            chars[s+i] = str.charAt(i);
        }

        for (int i = 0; i < n;i++){
            char tmp = chars[i];
            if (tmp == '0'){
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
            int next = Integer.parseInt(new String(chars), 2);
            find(n, next, record, result);
            chars[i] = tmp;
        }
    }
}
