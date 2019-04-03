package tony.codewar.logic;

public class Matrix_Determinant {

    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1){
            return matrix[0][0];
        } else {
            int result = 0;
            boolean add = true;
            for (int i = 0; i < n;i++){
                if (add) {
                    result += matrix[0][i] * determinant(split(matrix, i));
                } else {
                    result -= matrix[0][i] * determinant(split(matrix, i));
                }
                add = !add;
            }
            return result;
        }
    }

    private static int[][] split(int[][] matrix, int x){
        int n = matrix.length;
        if (n == 1){
            return null;
        }
        int[][] result = new int[n-1][n-1];
        for (int i = 1; i < n;i++){
            int k = 0;
            for (int j = 0; j < n; j++){
                if (j != x){
                    result[i-1][k++] = matrix[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] m = new int[][]{{1, 3}, {2,5}};
        System.out.println(determinant(m));
    }
}
