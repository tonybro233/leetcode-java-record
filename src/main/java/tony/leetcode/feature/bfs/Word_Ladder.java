package tony.leetcode.feature.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 127 单词接龙
// 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 1.每次转换只能改变一个字母。
// 2.转换过程中的中间单词必须是字典中的单词。

// 说明:
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

// 示例 1:
// 输入:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]
//
// 输出: 5
//
// 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//      返回它的长度 5。

public class Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int dist = 1;

        while (!visited.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String word: visited) {
                for (int i = 0; i < word.length(); i++) {
                    // 不断获取所有"相邻"的节点，
                    char[] chars = word.toCharArray();
                    for (int j = (int)'a'; j < (int)'z' + 1; j++) {
                        chars[i] = (char)j;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            temp.add(newWord);
                            // 可以remove是因为只换了一个字母就能获取到，就必然属于相应的最短序列中
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            // 每次循环都表示找到了相邻节点
            dist += 1;
            if (temp.size() == 0) { // it nevert get to the endWord
                return 0;
            }

            visited = temp;
        }

        return dist;
    }

    public static void main(String[] args){
        new Word_Ladder().ladderLength("hit","cog",new ArrayList<String>(){{
            add("hot");add("dot");add("dog");add("lot");add("log");add("cog");
        }});
    }

}
