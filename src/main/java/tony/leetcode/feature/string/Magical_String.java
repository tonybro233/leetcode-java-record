package tony.leetcode.feature.string;

public class Magical_String {

    // 481
    // 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
    // 字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
    // 字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
    // 如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
    // 1 22 11 2 1 22 1 22 11 2 11 22 ......
    // 并且每个组中 '1' 或 '2' 的出现次数分别是：
    // 1 2 2 1 1 2 1 2 2 1 2 2 ......
    // 你可以看到上面的出现次数就是 S 本身。
    //
    // 给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
    // 注意：N 不会超过 100,000。

    public static void main(String[] args){
        int i = new Magical_String().magicalString(5);
        System.out.println(i);
    }

    /**
     * 这题卡了不少时间，妈的。
     * 首先一定是从1开始，然后1和2交替出现，使用一个变量表示当前是1还是2
     * 使用两个变量分别表示当前读取的位置 和 已经赋值的位置进行循环即可
     * 注意要初始化前2个值
     *
     * @param n
     * @return
     */
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3){
            return 1;
        }
        int[] record = new int[n];
        record[0] = 1;
        record[1] = 2;
        int pos = 1, cursor = 1;
        boolean one = false;
        int count = 1;
        while (true){
            for (int i = 0; i < record[cursor];i++){
                record[pos++] = one ? 1 : 2;
                if (pos == n){
                    if (one){
                        count += i+1;
                    }
                    return count;
                }
            }
            if (one){
                count += record[cursor];
            }
            one = !one;
            cursor++;
        }
    }
}
