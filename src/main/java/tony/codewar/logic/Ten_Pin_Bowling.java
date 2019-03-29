package tony.codewar.logic;

import java.util.Arrays;

// In this challenge you will be given a string representing a player's ten frames.
// It will look something like this: 'X X 9/ 80 X X 90 8/ 7/ 44' (in Java: "X X 9/ 80 X X 90 8/ 7/ 44"),
// where each frame is space-delimited, 'X' represents strikes, and '/' represents spares.
// Your goal is take in this string of frames into a function called bowlingScore and return
// the players total score.

// On the 10th or last frame a player will receive an extra roll each time they get all ten pins
// down to a maximum of three total rolls. Also on the last frame bonuses are not awarded for strikes
// and spares moving forward.

// Strikes Represented in this challenge as 'X'. In the first 9 frames this will conclude the players
// turn and it will be scored as 10 points plus the points received from the next two rolls.

// Spares Represented in this challenge as '/'. In the first 9 frames this will be scored as 10 points
// plus the next roll.

public class Ten_Pin_Bowling {

    public static int bowling_score(String frames) {
        String[] split = frames.split(" ");
        int strikes = 0;
        for (String ea : split){
            strikes += ea.length();
        }
        int[] bonus = new int[strikes];
        Arrays.fill(bonus, 1);

        int total = 0;
        int cursor = 0;
        for (int i = 0; i < 9; i++){
            if ("X".equals(split[i])){
                total += 10 * bonus[cursor];
                bonus[cursor+1]++;
                bonus[cursor+2]++;
                cursor++;
            } else {
                int first = 0, second = 0;
                if (split[i].charAt(1) == '/'){
                    first = split[i].charAt(0) - '0';
                    second = 10 - first;
                    bonus[cursor+2]++;
                } else {
                    first = split[i].charAt(0) - '0';
                    second = split[i].charAt(1) - '0';
                }
                total += bonus[cursor] * first;
                total += bonus[cursor+1] * second;
                cursor += 2;
            }
        }

        char[] chars = split[9].toCharArray();
        for (int i = 0; i < chars.length;i++){
            char ea = chars[i];
            if (ea == 'X'){
                total += bonus[cursor++] * 10;
            } else if (ea == '/'){
                total += bonus[cursor++] * (10 - (chars[i-1]-'0'));
            } else {
                total += bonus[cursor++] * (chars[i]-'0');
            }
        }

        return total;
    }
}
