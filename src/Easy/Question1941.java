package Easy;

public class Question1941 {
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(areOccurrencesEqual(s));
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int prev = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && prev != 0 && freq[i] != prev) {
                return false;
            }
            if (freq[i] > 0) {
                prev = freq[i];
            }
        }
        return true;
    }
}
