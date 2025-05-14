package Easy;

import java.util.Arrays;

public class Question389 {
    public static void main(String[] args) {
        String s = "dbca";
        String t = "acbed";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference2(s, t));
        System.out.println(findTheDifference3(s, t));
    }

    public static char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return arr2[i];
        }
        return arr2[arr2.length - 1];
    }
    public static char findTheDifference2(String s, String t) {
        int sum1=0;
        int sum2=0;
        for (int i = 0; i < s.length(); i++) {
            sum1+=s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum2+=t.charAt(i);
        }
        return (char)(sum2-sum1);
    }
    public static char findTheDifference3(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }
}
