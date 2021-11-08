import java.util.Arrays;

public class Sudoku {

    private int N;
    private int[][] grid;

    Sudoku(int n){
      this.N = n;
      this.grid = new int[n][n];
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku(9);
        if(s.solve())
            s.display();
        else 
            System.out.println("Cannot be solved");
    }

    private void display() {
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean solve() {
        int[] emptySlot = findEmptySlot();
        int row = emptySlot[0];
        int col = emptySlot[1];
        
        if(row == N && col == N) return true;
        
        for (int i = 1; i <= N; i++) {
            if(valid(row, col, i)){
                grid[row][col] = i;

                if(solve())
                    return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private boolean valid(int row, int col, int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] != 0 && (isInRow(row, col, num) || isInCol(row, col, num) || isInBox(row, col, num))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isInBox(int row, int col, int num) {
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if(i != row && j != col && grid[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInCol(int row, int col, int num) {
        for (int i = 0; i < N; i++) {
            if (i != row && grid[i][col] == num){
                return true;
            }
        }
        return false;
    }

    private boolean isInRow(int row, int col, int num) {
        for (int i = 0; i < N; i++) {
            if (i != col && grid[row][i] == num){
                return true;
            }
        }
        return false;
    }

    private int[] findEmptySlot() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{N,N};
    }
}
