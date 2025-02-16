package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question1408 {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(words));
        System.out.println(stringMatching2(words));
        String s="A man, a plan, a canal: Panama";
        System.out.println(s.replaceAll("[^a-zA-Z]","").toLowerCase());
    }
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(seen[j]) continue;
                if(i!=j && KMPSearch(words[i], words[j])) {
                    result.add(words[j]);
                    seen[j] = true;
                }
            }
        }
        return result;
    }

    private static boolean KMPSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        // Preprocess the pattern to create the LPS array
        int[] lps = computeLPSArray(pattern);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Method to compute the LPS array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS[0] is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static List<String> stringMatching2(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(seen[j]) continue;
                if(i!=j){
                    if(words[i].contains(words[j])) {
                        result.add(words[j]);
                        seen[j] = true;
                    }
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s) {
        String modifiedStr=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        if(modifiedStr.equals(new StringBuilder(modifiedStr).reverse().toString()))return true;
        return false;
    }
}
