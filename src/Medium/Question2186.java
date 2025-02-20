package Medium;

public class Question2186 {
    public static void main(String[] args) {
        String s = "leetcode";
        String t = "coats";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(freq[i]);
        }
        return sum;
    }
}
