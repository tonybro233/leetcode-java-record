package tony.alg;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearch<Key extends Comparable<Key>, Value> {

    private Key[] keys;		// 键数组

    private Value[] vals;	// 值数组

    private int n;			// 键值对数量

    public BinarySearch(int capcity) {
        keys = (Key[]) new Comparable[capcity];
        vals = (Value[]) new Object[capcity];
        n = 0;
    }

    /**
     * 使用二分法在键数组中获取位置，返回小于输入值的键的数量
     */
    public int rank(Key key) {
        int lo = 0;
        int hi = n-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid -1;
            }
            else if (cmp > 0) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        // 存在键，修改值
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
        }
        // 不存在，右边全部右移一位
        for (int j = n; j > i;j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }

        return null;
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            for (int j = i; j < n-1; j++) {
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            n--;
        }
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    public int size() {
        return n;
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new LinkedList<>();
        for (int i = 0; i < n;i++) {
            q.offer(keys[i]);
        }

        return q;
    }
}
