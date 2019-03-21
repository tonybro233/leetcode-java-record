package tony.leetcode.feature.string;

import java.util.Arrays;

// 14. 最长公共前缀
// 编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
// 输入: ["flower","flow","flight"]
// 输出: "fl"

// 示例 2:
// 输入: ["dog","racecar","car"]
// 输出: ""
// 解释: 输入不存在公共前缀。
// 说明:
//
// 所有输入只包含小写字母 a-z 。

public class Longest_Common_Prefix {

    public String longestCommonPrefix2(String[] strs) {
        String str = "";
        if(strs.length>0) {
            str = strs[0];
            for(int i = 1;i< strs.length;i++) {
                while(!strs[i].startsWith(str)) {
                    if(str.length()>1) {
                        str = str.substring(0,str.length()-1);
                    }
                    else {
                        return "";
                    }
                }
            }
        }
        return str;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        int j = 0;
        for (int i = 0; i < strs[0].length();i++){
            if (strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                j++;
            } else {
                break;
            }
        }
        if (j == 0){
            return "";
        } else if (j == strs[0].length()) {
            return strs[0];
        } else {
            return strs[0].substring(0, j);
        }
    }
}
