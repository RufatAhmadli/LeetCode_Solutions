package Medium;

public class Question1400 {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }

    public static boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        else if (n == k) return true;
        else return countChars(s) <= k;
    }

    private static int countChars(String s) {
        int count = 0;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[(s.charAt(i) - 'a') % 26]++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 == 1) count++;
        }
        return count;
    }
}
