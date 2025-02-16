package Medium;

import java.util.Arrays;

public class Question1769 {
    public static void main(String[] args) {
        String s="110";
        int[] res=minOperations(s);
        System.out.println(Arrays.toString(res));
    }
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int operations = 0, balls = 0;

        // Left to right pass
        for (int i = 0; i < n; i++) {
            answer[i] = operations;
            balls += boxes.charAt(i) - '0'; // Add the number of balls in the current box
            operations += balls; // Update operations for the next box
        }

        operations = 0;
        balls = 0;

        // Right to left pass
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            balls += boxes.charAt(i) - '0'; // Add the number of balls in the current box
            operations += balls; // Update operations for the previous box
        }

        return answer;
    }
}
