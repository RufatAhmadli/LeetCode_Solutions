package Strings;


import java.util.List;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return prefix.toString();
        }

        int ind = 0;
        while (true) {

            if (ind >= strs[0].length()) {
                break;
            }

            char ch = strs[0].charAt(ind);
            boolean flag = true;

            for (int i = 1; i < strs.length; i++) {
                if (ind >= strs[i].length() || strs[i].charAt(ind) != ch) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                prefix.append(ch);
                ind++;
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strings));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
        System.out.println(solution.intToRoman(3749));
        System.out.println(solution.isSubsequence("abc","ahbgdc"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = findLetters(magazine);
        int[] letters2 = findLetters(ransomNote);
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] < letters2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] findLetters(String str) {
        int[] letters = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char letter = 97;
            int j = 0;
            while (true) {
                if (str.charAt(i) == letter) {
                    letters[j]++;
                    break;
                }
                j++;
                letter++;
            }
        }
        return letters;
    }

    public static String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        String modifiedStr = new String(chars);
        return modifiedStr;
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (i * n) + j;
            }
        }
        int row = 0;
        int col = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    row--;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    col--;
                    break;
                case "RIGHT":
                    col++;
                    break;
            }
        }
        return grid[row][col];
    }
    public String intToRoman2(int num) {
        StringBuilder roman = new StringBuilder();
        char[] symbols=new char[]{'M','D','C','L','X','V','I'};
        int[] nums=new int[]{1000,500,100,50,10,5,1};
        int index=0;
        while (num > 0) {
            int sum=0;
            int div=num/nums[index];
            if(div==0){
                index++;
                continue;
            }
            if(div>=1 && div<=3){
                for (int i = 0; i < div; i++) {
                    roman.append(symbols[index]);
                    sum+=nums[index];
                }
                num-=sum;
            }
            else if(div==4){
                roman.append(symbols[index]);
                roman.append(symbols[index-1]);
                sum-=(nums[index]-nums[index]);
            }
            else if(div==9){
                roman.append(symbols[index-1]);
                roman.append(symbols[index-2]);
                sum-=(nums[index-2]-nums[index-1]);
            }
            index++;
        }
        return roman.toString();
    }
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Process the number to convert it to Roman numerals
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                roman.append(symbols[i]);
                num -= nums[i];
            }
        }

        return roman.toString();
    }

    public boolean isSubsequence(String s, String t) {
        int ind=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(ind)){
                ind++;
            }
            if(ind==s.length()) return true;
        }
        return false;
    }
}

