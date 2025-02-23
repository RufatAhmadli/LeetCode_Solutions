package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1380 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        };
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[] minRowNumbers = new int[n];
        int[] maxColumnNumbers = new int[m];

        for (int i = 0; i < n; i++) {
            int row = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < row) row = matrix[i][j];
                if (matrix[i][j] > maxColumnNumbers[j]) maxColumnNumbers[j] = matrix[i][j];
            }
            minRowNumbers[i] = row;
        }
//        System.out.println(Arrays.toString(minRowNumbers));
//        System.out.println(Arrays.toString(maxColumnNumbers));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(minRowNumbers[i]==maxColumnNumbers[j]) res.add(matrix[i][j]);
            }
        }
        return res;
    }

}
