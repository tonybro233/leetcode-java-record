package tony.sword_to_offer;

// 40. 最小的k个数
// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
// 则最小的4个数字是1、2、3、4。
//
// 示例 1：
// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]

// 示例 2：
// 输入：arr = [0,1,2,1], k = 1
// 输出：[0]

import java.util.Arrays;

public class _40_kth_smallest {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 另外还可以使用容量为k的大顶堆
        if (k > arr.length) {
            throw new IllegalArgumentException();
        } else if (k == arr.length) {
            return arr;
        } else if (k == 0) {
            return new int[0];
        }

        int start = 0, end = arr.length - 1;
        int idx = partition(arr, start, end);
        while (idx != k - 1) {
            if (idx > k - 1) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
            idx = partition(arr, start, end);
        }

        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        int val = arr[mid];
        exch(arr, mid, end);
        int pivot = start - 1;
        for (int i = start; i <= end;i++) {
            if (arr[i] <= val) {
                pivot++;
                if (i > pivot) {
                    exch(arr, pivot, i);
                }
            }
        }
        return pivot;
    }

    private void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
