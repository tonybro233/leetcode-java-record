package tony.util;

/**
 * 针对小写英文字符串的字典树节点
 */
public class TrieNode {
    // 英文字母个数
    public static final int LETTER_COUNT = 26;

    // 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
    private int freq;

    // 所有的子节点
    private TrieNode[] children;

    // 是不是最后一个节点
    private boolean isEnd;

    // 节点的值
    private char val;

    public TrieNode(char val) {
        this(val, false);
    }

    public TrieNode(char val, boolean isRoot) {
        if (!isRoot) {
            assertInput(val);
        }
        this.children = new TrieNode[LETTER_COUNT];
        this.freq = isRoot ? 0 : 1;
        this.isEnd = false;
        this.val = val;
    }

    public TrieNode getChild(char val) {
        assertInput(val);
        return children[val - 'a'];
    }

    public TrieNode addChild(char val) {
        TrieNode child = getChild(val);
        if (null == child) {
            child = new TrieNode(val);
        } else {
            child.addFreq();
        }
        return child;
    }

    private void assertInput(char val) {
        if (!Character.isLetter(val) || !Character.isLowerCase(val)) {
            throw new IllegalArgumentException("Only support lower English letter");
        }
    }

    public int addFreq() {
        return ++this.freq;
    }

    public int subFreq() {
        return --this.freq;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }
}
