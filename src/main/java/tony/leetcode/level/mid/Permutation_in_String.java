package tony.leetcode.level.mid;

// 567. 字符串的排列
// 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
// 输入: s1 = "ab" s2 = "eidbaooo"
// 输出: True
// 解释: s2 包含 s1 的排列之一 ("ba").
//
// 示例2:
// 输入: s1= "ab" s2 = "eidboaoo"
// 输出: False
//
// 注意：
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间

import java.util.Arrays;

public class Permutation_in_String {

    // 滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2){
            return false;
        }
        char[] target = new char[26], window = new char[26];
        for (int i = 0; i < l1;i++){
            target[s1.charAt(i)-'a']++;
            window[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(target, window)){
            return true;
        }
        for (int j = l1; j < l2;j++){
            window[s2.charAt(j)-'a']++;
            window[s2.charAt(j-l1)-'a']--;
            if (Arrays.equals(target, window)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] i1 = new int[2];
        int[] i2 = new int[2];
        System.out.println(Arrays.equals(i1,i2));

    }
}
