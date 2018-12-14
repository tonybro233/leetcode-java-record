package tony.leetcode.level.simple;

// 409
// 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

public class Longest_Palindrome {

    public static void main(String[] args){
        int aaaAaaaa = new Longest_Palindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println(aaaAaaaa);
    }


    // 26个字母，记住了
    public int longestPalindrome(String s) {
        int[] record = new int[52];
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars){
            if ('Z' - c >= 0){
                record[c-'A'+26]++;
                if (record[c-'A'+26] % 2 == 0){
                    count += 2;
                }
            } else {
                record[c-'a']++;
                if (record[c-'a'] % 2 == 0){
                    count += 2;
                }
            }
        }
        if (count < chars.length){
            count++;
        }
        return count;
    }
}
