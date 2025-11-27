package Medium;

public class Question3751 {
    public static void main(String[] args) {
        System.out.println(totalWaviness(4848, 4848));
    }

    public static int totalWaviness(int num1, int num2) {
        if (String.valueOf(num1).length() == 2 && String.valueOf(num2).length() == 2) return 0;
        int wave = 0;
        for (int i = num1; i <= num2; i++) {
            String str = String.valueOf(i);
            int n = str.length();
            if (n == 2) continue;
            for (int j = 1; j < n - 1; j++) {
                char curr = str.charAt(j);
                char next = str.charAt(j + 1);
                char prev = str.charAt(j - 1);
                if ((curr > prev && curr > next) || (curr < prev && curr < next)) wave++;
            }
        }
        return wave;
    } //brute force
}
