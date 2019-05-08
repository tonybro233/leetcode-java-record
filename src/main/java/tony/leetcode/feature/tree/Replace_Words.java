package tony.leetcode.feature.tree;

import java.util.List;

// 648. 单词替换
// 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的
// 单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，
// 可以形成新的单词 another(另一个)。
//
// 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
// 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
// 你需要输出替换之后的句子。
//
// 示例 1:
// 输入: dict(词典) = ["cat", "bat", "rat"]
// sentence(句子) = "the cattle was rattled by the battery"

// 输出: "the cat was rat by the bat"

// 注:
// 输入只包含小写字母。
// 1 <= 字典单词数 <=1000
// 1 <=  句中词语数 <= 1000
// 1 <= 词根长度 <= 100
// 1 <= 句中词语长度 <= 1000

public class Replace_Words {

    // 典型的字典树(前缀树)
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node(' ', false);
        for (String ea : dict){
            Node current = root;
            for (int i = 0; i < ea.length()-1;i++){
                Node c = current.child[ea.charAt(i)-'a'];
                if (null == c){
                    c = new Node(ea.charAt(i), false);
                    current.child[ea.charAt(i)-'a'] = c;
                }
                current = c;
            }
            if (current.child[ea.charAt(ea.length()-1)-'a'] == null){
                current.child[ea.charAt(ea.length()-1)-'a'] = new Node(ea.charAt(ea.length()-1), true);
            } else {
                current.child[ea.charAt(ea.length()-1)-'a'].isEnd = true;
            }
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = replace(root, words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words){
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    private String replace(Node root, String word){
        Node current = root;
        for (int i = 0; i < word.length()-1;i++){
            current = current.child[word.charAt(i)-'a'];
            if (null == current){
                return word;
            }
            if (current.isEnd){
                return word.substring(0, i+1);
            }
        }
        return word;
    }

    class Node {
        boolean isEnd;
        Node[] child = new Node[26];
        char val;
        public Node(char val, boolean isEnd){
            this.val = val;
            this.isEnd = isEnd;
        }
    }
}
