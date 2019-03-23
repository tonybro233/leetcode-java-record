package tony.leetcode.level.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 68. 文本左右对齐
// 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，
// 使得每行恰好有 maxWidth 个字符。
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
//
// 说明:
// 单词是指由非空格字符组成的字符序列。
// 每个单词的长度大于 0，小于等于 maxWidth。
// 输入单词数组 words 至少包含一个单词。

// 示例:
// 输入:
// words = ["This", "is", "an", "example", "of", "text", "justification."]
// maxWidth = 16
// 输出:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]

// 示例 2:
// 输入:
// words = ["What","must","be","acknowledgment","shall","be"]
// maxWidth = 16
// 输出:
// [
//   "What   must   be",
//   "acknowledgment  ",
//   "shall be        "
// ]
// 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//      因为最后一行应为左对齐，而不是左右两端对齐。
//      第二行同样为左对齐，这是因为这行只包含一个单词。

// 示例 3:
// 输入:
// words = ["Science","is","what","we","understand","well","enough","to","explain",
//          "to","a","computer.","Art","is","everything","else","we","do"]
// maxWidth = 20
// 输出:
// [
//   "Science  is  what we",
//   "understand      well",
//   "enough to explain to",
//   "a  computer.  Art is",
//   "everything  else  we",
//   "do                  "
// ]

public class Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int cursor = 0;

        StringBuilder eaSb = new StringBuilder();
        List<String> eaList = new ArrayList<>();
        int leftWidth = maxWidth;
        int charCount = 0;

        while (cursor < words.length){
            eaList.add(words[cursor]);
            leftWidth -= words[cursor].length();
            charCount += words[cursor].length();
            if (leftWidth > 0){
                leftWidth--;
            }
            if (cursor < words.length-1 && leftWidth >= words[cursor+1].length()){
                // 还可以继续添加单词
            } else {
                if (eaList.size() == 1 || cursor == words.length-1){
                    // 左对齐
                    Iterator<String> iterator = eaList.iterator();
                    while (iterator.hasNext()){
                        eaSb.append(iterator.next());
                        if (iterator.hasNext()){
                            eaSb.append(' ');
                        }
                    }
                    int n = eaSb.length();
                    for (int i = 0; i < maxWidth - n; i++){
                        eaSb.append(' ');
                    }
                } else {
                    // 间距处理
                    int spaceCount = maxWidth - charCount;
                    int wordCount = eaList.size();
                    if (spaceCount % (wordCount-1) == 0){
                        // 间距一致
                        int eaSpace = spaceCount / (wordCount-1);
                        for (int i = 0; i < wordCount -1 ;i++){
                            eaSb.append(eaList.get(i));
                            for (int j = 0; j < eaSpace;j++){
                                eaSb.append(' ');
                            }
                        }
                        eaSb.append(eaList.get(wordCount-1));
                    } else {
                        int leftSpace = spaceCount;
                        // 循环分配空格
                        for (int i = 0; leftSpace > 0 ; i++, leftSpace--){
                            i = i % (wordCount-1);
                            eaList.set(i, eaList.get(i)+" ");
                        }
                        for (int i = 0; i < wordCount ;i++){
                            eaSb.append(eaList.get(i));
                        }
                    }
                }

                result.add(eaSb.toString());

                // 重置
                eaSb = new StringBuilder();
                eaList = new ArrayList<>();
                leftWidth = maxWidth;
                charCount = 0;
            }

            cursor++;
        }

        return result;
    }

    public static void main(String[] args){
        String[] strs = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> list = new Text_Justification().fullJustify(strs, 16);
        for (String ea : list){
            System.out.println("\""+ea+"\"");
        }
    }
}
