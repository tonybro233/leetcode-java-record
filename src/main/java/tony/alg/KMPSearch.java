package tony.alg;

public class KMPSearch {

    public static int search(String source, String target){
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(target);

        while (i < sourceArray.length && j < targetArray.length) {
            if (j == -1 || sourceArray[i] == targetArray[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }

        if (j == targetArray.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    // 获取回调位置数组（模式串）
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;

        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args){
        String a = "sdfsdfasiuhhhuh";
        int pos = search(a, "sdfa");
        System.out.println(pos);
    }
}
