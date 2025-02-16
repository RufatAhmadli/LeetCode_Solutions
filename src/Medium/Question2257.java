package Medium;

public class Question2257 {
    private int unguarded;

    public static void main(String[] args) {
        Question2257 countUnguarded = new Question2257();
        int[][] guards = new int[][]{{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = new int[][]{{0, 1}, {2, 2}, {1, 4}};
        int m = 4;
        int n = 6;
        System.out.println(countUnguarded.countUnguarded(m, n, guards, walls));

    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        unguarded = m * n;


        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
            unguarded--;
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
            unguarded--;
        }


        for (int[] guard : guards) {
            markDirection(grid, guard[0], guard[1], m, n, 1, 0);
            markDirection(grid, guard[0], guard[1], m, n, -1, 0);
            markDirection(grid, guard[0], guard[1], m, n, 0, 1);
            markDirection(grid, guard[0], guard[1], m, n, 0, -1);
        }

        return unguarded;
    }

    private void markDirection(int[][] grid, int row, int col, int m, int n, int rowInc, int colInc) {
        int r = row + rowInc, c = col + colInc;

        while (r >= 0 && r < m && c >= 0 && c < n) {
            if (grid[r][c] == -1 || grid[r][c] == 2) {
                break;
            }
            if (grid[r][c] == 0) {
                unguarded--;
                grid[r][c] = 1;
            }
            r += rowInc;
            c += colInc;
        }
    }

}
