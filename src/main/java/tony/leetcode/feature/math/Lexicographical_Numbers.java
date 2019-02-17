package tony.leetcode.feature.math;

import java.util.*;

// 386
// 给定一个整数 n, 返回从 1 到 n 的字典顺序。

// 例如，
// 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。

// 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。

public class Lexicographical_Numbers {

    public static void main(String[] args){
        Lexicographical_Numbers go = new Lexicographical_Numbers();
        List<Integer> list = go.lexicalOrder(99);
        for (Integer ea : list){
            System.out.print(ea+" ");
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur = cur * 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur = cur / 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }


    public List<Integer> lexicalOrder2(int n) {
        int maxsize = 1;
        int nc = n;
        while (nc / 10 > 0){
            maxsize++;
            nc /= 10;
        }
        int[] pos = new int[maxsize];
        Arrays.fill(pos,-1);
        pos[0] = 1;
        int cursor = 0, oldCursor = 0;

        // 不应该用LinkedList，顺序添加还是ArrayList快
        // LinkedList用于随机位置添加、删除
        List<Integer> re = new LinkedList<>();

        int val = 1;
        while(true){
            if (0 == val) {
                break;
            }
            if (val <= n){
                re.add(val);
                if (cursor+1 < maxsize && pos[cursor+1] < 0) {
                    pos[++cursor] = 0;
                    val *= 10;
                } else {
                    oldCursor = cursor;
                    cursor = addOne(pos,cursor);
                    if (cursor < 0){
                        break;
                    }
                    val = (val+1)/(int)Math.pow(10,oldCursor-cursor);
                }
            } else {
                oldCursor = cursor;
                cursor = back(pos,cursor);
                if (cursor < 0) {
                    break;
                }
                val = (val/10 + 1)/(int)Math.pow(10,oldCursor-cursor-1);
            }
        }
        return re;
    }

    private int addOne(int[] pos, int cursor){
        pos[cursor] ++;
        while (pos[cursor] == 10){
            pos[cursor--] = -1;
            if (cursor < 0){
                return cursor;
            }
            pos[cursor]++;
        }
        return cursor;
    }

    private int back(int[] pos, int cursor){
        pos[cursor--] = -1;
        if (cursor < 0)
            return cursor;
        return addOne(pos,cursor);
    }

    private int getValue(int[] pos){
        int n = pos.length;
        int c = 0;
        for (int i = 0; i < n && pos[i] >= 0;i++){
            c++;
        }
        if (c == 0) {
            return 0;
        }
        int re = 0;
        for (int i = 0; i < c;i++){
            re += pos[i]*Math.pow(10,c-i-1);
        }
        return re;
    }
}
