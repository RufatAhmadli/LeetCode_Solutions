package Medium;

public class Question3228 {
    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }

    public static int maxOperations(String s) {
        int res = 0;
        int onesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else if (i > 0 && s.charAt(i) == '0' && s.charAt(i - 1) == '1') {
                res += onesCount;
            }
        }

        return res;
    }
}
