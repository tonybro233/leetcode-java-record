package tony.leetcode.feature.hash;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     *
         输入: "abcabcbb"
         输出: 3
         解释: 无重复字符的最长子串是 "abc"，其长度为 3。

         输入: "pwwkew"
         输出: 3
         解释: 无重复字符的最长子串是 "wke"，其长度为 3。
         请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     */

    public static void main(String[] args){
        Longest_Substring_Without_Repeating_Characters go = new Longest_Substring_Without_Repeating_Characters();
        int size = go.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(size);
    }

    public int lengthOfLongestSubstring(String s) {
        String re = "";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        int bottom = 0;
        List<Character> list = new LinkedList<Character>();
        //LinkedHashSet<Character> lset = new LinkedHashSet<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int pos = -1;
        for (int i =0 ; i < chars.length; i++){
            Character ea = chars[i];
            Integer integer = map.get(ea);
            if (null == integer || integer < bottom){
                map.put(ea,i);
                count++;
                max = max > count ? max : count;
            }else{
                count = i - integer;
                map.put(ea,i);
                bottom = integer + 1;
            }
        }

        return max;
    }
}
