package tony.leetcode.feature.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

// 71. 简化路径
// 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
// 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
// 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
// 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
//
// 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
// 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

// 示例 1：
// 输入："/home/"
// 输出："/home"
// 解释：注意，最后一个目录名后面没有斜杠。

// 示例 2：
// 输入："/../"
// 输出："/"
// 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。

// 示例 3：
// 输入："/home//foo/"
// 输出："/home/foo"
// 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

// 示例 4：
// 输入："/a/./b/../../c/"
// 输出："/c"

// 示例 5：
// 输入："/a/../../b/../c//.//"
// 输出："/c"

// 示例 6：
// 输入："/a//b////c/d//././/.."
// 输出："/a/b/c"

public class Simplify_Path {

    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        Deque<String> folders = new ArrayDeque<>();
        for (int i = 0; i < chars.length;i++){
            if (chars[i] == '/'){
                if (folders.size() == 0){
                    folders.addLast("/");
                }
            } else if (chars[i] == '.'){
                if (i+1 < chars.length && chars[i+1] == '.'){
                    if (i + 2 < chars.length && chars[i+2] != '/'){
                        // '...' , '..xxx'  wtf ？
                        StringBuilder sb = new StringBuilder();
                        while (i < chars.length && chars[i] != '/'){
                            sb.append(chars[i++]);
                        }
                        folders.addLast(sb.toString());
                    } else {
                        if (folders.size() > 1) {
                            folders.pollLast();
                        }
                        i++;
                    }
                } else if (i + 1 < chars.length && chars[i + 1] != '/') {
                    // '.xxx' wtf ？
                    StringBuilder sb = new StringBuilder();
                    while (i < chars.length && chars[i] != '/'){
                        sb.append(chars[i++]);
                    }
                    folders.addLast(sb.toString());
                } else {
                    // just pass '/./'
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && chars[i] != '/' && chars[i] != '.'){
                    sb.append(chars[i++]);
                }
                folders.addLast(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(folders.pollFirst());
        while (folders.size() > 1){
            result.append(folders.pollFirst());
            result.append('/');
        }
        if (null != folders.peekFirst()){
            result.append(folders.pollFirst());
        }

        return result.toString();
    }

    // 使用split..
    public String simplifyPath2(String path) {
        LinkedList<String> tmp = new LinkedList<String>();
        tmp.add("/");
        String[] words = path.split("/");
        for(String word:words){
            if(".".equals(word)){
                continue;
            }else if("..".equals(word)){
                tmp.removeLast();
                if(tmp.size()==0){
                    tmp.add("/");
                }
            }else if("".equals(word)){
                continue;
            }else{
                tmp.add(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = tmp.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            sb.append(s);
            if(!"/".equals(s)&&iterator.hasNext()){
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
