package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Split_Into_Fibonacci {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = tracking(num, 0, new ArrayList<>());
        if (null == res) {
            return Collections.emptyList();
        } else {
            return res;
        }
    }

    private List<Integer> tracking(String num, int idx, List<Integer> values) {
        // 终止条件
        if (idx >= num.length()) {
            if (values.size() > 2) {
                return values;
            } else {
                return null;
            }
        }

        // 逻辑递归
        List<Integer> res;
        int len = values.size();
        if (len < 2) {
            // 不到两个数，任意组合，前提是不能以0开头且小于int最大值
            if (num.charAt(idx) == '0') {
                values.add(0);
                res = tracking(num, idx + 1, values);
                if (null != res) {
                    return res;
                }
                values.remove(values.size() - 1);
            } else {
                // 为了保证至少3个数字
                int limit = idx + (num.length() - idx) / 2;
                for (int i = idx; i <= limit; i++) {
                    long val = Long.parseLong(num.substring(idx, i + 1));
                    if (val > Integer.MAX_VALUE) {
                        return null;
                    }
                    values.add((int) val);
                    res = tracking(num, i + 1, values);
                    if (null != res) {
                        return res;
                    }
                    values.remove(values.size() - 1);
                }
            }
        } else {
            int target = values.get(len - 2) + values.get(len - 1);
            String targetStr = Integer.toString(target);
            int endIdx = idx + targetStr.length();
            if (endIdx <= num.length() && targetStr.equals(num.substring(idx, endIdx))) {
                values.add(target);
                res = tracking(num, endIdx, values);
                if (null != res) {
                    return res;
                }
                values.remove(values.size() - 1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Split_Into_Fibonacci solution = new Split_Into_Fibonacci();
        List<Integer> integers = solution.splitIntoFibonacci("1320581321313221264343965566089105744171833277577");
        System.out.println(integers);
    }
}
