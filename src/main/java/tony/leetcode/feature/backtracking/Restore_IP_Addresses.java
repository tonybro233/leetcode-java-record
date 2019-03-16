package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 93. 复原IP地址
// 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

// 示例:
// 输入: "25525511135"
// 输出: ["255.255.11.135", "255.255.111.35"]

public class Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        go(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void go(String s, int start, List<Integer> current, List<String> result){
        if (start == s.length()){
            return;
        }
        if (current.size() == 3){
            if (start < s.length() - 3){
                return ;
            }
            if (s.length() - start > 1 && '0' == s.charAt(start)){
                return;
            }
            String str = s.substring(start, s.length());
            Integer val = Integer.valueOf(str);
            if (val <= 255 && val.toString().equals(str)){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3;i++){
                    sb.append(current.get(i)).append('.');
                }
                sb.append(val);
                result.add(sb.toString());
            }
        } else {
            int max = Math.min(start+3, s.length());
            for (int i = start+1; i <= max; i++){
                // 不能是以0开头的多位
                if (i - start > 1 && '0' == s.charAt(start)){
                    continue;
                }
                Integer val = Integer.valueOf(s.substring(start, i));
                if (val <= 255){
                    current.add(val);
                    go(s, i, current, result);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        List<String> list = new Restore_IP_Addresses().restoreIpAddresses("010010");
        System.out.println(list);
    }
}
