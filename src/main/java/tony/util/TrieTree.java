package tony.util;

/**
 * 简单字典树(小写字母)
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode(' ', true);
    }

    // 查找是否存在
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return null != node && node.isEnd();
    }

    // 查找返回节点
    public TrieNode searchNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.getChild(word.charAt(i));
            if (null == current) {
                return null;
            }
        }
        return current.isEnd() ? current : null;
    }

    // 插入
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.addChild(word.charAt(i));
        }
        current.setEnd(true);
    }


    // 获取前缀词频
    public int getFreq(String word) {
        TrieNode node = searchNode(word);
        return node == null ? 0 : node.getFreq();
    }
}
