package tony.util;

import java.util.ArrayList;
import java.util.List;

/**
 * NestedInteger for Leetcode problem: Flatten Nested List Iterator
 * ex:
 *      [[1,1],2,[1,1]]
 *      [1,[4,[6]]]
 * Related Problem:
 *     #341 - Flatten Nested List Iterator
 *     #385 - Mini Parser
 *
 */
public class NestedInteger {

    public Integer num = null;

    public List<NestedInteger> nums = null;

    public NestedInteger() {
        nums = new ArrayList<NestedInteger>();
    }

    public NestedInteger(int num) {
        this.num = num;
    }

    public boolean isInteger() {
        return nums == null;
    }

    public Integer getInteger() {
        return num;
    }

    public List<NestedInteger> getList() {
        return nums;
    }

    public boolean add(NestedInteger n) {
        if (isInteger()) {
            return false;
        } else {
            nums.add(n);
            return true;
        }
    }

    /** Serialization */
    @Override
    public String toString() {
        if (isInteger()) {
            return "" + num;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (NestedInteger ni : nums) {
                sb.append(ni.toString());
                sb.append(",");
            }
            int len = sb.length();
            sb.delete(len-1,len);
            sb.append("]");
            return sb.toString();
        }
    }
}
