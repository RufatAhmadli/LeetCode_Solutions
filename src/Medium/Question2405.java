package Medium;

public class Question2405 {
    public static void main(String[] args) {
        String s1 = "abacaba";
        String s2 = "ssssss";
        System.out.println(partitionString(s1));
        System.out.println(partitionString(s2));
    }

    public static int partitionString(String s) {
        int n = s.length();
        int count = 0;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1) {
                count++;
                freq = new int[26];
                freq[c - 'a']++;
            }
        }
        return count+1;
    }
}
