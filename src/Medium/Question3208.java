package Medium;

public class Question3208 {
    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isAlternating(colors, i, k, n)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isAlternating(int[] colors, int start, int k, int n) {
        for (int i = start; i < start + k - 1; i++) {
            if (colors[i % n] == colors[(i + 1) % n]) {
                return false;
            }
        }
        return true;
    }
    //time limit exceeded
}
