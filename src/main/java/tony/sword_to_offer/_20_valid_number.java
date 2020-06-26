package tony.sword_to_offer;

// 20. 表示数值的字符串
// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
// 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

public class _20_valid_number {

    // .e1 = false
    // 2.e1 = true
    // 005047e+6 = true

    public boolean isNumber(String s) {
        if (null == s) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        int idx = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            idx = 1;
            if (idx == chars.length) {
                return false;
            }
        }

        // A . B e|E C
        int stage = 0;
        Character last = null;
        for (;idx < chars.length;idx++) {
            if (stage == 0) {
                if (chars[idx] == '.') {
                    if (null == last && (idx == chars.length - 1 || !Character.isDigit(chars[idx + 1]))) {
                        return false;
                    }
                    stage = 1;
                } else if (chars[idx] == 'e' || chars[idx] == 'E') {
                    if (null == last || idx == chars.length - 1) {
                        return false;
                    } else if (chars[idx+1] == '+' || chars[idx+1] == '-') {
                        idx++;
                        if (idx == chars.length - 1) {
                            return false;
                        }
                    } else {
                        stage = 2;
                    }
                } else if (!Character.isDigit(chars[idx])) {
                    return false;
                }
            } else if (stage == 1) {
                if (chars[idx] == 'e' || chars[idx] == 'E') {
                    if (idx == chars.length - 1) {
                        return false;
                    } else if (chars[idx+1] == '+' || chars[idx+1] == '-') {
                        idx++;
                        if (idx == chars.length - 1) {
                            return false;
                        }
                    } else {
                        stage = 2;
                    }
                } else if (!Character.isDigit(chars[idx])) {
                    return false;
                }
            } else {
                if (!Character.isDigit(chars[idx])) {
                    return false;
                }
            }
            last = chars[idx];
        }

        return true;
    }

}
