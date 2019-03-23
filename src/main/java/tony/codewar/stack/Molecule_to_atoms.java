package tony.codewar.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// String water = "H2O";
// parseMolecule.getAtoms(water); // return [H: 2, O: 1]
//
// String magnesiumHydroxide = "Mg(OH)2";
// parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]
//
// String fremySalt = "K4[ON(SO3)2]2";
// parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

// parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException

public class Molecule_to_atoms {

    public static Map<String,Integer> getAtoms(String formula) {
        Map<String, Integer> cmap = new HashMap<>();
        String atom = null;
        Deque<Map<String, Integer>> deque = new LinkedList<>();
        Deque<Character> puncQue = new LinkedList<>();
        char[] chars = formula.toCharArray();
        int cursor = 0;
        while (cursor < chars.length){
            if (Character.isUpperCase(chars[cursor])){
                if (cursor < chars.length-1 && Character.isLowerCase(chars[cursor+1])){
                    atom = new String(chars,cursor,2);
                    cursor += 2;
                } else {
                    atom = Character.toString(chars[cursor++]);
                }
                if (cursor == chars.length){
                    cmap.put(atom, cmap.getOrDefault(atom, 0)+1);
                    break;
                }
                int num = 0;
                if (Character.isDigit(chars[cursor])){
                    while (cursor < chars.length && Character.isDigit(chars[cursor])){
                        num = num*10 + (chars[cursor++] - '0');
                    }
                } else {
                    num = 1;
                }
                cmap.put(atom, cmap.getOrDefault(atom, 0)+num);
            } else if (Character.getType(chars[cursor]) == Character.END_PUNCTUATION){
                char end = chars[cursor];
                cursor++;
                int num = 0;
                if (cursor < chars.length && Character.isDigit(chars[cursor])){
                    while (cursor < chars.length && Character.isDigit(chars[cursor])){
                        num = num*10 + (chars[cursor++] - '0');
                    }
                } else {
                    num = 1;
                }
                Map<String, Integer> last = deque.pollLast();
                Character start = puncQue.pollLast();
                if (null == last){
                    throw new IllegalArgumentException();
                }
                judgePunc(start, end);
                for (Map.Entry<String, Integer> entry : cmap.entrySet()) {
                    last.put(entry.getKey(), last.getOrDefault(entry.getKey(), 0) + entry.getValue() * num);
                }
                cmap = last;
            } else if (Character.getType(chars[cursor]) == Character.START_PUNCTUATION){
                puncQue.addLast(chars[cursor]);
                deque.addLast(cmap);
                cmap = new HashMap<>();
                cursor++;
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (deque.size() > 0){
            throw new IllegalArgumentException();
        }

        return cmap;
    }

    private static void judgePunc(char start, char end){
        if (start == '('){
           if (end != ')'){
               throw new IllegalArgumentException();
           }
        } else if (start == '['){
            if (end != ']'){
                throw new IllegalArgumentException();
            }
        } else if (start == '{'){
            if (end != '}'){
                throw new IllegalArgumentException();
            }
        }

    }

    public static void main(String[] args){
        Map<String, Integer> atoms = getAtoms("Mg(OH)2");
        System.out.println(atoms);
    }
}
