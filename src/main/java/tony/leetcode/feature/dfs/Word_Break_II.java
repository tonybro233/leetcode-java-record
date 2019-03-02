package tony.leetcode.feature.dfs;

import java.util.*;
import java.util.stream.Collectors;

// 140. 单词拆分 II
// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
// 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//
// 说明：
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。

// 示例 1：
// 输入:
// s = "catsanddog"
// wordDict = ["cat", "cats", "and", "sand", "dog"]
// 输出:
// [
//   "cats and dog",
//   "cat sand dog"
// ]

// 示例 2：
// 输入:
// s = "pineapplepenapple"
// wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
// 输出:
// [
//   "pine apple pen apple",
//   "pineapple pen apple",
//   "pine applepen apple"
// ]
// 解释: 注意你可以重复使用字典中的单词。

// 示例 3：
// 输入:
// s = "catsandog"
// wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出:
// []

public class Word_Break_II {

    private HashMap<String,List<String>> map = new HashMap<>();

    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        // 比如 aaabb, [a, aa,b, bb]的情况，a a a和 a aa这两个中间态在运算时可以用map加速
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if("".equals(s)){
            list.add("");
            return list;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> res = wordBreak2(s.substring(word.length()), wordDict);
                for(String str : res){
                    list.add(word+("".equals(str) ? "":" ")+str);
                }
            }
        }
        map.put(s,list);
        return list;
    }

    // 使用回溯
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();

        // Word_Break中的判断，如果不判断将会超时
        boolean[] record = new boolean[s.length()];
        for (int i = 0; i < s.length();i++){
            if (dict.contains(s.substring(0, i+1))){
                record[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++){
                if (record[j] && dict.contains(s.substring(j+1, i+1))){
                    record[i] = true;
                    break;
                }
            }
        }
        if (!record[s.length()-1]){
            return result;
        }

        go(dict, s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void go(Set<String> dict, String s, int current, int ed,List<String> ea, List<String> result){
        if (ed == s.length()) {
            result.add(ea.stream().collect(Collectors.joining(" ")));
            return;
        }

        for (; ed < s.length(); ed++){
            String s1 = s.substring(current, ed + 1);
            if (dict.contains(s1)){
                ea.add(s1);
                go(dict, s, ed+1, ed+1, ea, result);
                ea.remove(ea.size()-1);
            }
        }

    }


    public static void main(String[] args){
        String[] strings = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        List<String> list = Arrays.asList(strings);
        List<String> list1 = new Word_Break_II().wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                , list);
        System.out.println(list1);
    }

}
