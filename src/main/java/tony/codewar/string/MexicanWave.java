package tony.codewar.string;

import java.util.ArrayList;
import java.util.List;

// 1.  The input string will always be lower case but maybe empty.
// 2.  If the character in the string is whitespace then pass over it as if it was an empty seat.

// wave("hello") => ["Hello", "hEllo", "heLlo", "helLo", "hellO"]

public class MexicanWave {

    public static String[] wave(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == ' '){
                continue;
            }
            char[] chars = str.toCharArray();
            chars[i] = Character.toUpperCase(chars[i]);
            list.add(new String(chars));
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
