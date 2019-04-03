package tony.codewar.logic;

public class BattleField {

    public static boolean fieldValidator(int[][] field) {
        int battleShip = 1, cruiser = 2, destroy = 3, submarine = 4;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (!check(field, i, j)){
                    return false;
                }
                if (field[i][j] <= 0){
                    continue;
                }
                int l = extend(field, i, j);
                if (l == 4){
                    battleShip--;
                    if (battleShip < 0){
                        return false;
                    }
                } else if (l == 3){
                    cruiser--;
                    if (cruiser < 0){
                        return false;
                    }
                } else if (l == 2){
                    destroy--;
                    if (destroy < 0){
                        return false;
                    }
                } else if (l == 1){
                    submarine--;
                    if (submarine < 0){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return battleShip == 0 && cruiser == 0 && destroy == 0 && submarine == 0;
    }

    private static boolean check(int[][] field, int x, int y){
        boolean horizontal = false, vertical = false;
        if (field[x][y] == 0){
            return true;
        }
        // 不能是对角线
        try {
            if (field[x+1][y+1] != 0){
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (field[x-1][y-1] != 0){
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (field[x+1][y-1] != 0){
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (field[x-1][y+1] != 0){
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ignore){}
        // 不能相交
        if ((x < 9 && field[x+1][y] != 0) || (x > 0 && field[x-1][y] != 0)){
            vertical = true;
        }
        if ((y < 9 && field[x][y+1] != 0) || (y > 0 && field[x][y-1] != 0)){
            horizontal = true;
        }
        return !vertical || !horizontal;
    }

    private static int extend(int[][] field, int x, int y){
        int l = 0;
        if (x < 9 && field[x+1][y] == 1){
            while (x <= 9 && field[x][y] == 1){
                field[x][y] = -1;
                l++;
                x++;
            }
        } else if (y < 9 && field[x][y+1] == 1){
            while (y <= 9 && field[x][y] == 1){
                field[x][y] = -1;
                l++;
                y++;
            }
        } else {
            field[x][y] = -1;
            l = 1;
        }
        return l;
    }
}
