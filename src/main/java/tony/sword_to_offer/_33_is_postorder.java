package tony.sword_to_offer;

// 33. 二叉搜索树的后序遍历序列
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
// 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

import java.util.ArrayList;
import java.util.List;

public class _33_is_postorder {

    public boolean verifyPostorder(int[] postorder) {
        List<Integer> list = new ArrayList<>(postorder.length);
        for (int i : postorder) {
            list.add(i);
        }

        return check(list);
    }

    private boolean check(List<Integer> list) {
        if (list.size() < 2) {
            return true;
        }

        int root = list.get(list.size() - 1);
        Integer idx = null;
        for (int i = 0; i < list.size() - 1;i++) {
            if (null == idx) {
                if (list.get(i) > root) {
                    idx = i;
                }
            } else {
                // 右子树存在小于root
                if (list.get(i) < root) {
                    return false;
                }
            }
        }

        if (null == idx) {
            // 只有右子树
            return check(list.subList(0, list.size() - 1));
        } else {
            return check(list.subList(0, idx)) && check(list.subList(idx, list.size() - 1));
        }
    }

}
