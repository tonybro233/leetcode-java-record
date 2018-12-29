package tony.leetcode.feature.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pascal_Triangle {

    // 118 杨辉三角
    // 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

    public static void main(String[] args){
        System.out.println(combine(3,2));
        Pascal_Triangle go = new Pascal_Triangle();
        go.generate(15);
        BigInteger a = BigInteger.valueOf(1);

        int i = a.intValueExact();

    }

    /**
     * 使用一个二维数组记录每个值
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return re;
        }
        re.add(Collections.singletonList(1));
        Integer[][] data = new Integer[numRows][numRows];
        data[0][0] = 1;
        if (numRows > 1){
            data[1][0] = 1;
            data[1][1] = 1;
            re.add(Arrays.asList(1, 1));
        }
        int p1 = 0,p2 = 0;
        for (int i = 2; i < numRows;i++){
            for (int j = 0;j <= i;j++){
                if (j-1 < 0) {
                    p1 = 0;
                } else {
                    p1 = data[i-1][j-1];
                }
                if (i == j) {
                    p2 = 0;
                } else {
                    p2 = data[i-1][j];
                }
                data[i][j] = p1 + p2;
            }
            Integer[] ea = data[i];
            re.add(Arrays.asList(Arrays.copyOf(ea,i+1)));
        }

        return re;
    }

    /**
     * 利用杨辉三角的特性，每个值=C(n,m) , n行m列
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++){
            List<Integer> ea = new ArrayList<Integer>();
            for (int j = 0; j <= i;j++){
                ea.add(combine(i,j));
            }
            re.add(ea);
        }
        return re;
    }

    // 计算 C(n,m) n个数取m个的组合数
    //private static Integer structure(int n , int m){
    //    if (m > n)
    //        return 0;
    //    // 太容易越界
    //    return (int) (factorial(n) / (factorial(m)*factorial(n-m)));
    //}

    /**
     * C(n,m) = C(n-1,m-1) + C(n-1,m)，可以由组合数公式推导出
     * 使用递归
     */
    private static Integer combine(int n , int m){
        if (n < 0 || m > n)
            return 0;
        if (m == 0){
            return 1;
        }
        if (n == m)
            return 1;
        return combine(n-1,m-1)+combine(n-1,m);
    }

    // 计算阶乘，容易超出界限
    private static Long factorial(long n){
        return n > 1 ? n*factorial(n-1) : 1;
    }
}
