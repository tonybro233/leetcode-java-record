package tony.leetcode.level.mid;

import java.util.*;

// 383. 赎金信
// 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
// 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
// 如果可以构成，返回 true ；否则返回 false。
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
//
// 注意：
// 你可以假设两个字符串均只含有小写字母。
//
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

public class Ransom_Note {

    // 注意利用字符候选者有限这个条件
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c: magazine.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rchars = ransomNote.toCharArray();
        char[] mchars = magazine.toCharArray();
        if (rchars.length > mchars.length){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : mchars){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : rchars){
            Integer num = map.getOrDefault(c, 0);
            if (0 == num){
                return false;
            } else {
                map.put(c, num-1);
            }
        }
        return true;
    }
}
