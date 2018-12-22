package tony.leetcode.feature.hash;

import java.util.HashMap;
import java.util.Map;

// 205. 同构字符串
// 给定两个字符串 s 和 t，判断它们是否是同构的。
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
// 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
// 示例 1:
// 输入: s = "egg", t = "add"
// 输出: true

// 示例 2:
// 输入: s = "foo", t = "bar"
// 输出: false

// 示例 3:
// 输入: s = "paper", t = "title"
// 输出: true

// 说明:
// 你可以假设 s 和 t 具有相同的长度。

public class Isomorphic_Strings {

    public boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chas1 = s.toCharArray();
        char[] chas2 = t.toCharArray();
        // 8位ASCII码表共256个字符。0～255存s的字符，之后存t的字符
        int[] map = new int[512];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (map[chas1[i]] != map[chas2[i] + 256]) { //把字符当下标，实际上是ASCII码
                return false;
            }
            // 把一组映射内的两个字符标记为相同的下标值（下标唯一），防止多映射
            map[chas1[i]] = map[chas2[i] + 256] = i;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int n = schars.length;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> rmap = new HashMap<>();
        for (int i = 0; i < n; i++){
            Character tc = map.get(schars[i]);
            Character rc = rmap.get(tchars[i]);
            if (null == tc){
                if (null == rc || rc.equals(schars[i])){
                    map.put(schars[i], tchars[i]);
                    rmap.put(tchars[i], schars[i]);
                } else {
                    return false;
                }
            } else {
                if (!tc.equals(tchars[i])){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args){
        boolean isomorphic = new Isomorphic_Strings().isIsomorphic("ab", "aa");
        System.out.println(isomorphic);
    }
}
