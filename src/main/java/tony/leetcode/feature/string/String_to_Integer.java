package tony.leetcode.feature.string;

public class String_to_Integer {

    public static void main(String[] args){
        String_to_Integer go = new String_to_Integer();
        int re = go.myAtoi("9223372036854775808");
        System.out.println(re);
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();

        int b = 1;
        int st = 0;
        if (!Character.isDigit(chars[0])){
            if ('-' == chars[0]){
                b = -1;
                st = 1;
            }
            else if ('+' == chars[0]){
                st = 1;
            }
            else{
                return 0;
            }
        }
        long val = 0;
        int br = 0;
        for (int i = st; i < chars.length;i++ ){
            char c = chars[i];
            if (!Character.isDigit(c))
                break;
            val = val*10 + (c - '0');

            if (c != '0' || br != 0) // 提前判断退出循环（超过Long最大值产生错误），而且有可能前面有很多 0
                br++;

            if (br > 12)
                break;
        }
        val = b * val;
        if(val > Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        if (val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)val;
    }
}
