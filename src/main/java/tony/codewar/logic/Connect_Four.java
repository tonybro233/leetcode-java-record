package tony.codewar.logic;

import java.util.Arrays;
import java.util.List;

public class Connect_Four {

    public static String whoIsWinner(List<String> piecesPositionList) {
        // retrun "Red" or "Yellow" or "Draw"
        int[] xs = new int[7];
        Arrays.fill(xs, 5);
        int[][] board = new int[6][7];
        for (String ea : piecesPositionList){
            String[] split = ea.split("_");
            int y = split[0].charAt(0) - 'A';
            int x = xs[y];
            xs[y]--;
            int color = "Red".equals(split[1]) ? 1 : 2;
            int result = checkWin(board, x, y, color);
            if (result != 0){
                return result == 1 ? "Red" : "Yellow";
            }
        }

        return "Draw";
    }

    private static int checkWin(int[][] board, int x, int y, int color){
        board[x][y] = color;
        // 向下相连
        try {
            if (board[x+1][y] == color && board[x+2][y] == color && board[x+3][y] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        // 对角线1
        try {
            if (board[x+1][y+1] == color && board[x+2][y+2] == color && board[x+3][y+3] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-1][y-1] == color && board[x+1][y+1] == color && board[x+2][y+2] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-2][y-2] == color && board[x-1][y-1] == color && board[x+1][y+1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-3][y-3] == color && board[x-2][y-2] == color && board[x-1][y-1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        // 对角线2
        try {
            if (board[x+1][y-1] == color && board[x+2][y-2] == color && board[x+3][y-3] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-1][y+1] == color && board[x+1][y-1] == color && board[x+2][y-2] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-2][y+2] == color && board[x-1][y+1] == color && board[x+1][y-1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x-3][y+3] == color && board[x-2][y+2] == color && board[x-1][y+1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        // 横向相连
        try {
            if (board[x][y+1] == color && board[x][y+2] == color && board[x][y+3] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x][y-1] == color && board[x][y+1] == color && board[x][y+2] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x][y-2] == color && board[x][y-1] == color && board[x][y+1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}
        try {
            if (board[x][y-3] == color && board[x][y-2] == color && board[x][y-1] == color){
                return color;
            }
        }catch (ArrayIndexOutOfBoundsException ignore){}

        return 0;
    }
}
