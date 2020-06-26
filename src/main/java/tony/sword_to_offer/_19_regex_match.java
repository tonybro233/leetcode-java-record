package tony.sword_to_offer;

// 19. 正则表达式匹配
// 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

public class _19_regex_match {

    public boolean isMatch(String s, String p) {
        if (null == s || null == p ) {
            return false;
        }

        return matchCore(s, p, 0, 0);
    }

    private boolean matchCore(String s, String pattern, int sid, int pid) {
        if (sid == s.length() && pid == pattern.length()) {
            return true;
        }

        if (sid != s.length() && pid == pattern.length()) {
            return false;
        }

        boolean equal = sid < s.length() && s.charAt(sid) == pattern.charAt(pid);

        if (pid < pattern.length() - 1 && pattern.charAt(pid + 1) == '*') {
            if (equal || (pattern.charAt(pid) == '.' && sid != s.length())) {
                return matchCore(s, pattern, sid, pid + 2) ||
                        matchCore(s, pattern, sid + 1, pid) ||
                        matchCore(s, pattern, sid + 1, pid + 2);
            } else {
                return matchCore(s, pattern, sid, pid + 2);
            }
        } else {
            if (pattern.charAt(pid) == '.' && sid != s.length()) {
                return matchCore(s, pattern, sid + 1, pid + 1);
            } else {
                return equal && matchCore(s, pattern, sid + 1, pid + 1);
            }
        }

    }

    public static void main(String[] args) {
        boolean match = new _19_regex_match().isMatch("", ".*");
        System.out.println(match);
    }

}
