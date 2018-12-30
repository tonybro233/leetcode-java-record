package tony.leetcode.feature.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 385. 迷你语法分析器
// 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
// 列表中的每个元素只可能是整数或整数嵌套列表

// 提示：你可以假定这些字符串都是格式良好的：
// 字符串非空
// 字符串不包含空格
// 字符串只包含数字0-9、'[' 、 ',' 、'-' 、 ']'
//
// 示例 1：
// 给定 s = "324",
// 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
//
// 示例 2：
// 给定 s = "[123,[456,[789]]]",
// 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
// 1. 一个 integer 包含值 123
// 2. 一个包含两个元素的嵌套列表：
//     i.  一个 integer 包含值 456
//     ii. 一个包含一个元素的嵌套列表
//          a. 一个 integer 包含值 789

public class Mini_Parser {

    // 题目没看清，一开始以为单元素对象可以转变为列表对象，直接走偏了
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new LinkedList<>();
        char[] chars = s.toCharArray();

        boolean negative = false;
        Integer num = null;
        NestedInteger current = null;
        for (int i = 0; i < chars.length; i++){
            if ('[' == chars[i]){
                stack.addLast(new NestedInteger());
                current = null;
            } else if (',' == chars[i]){
                NestedInteger last = stack.peekLast();
                if (null != num){
                    last.add(new NestedInteger(num));
                    num = null;
                } else if (null != current){
                    last.add(current);
                }
                current = null;
            } else if (']' == chars[i]){
                NestedInteger last = stack.pollLast();
                if (null != num){
                    last.add(new NestedInteger(num));
                    num = null;
                } else if (null != current){
                    last.add(current);
                }
                current = last;
            } else if ('-' == chars[i]) {
                negative = true;
            } else {
                if (num == null){
                    if (!negative) {
                        num = chars[i] - '0';
                    } else {
                        num = - chars[i] + '0';
                        negative = false;
                    }
                } else {
                    if (num > 0) {
                        num = num * 10 + (chars[i] - '0');
                    } else {
                        num = num * 10 - (chars[i] - '0');
                    }
                }
            }
        }

        if (null != num){
            if (null == current){
                current = new NestedInteger(num);
            } else {
                current.add(new NestedInteger(num));
            }
        }

        return current;
    }

    // fake class for coding
    public class NestedInteger {
        // Constructor initializes an empty nested list. 看清楚了默认是个列表对象
        public NestedInteger(){}

        // Constructor initializes a single integer.
        public NestedInteger(int value){}

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return null;
        }
    }

}


