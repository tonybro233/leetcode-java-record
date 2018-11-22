package tony.leetcode.feature.hash;

import java.util.*;

// 49
// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
// 输出:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// 说明：
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
public class Group_Anagrams {

    // 直接将string排序后作为key，使用hashmap操作
    // 还有更好的方法么？
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String ea : strs){
            char[] chars = ea.toCharArray();
            Arrays.sort(chars);
            String sort = new String(chars);
            List<String> list = map.getOrDefault(sort, new ArrayList<>());
            list.add(ea);
            map.putIfAbsent(sort, list);
        }
        return new ArrayList<>(map.values());
    }

}
