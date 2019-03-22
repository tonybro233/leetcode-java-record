package tony.codewar.string;

// Move the first letter of each word to the end of it, then add "ay" to the end of the word.
// Leave punctuation marks untouched.
//
// Examples
//
// pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
// pigIt('Hello world !');     // elloHay orldway !

public class Simple_Pig_Latin {

    public static String pigIt2(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    public static String pigIt(String str) {
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String ea : strs){
            // 检查是否是标点符号串
            boolean punctuation = true;
            for (int i = 0; i < ea.length(); i++){
                int type = Character.getType(ea.charAt(i));
                if (type < 20 || type > 24){
                    punctuation = false;
                }
            }
            if (punctuation){
                sb.append(ea);
            } else {
                StringBuilder easb = new StringBuilder(ea);
                easb.deleteCharAt(0).append(ea.charAt(0)).append("ay");
                sb.append(easb);
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
