package tony.leetcode.feature.array;

// 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，
// 从编码字符串中每次读取一个字符，并采取以下步骤：
//
// 如果所读的字符是字母，则将该字母写在磁带上。
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。

// 1. 2 <= S.length <= 100
// 2. S 只包含小写字母与数字 2 到 9 。
// 3. S 以字母开头。
// 4. 1 <= K <= 10^9
// 5. 解码后的字符串保证少于 2^63 个字母。

public class StringDecodeAtIndex {

    public static void main(String[] args) {
        StringDecodeAtIndex go = new StringDecodeAtIndex();  // 768077956   2147483647
        System.out.println(go.decodeAtIndex("czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm2 89thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps", 4979929));
    }

    public String decodeAtIndex(String S, int K) {
        int record = 0;
        long count = 0;
        long k = K; // 阴逼要用long
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                count++;
            } else if (Character.isDigit(c)) {
                count *= (c - '0');
            }
            if (count >= K) {
                break;
            }
            record++;
        }

        // record = chars.length - 1;

        for (; record >= 0; record--) {
            if (Character.isDigit(chars[record])) {
                int digit = chars[record] - '0';
                count /= digit;
                k = k % count;
            } else {
                if (k % count == 0) {
                    return Character.toString(chars[record]);
                }
                count--;
            }
        }

        return "";

    }

    public String decodeAtIndex2(String S, int K) {
        int record = 1;
        long count = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                count++;
            } else if (Character.isDigit(c)) {
                int digit = c - '0';
                count *= digit;
            }
            if (count >= K) {
                break;
            }
        }
        if (count == K) {
            if (Character.isLetter(chars[record - 1])) {
                return Character.toString(chars[record - 1]);
            } else {
                for (int i = record - 2; i >= 0; i--) {
                    if (Character.isLetter(chars[i])) {
                        return Character.toString(chars[i]);
                    }
                }
                return "";
            }
        } else {
            // 如果不等于，最后一位必然是数字
            long left = count - K;
            int record2 = record;
            for (; record2 >= 0; record2--) {
                if (Character.isDigit(chars[record2])) {
                    int digit = chars[record2] - '0';
                    count /= digit;
                } else if (K % (count--) == 0) {
                    return Character.toString(chars[record2]);
                }
            }
            return "";
        }
    }


    // 超出内存限制
    public String decodeAtIndex3(String S, int K) {
        int record = 1;
        int count = 0;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                sb.append(c);
                count++;
            } else if (Character.isDigit(c)) {
                int digit = Integer.valueOf(Character.toString(c));
                count *= digit;
                String now = sb.toString();
                for (int i = 0; i < digit - 1; i++) {
                    sb.append(now);
                }
            }
            if (count >= K) {
                break;
            }
        }

        return Character.toString(sb.charAt(K - 1));
    }


}
