package tony.sword_to_offer;

// 66. 构建乘积数组
// 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
// 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
// 示例:
// 输入: [1,2,3,4,5]
// 输出: [120,60,40,30,24]

import java.util.Arrays;

public class _66_construct_arr {

    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        int[] beforeMulti = new int[len];
        int[] afterMulti = new int[len];
        beforeMulti[0] = 1;
        afterMulti[len - 1] = 1;

        for (int i = 1;i < len;i++) {
            beforeMulti[i] = beforeMulti[i - 1] * a[i - 1];
            afterMulti[len - 1 - i] = afterMulti[len - i] * a[len - i];
        }

        int[] result = new int[len];
        for (int i = 0;i < len;i++) {
            result[i] = beforeMulti[i] * afterMulti[i];
        }
        return result;
    }

    public int[] constructArr3(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        int[] result = new int[len];
        Arrays.fill(result, 1);

        for (int i = 0, p1 = 1, p2 = 1; i < len;i++) {
            result[i] *= p1;
            p1 *= a[i];

            result[len - 1 - i] *= p2;
            p2 *= a[len - 1 - i];
        }

        return result;
    }

    // O(n2) 超时
    public int[] constructArr2(int[] a) {
        int[] result = new int[a.length];
        Arrays.fill(result, 1);

        for (int i = 0;i < a.length;i++) {
            for (int j = 0; j < a.length;j++) {
                if (j != i) {
                    result[j] *= a[i];
                }
            }
        }

        return result;
    }

}
