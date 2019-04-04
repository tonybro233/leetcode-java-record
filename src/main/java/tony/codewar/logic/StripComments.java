package tony.codewar.logic;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines){
            int pos = Integer.MAX_VALUE;
            for (String sym : commentSymbols){
                int ea = line.indexOf(sym);
                if (ea != -1){
                    pos = Math.min(ea , pos);
                }
            }
            if (pos != Integer.MAX_VALUE){
                line = line.substring(0, pos);
            }
            if (line.length() > 0 && line.charAt(line.length()-1) == ' '){
                int len = line.length();
                while ((0 < len) && (line.charAt(len - 1) <= ' ')) {
                    len--;
                }
                line = line.substring(0, len);
            }
            sb.append(line).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args){
        String s = stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"});
        System.out.println(s);
        System.out.println(Character.getType('I') == Character.LETTER_NUMBER);
    }
}
