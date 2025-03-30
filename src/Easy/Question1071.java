package Easy;

public class Question1071 {
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int startIndexOfSub=findGCD(len1,len2);
        String gcd=str1.substring(0,startIndexOfSub);
        for (int i = startIndexOfSub; i < len1; i+=startIndexOfSub) {
            if(!str1.substring(i,i+startIndexOfSub).equals(gcd)) return "";
        }
        for (int i = 0; i < len2; i+=startIndexOfSub) {
            if(!str2.substring(i,i+startIndexOfSub).equals(gcd)) return "";
        }
        return gcd;
    }

    private static int findGCD(int len1, int len2) {
        if (len1 == 0 || len2 == 0) return 0;
        while (len2 != 0) {
            int temp = len2;
            len2 = len1 % len2;
            len1 = temp;
        }
        return len1;
    }
}
