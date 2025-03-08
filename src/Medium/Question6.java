package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        List<List<Integer>> patterns = new ArrayList<>();
        int n = s.length();
        int dif = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(i);
            patterns.add(row);
        }
        int identifier = 0;
        int counter = n - numRows;
        while (counter > 0) {
            identifier += dif;
            for (List<Integer> row : patterns) {
                int num = row.getLast();
                if (identifier - num > num && identifier - num < n) {
                    row.add(identifier - num);
                    counter--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Integer> row : patterns) {
            for (Integer i : row) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
