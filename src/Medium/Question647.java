package Medium;

public class Question647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abbaba"));
        System.out.println(new Question647().countSubstrings2("abab"));
        System.out.println(new Question647().countSubstrings3("abbaba"));
    }

    // dp approach
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (dp[i][i + 1]) ans++;
        }

        for (int j = 3; j <= n; j++) {
            for (int k = 0, m = j - 1; m < n; k++, m++) {
                dp[k][m] = (s.charAt(k) == s.charAt(m)) && dp[k + 1][m - 1];
                if (dp[k][m]) ans++;
            }
        }
        return ans;
    }

    //center expansion
    public int countSubstrings2(String s) {
        int count = 0;
        int n = s.length();

        // For each possible center position
        for (int i = 0; i < n; i++) {
            // Case 1: Odd length palindromes (single character center)
            // Example: "aba" with center at 'b'
            count += expandAroundCenter(s, i, i);

            // Case 2: Even length palindromes (two character center)
            // Example: "abba" with center between two 'b's
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }


    private int expandAroundCenter(String s, int left, int right) {
        int palindromeCount = 0;

        // Expand outward while characters match and within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromeCount++;  // Found a palindrome
            left--;
            right++;
        }

        return palindromeCount;
    }

    // Manacher's algorithm
    public int countSubstrings3(String s) {
        // Step 1: Transform string to handle even-length palindromes
        String t = preprocessString(s);
        int n = t.length();

        // Array to store palindrome radius at each position
        int[] p = new int[n];

        int center = 0;  // Center of the rightmost palindrome
        int right = 0;   // Right boundary of the rightmost palindrome

        // Step 2: Build palindrome radius array using Manacher's algorithm
        for (int i = 0; i < n; i++) {
            // Mirror of i with respect to center
            int mirror = 2 * center - i;

            // Use previously computed values if within right boundary
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Try to expand palindrome centered at i
            int left = i - (p[i] + 1);
            int r = i + (p[i] + 1);

            while (left >= 0 && r < n && t.charAt(left) == t.charAt(r)) {
                p[i]++;
                left--;
                r++;
            }

            // Update center and right boundary if current palindrome extends further
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        // Step 3: Count all palindromic substrings
        int count = 0;
        for (int i = 0; i < n; i++) {
            // Each radius value represents number of palindromes centered at i
            // We divide by 2 and round up because of the '#' characters
            count += (p[i] + 1) / 2;
        }

        return count;
    }

    /**
     * Preprocess string by inserting '#' between characters.
     * This allows us to handle both odd and even length palindromes uniformly
     * Example: "abc" -> "#a#b#c#"
     *          "aa"  -> "#a#a#"
     *
     * @param s original string
     * @return transformed string
     */
    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }
        return sb.toString();
    }

}
