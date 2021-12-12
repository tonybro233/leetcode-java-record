package tony.leetcode.feature.binary_search;

// 278. 第一个错误的版本
// 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
// 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
// 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
//
// 示例:
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
// 调用 isBadVersion(3) -> false
// 调用 isBadVersion(5) -> true
// 调用 isBadVersion(4) -> true
// 所以，4 是第一个错误的版本。

public class First_Bad_Version {
    public int firstBadVersion(int n) {
        long low = 1, high = n, mid = 0; // 相加有可能越界
        while (low <= high) {
            mid = (low + high) / 2;
            if (isBadVersion((int) mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    // 这样更好一些
    public int firstBadVersion2(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean isBadVersion(int n) {
        // fake for oj
        return true;
    }
}
