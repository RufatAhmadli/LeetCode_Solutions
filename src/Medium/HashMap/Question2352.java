package Medium.HashMap;

import java.util.*;

public class Question2352 {
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }


        int count = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> column = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                column.add(grid[i][j]);
            }
            count += rowMap.getOrDefault(column, 0);
        }

        return count;
    }
}
