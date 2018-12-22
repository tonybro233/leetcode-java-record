package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 131. 分割回文串
// 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
// 返回 s 所有可能的分割方案。
//
// 示例:
// 输入: "aab"
// 输出:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

public class Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        go(s.toCharArray(), 0 ,0, new ArrayList<>(), result);
        return result;
    }

    private void go(char[] chars, int begin, int end, List<String> each, List<List<String>> result){
        if (end == chars.length){
            List<String> one = new ArrayList<>(each);
            result.add(one);
            return;
        }
        for (;end < chars.length; end++){
            if (check(chars, begin, end)){
                each.add(new String(chars, begin, end - begin + 1));
                go(chars, end+1, end+1, each, result);
                each.remove(each.size()-1);
            }
        }
    }

    private boolean check(char[] chars, int begin ,int end){
        while (begin < end){
            if (chars[begin] != chars[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
