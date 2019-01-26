package tony.leetcode.feature.tree;

// 208. 实现 Trie (前缀树)
// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
// trie.insert("apple");
// trie.search("apple");   // 返回 true
// trie.search("app");     // 返回 false
// trie.startsWith("app"); // 返回 true
// trie.insert("app");
// trie.search("app");     // 返回 true

// 说明:
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。

public class Implement_Trie {

    private node root;

    /** Initialize your data structure here. */
    public Implement_Trie() {
        this.root = new node('a', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        node current = root;
        for (int i = 0; i < chars.length - 1; i++){
            current = current.addChild(chars[i], false);
        }
        current.addChild(chars[chars.length -1], true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        node current = root;
        for (int i = 0; i < chars.length; i++){
            current = current.getChild(chars[i]);
            if (null == current){
                return false;
            }
        }
        return current.getIsEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        node current = root;
        for (int i = 0; i < chars.length; i++){
            current = current.getChild(chars[i]);
            if (null == current){
                return false;
            }
        }
        return true;
    }

    class node {
        private node[] children;
        private boolean end;
        private char val;

        public node(char val, boolean last){
            this.end = last;
            this.val = val;
            this.children = new node[26];
        }

        public node getChild(char val){
            assertVal(val);
            return children[val - 'a'];
        }

        public node addChild(char val, boolean last){
            node result = getChild(val);
            if (null == result){
                result = new node(val, last);
                this.children[val - 'a'] = result;
            } else if (last){
                result.setIsEnd(last);
            }
            return result;
        }

        public void setIsEnd(boolean input){
            this.end = input;
        }

        public boolean getIsEnd(){
            return end;
        }

        private void assertVal(char val){
            if (!Character.isLetter(val) || !Character.isLowerCase(val)){
                throw new IllegalArgumentException("Only support lower English letter");
            }
        }
    }
}
