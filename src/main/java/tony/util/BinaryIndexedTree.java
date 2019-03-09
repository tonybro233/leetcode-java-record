package tony.util;

import java.util.Arrays;

/**
 * 树状数组
 * 操作下标从1开始
 */
public class BinaryIndexedTree {

    private int[] values;
    private int[] index;
    private int le;

    // 通过数组构建
    public BinaryIndexedTree(int[] values){
        if (null == values || values.length == 0){
            throw new IllegalArgumentException("Need non empty array");
        }
        le = values.length;
        this.values = new int[le+1];
        this.index = new int[le+1];

        // 初始化方法1
        System.arraycopy(values, 0, this.values, 1, le);
        for (int i = 1; i <= le; i++){
            index[i] += values[i];
            int j = i;
            int lowb = Integer.lowestOneBit(j);
            j -= lowb;
            lowb >>= 1;
            while (lowb > 0){
                j += lowb;
                index[i] += index[j];
                lowb >>= 1;
            }
        }

        // 初始化方法2
        // for (int i = 1; i <= le; i++){
        //     update(i, values[i-1]);
        // }
    }

    // 构建定长的空数组
    public BinaryIndexedTree(int count){
        if (count <= 0){
            throw new IllegalArgumentException("Must greater than zero");
        }
        this.le = count;
        this.values = new int[count+1];
        this.index = new int[count+1];
    }

    // 取前n个数的和
    public int getSum(int n) {
        if (n > le){
            throw new IllegalArgumentException("Only got "+le+" numbers");
        }
        if (n < 0){
            throw new IllegalArgumentException("Must be a non negative number");
        }
        int ans = 0;
        for (int i = n; i > 0; i -= Integer.lowestOneBit(i)) {
            ans += index[i];
        }
        return ans;
    }

    // 取第low个数到第high个数的和
    public int getRange(int low, int high){
        if (low > high || low <= 0){
            throw new IllegalArgumentException("Illegal range");
        }
        if (low == high){
            return getValue(low);
        } else {
            return getSum(high) - getSum(low - 1);
        }
    }

    // 对第n个数增加值
    public void add(int n, int increment) {
        values[n] += increment;
        while (n <= le) {
            index[n] += increment;
            n += Integer.lowestOneBit(n);
        }
    }

    // 对第n个数赋值
    public void update(int pos, int val){
        add(pos, val - getValue(pos));
    }

    public int getLength(){
        return le;
    }

    public int getValue(int n){
        return values[n];
    }

    public int getIndexVal(int n){
        return index[n];
    }

    public int[] getIndex(){
        int[] result = new int[le - 1];
        System.arraycopy(index, 1, result, 0, le-1);
        return result;
    }

    public int[] getValues(){
        int[] result = new int[le - 1];
        System.arraycopy(values, 1, result, 0, le-1);
        return result;
    }

    public static void main(String[] args){
        BinaryIndexedTree tree = new BinaryIndexedTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(tree.getIndex()));
        System.out.println(tree.getSum(8));
    }

}
