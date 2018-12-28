package tony.leetcode.level.simple;

// 387. 字符串中的第一个唯一字符
// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。
// 如果不存在，则返回 -1。
//
// 案例:
// s = "leetcode"
// 返回 0.
//
// s = "loveleetcode",
// 返回 2.

// 注意事项：您可以假定该字符串只包含小写字母。


public class First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;i++){
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++){
            if (count[chars[i]-'a'] == 1){
                return i;
            }
        }
        s.lastIndexOf('a');
        return -1;
    }
}
