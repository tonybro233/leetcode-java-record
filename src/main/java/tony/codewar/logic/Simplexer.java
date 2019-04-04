package tony.codewar.logic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Simplexer implements Iterator<Token> {
    private String buffer;
    private int cursor;
    private int len;

    private static final Set<String> KEYS;
    private static final Set<Character> OPERATORS;
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    static {
        KEYS = new HashSet<>();
        KEYS.add("if");
        KEYS.add("else");
        KEYS.add("for");
        KEYS.add("while");
        KEYS.add("return");
        KEYS.add("func");
        KEYS.add("break");

        OPERATORS = new HashSet<>();
        OPERATORS.add('+');
        OPERATORS.add('-');
        OPERATORS.add('*');
        OPERATORS.add('/');
        OPERATORS.add('%');
        OPERATORS.add('(');
        OPERATORS.add(')');
        OPERATORS.add('=');
    }

    public Simplexer(String buffer) {
        this.buffer = buffer;
        this.cursor = 0;
        if (null != buffer){
            len = buffer.length();
        } else {
            len = 0;
        }
    }

    // 这种类似的分类讨论问题总是有用正则的骚操作
    // String[] types = {"integer", "boolean", "string", "operator", "keyword", "whitespace", "identifier"};
    // Matcher matcher = Pattern
    //   .compile("(\\d+)|(true|false)|(\".+\")|([-+*\\/%\\(\\)=])|(if|else|for|while|return|func|break)|(\\s+)|([\\w$]+)")
    //   .matcher(buffer == null ? "" : buffer);
    //
    // while (matcher.find()) {
    //   IntStream.rangeClosed(1, 7).forEach(x -> {
    //     if (matcher.group(x) != null) tokens.add(new Token(matcher.group(x), types[x-1]));
    //   });
    // }

    @Override
    public boolean hasNext() {
        return cursor < len;
    }

    @Override
    public Token next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        Token token = null;
        if (OPERATORS.contains(buffer.charAt(cursor))){
            token = new Token(String.valueOf(buffer.charAt(cursor++)), "operator");
        } else if ('"' == buffer.charAt(cursor)){
            int next = buffer.indexOf("\"", cursor + 1);
            if (next < 0){
                throw new IllegalArgumentException();
            }
            token = new Token(buffer.substring(cursor, next+1), "string");
            cursor = next+1;
        } else if (Character.isDigit(buffer.charAt(cursor))){
            int next = cursor+1;
            while (next < len && Character.isDigit(buffer.charAt(next))){
                next++;
            }
            token = new Token(buffer.substring(cursor, next), "integer");
            cursor = next;
        } else if (buffer.charAt(cursor) <= ' '){
            int next = cursor+1;
            while (next < len && buffer.charAt(next) <= ' '){
                next++;
            }
            token = new Token(buffer.substring(cursor, next), "whitespace");
            cursor = next;
        } else if (Character.isAlphabetic(buffer.charAt(cursor))
                || '_' == buffer.charAt(cursor)
                || '$' == buffer.charAt(cursor)) {
            int next = cursor+1;
            while (next < len && (Character.isAlphabetic(buffer.charAt(next))
                    || '_' == buffer.charAt(next)
                    || '$' == buffer.charAt(next))){
                next++;
            }
            String tok = buffer.substring(cursor, next);
            if (TRUE.equals(tok) || FALSE.equals(tok)){
                token = new Token(tok, "boolean");
            } else if (KEYS.contains(tok)){
                token = new Token(tok, "keyword");
            } else {
                token = new Token(tok, "identifier");
            }
            cursor = next;
        } else {
            throw new IllegalArgumentException();
        }

        return token;
    }
}

class Token{
    private String type;
    private String value;

    public Token(String value, String type){
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
