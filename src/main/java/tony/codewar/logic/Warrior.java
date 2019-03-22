package tony.codewar.logic;

import java.util.ArrayList;
import java.util.List;

public class Warrior {

    private final static String[] ranks;

    static {
        ranks = new String[11];
        ranks[0] = "Pushover";
        ranks[1] = "Novice";
        ranks[2] = "Fighter";
        ranks[3] = "Warrior";
        ranks[4] = "Veteran";
        ranks[5] = "Sage";
        ranks[6] = "Elite";
        ranks[7] = "Conqueror";
        ranks[8] = "Champion";
        ranks[9] = "Master";
        ranks[10] = "Greatest";
    }

    private int experience = 100; // 100 ~ 10000

    private int level = 1; // 1 ~ 100

    private int rank = 0; // 0 ~ 10

    private List<String> achievements = new ArrayList<>();

    public int level(){
        return this.level;
    }

    public int experience(){
        return this.experience;
    }

    public String rank(){
        return ranks[rank];
    }

    public List<String> achievements(){
        return this.achievements;
    }

    public String training(String desc, int exp, int minLevel){
        if (this.level < minLevel){
            return "Not strong enough";
        }
        achievements.add(desc);
        addExp(exp);
        return desc;
    }

    public String battle(int level){
        if (level < 1 || level > 100){
            return "Invalid level";
        }
        String msg ;
        int gained = 0;
        int diff = this.level - level;
        if (diff == 0){
            gained = 10;
            msg = "A good fight";
        } else if (diff == 1){
            gained = 5;
            msg = "A good fight";
        } else if (diff > 1){
            gained = 0;
            msg = "Easy fight";
        } else {
            diff = -diff;
            int erank = level / 10;
            if (erank - rank >= 1 && diff >= 5){
                return "You've been defeated";
            }
            gained = 20 * diff * diff;
            msg = "An intense fight";
        }

        addExp(gained);
        return msg;
    }

    private void addExp(int exp){
        experience += exp;
        if (experience > 10000){
            experience = 10000;
        }
        level = experience/100;
        rank = level / 10;
    }
}
