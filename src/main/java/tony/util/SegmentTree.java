package tony.util;

/**
 * 线段树
 * 数组形式
 */
public class SegmentTree {

    private int[] values;
    private int[] index;
    private int le;

    public SegmentTree(int[] values){
        if (null == values || values.length == 0){
            throw new IllegalArgumentException("Need non empty array");
        }
        le = values.length;
        this.values = new int[le+1];
        System.arraycopy(values, 0, this.values, 1, le);
        // 4倍保证不产生越界
        this.index = new int[le << 2];
        // 构建
        build(1, le, 1);
    }

    public SegmentTree(int count){
        if (count <= 0){
            throw new IllegalArgumentException("Must greater than zero");
        }
        this.le = count;
        this.values = new int[le + 1];
        this.index = new int[le << 2];
    }

    public int getLength(){
        return le;
    }

    public int getValue(int n){
        return values[n];
    }

    // 将第n个位置更新为val
    public void update(int n, int val){
        if (n < 1 || n > le){
            throw new IllegalArgumentException("Out of the range");
        }
        add(n, val - values[n]);
    }

    // 在第n个位置处增加值val
    public void add(int n, int val){
        if (n < 1 || n > le){
            throw new IllegalArgumentException("Out of the range");
        }
        add(n, val, 1, le, 1);
    }

    /**
     * 范围内指定位置增加值
     *
     * @param n 更改的位置
     * @param val 增量
     * @param l 区间左值
     * @param r 区间右值
     * @param pos 当前节点位置
     */
    private void add(int n, int val, int l, int r, int pos){
        if(l == r){
            //到达叶节点，修改叶节点的值
            index[pos] += val;
            return;
        }
        int m = (l+r)>>1;
        //根据条件判断往左子树调用还是往右
        if(n <= m) {
            add(n, val, l, m,pos<<1);
        } else {
            add(n, val,m+1, r,pos<<1|1);
        }
        // 子节点递归更新完成后更新本节点
        pushUp(pos);
    }

    public int getSum(int n){
        return getSum(1, n);
    }

    public int getSum(int l, int r){
        if (l < 1 || r > le){
            throw new IllegalArgumentException("Out of the range");
        }
        return getSum(l, r, 1, le, 1);
    }

    private int getSum(int L,int R, int l,int r,int pos){
        if(L<=l && R>=r){
            //在区间内直接返回
            return index[pos];
        }
        int m = (l+r)>>1;
        //左子区间:[l,m] 右子区间：[m+1,r]  求和区间:[L,R]
        //累加答案
        int answer = 0;
        if (L <= m) {
            answer += getSum(L,R,l,m,pos<<1);//左子区间与[L,R]有重叠，递归
        }
        if (R > m) {
            answer += getSum(L,R,m+1,r,pos<<1|1); //右子区间与[L,R]有重叠，递归
        }
        return answer;
    }

    private void build(int l, int r, int pos){
        if (l == r){
            index[pos] = values[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, pos<<1); // 2*pos
        build(mid+1, r, (pos<<1)|1); // 2*pos+1
        pushUp(pos);
    }

    private void pushUp(int pos){
        index[pos] = index[pos<<1] + index[(pos<<1)|1];
    }
}
