package tony.sword_to_offer;

// 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
// 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中
// 读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//
// 例如，
// [2,3,4] 的中位数是 3
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构：
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。

import java.util.Comparator;
import java.util.PriorityQueue;

public class _41_median_of_data_stream {

    class MedianFinder {

        // 大顶
        private PriorityQueue<Integer> left;

        // 小顶
        private PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>(Comparator.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (left.size() < right.size()) {
                // 向左添加
                if (num > right.peek()) {
                    right.add(num);
                    left.add(right.poll());
                } else {
                    left.add(num);
                }
            } else {
                // 向右添加
                if (null != left.peek() && num >= left.peek()) {
                    right.add(num);
                } else {
                    left.add(num);
                    right.add(left.poll());
                }
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return right.peek();
            }
        }

    }

}
