package Medium;

public class Question1529 {
    public static void main(String[] args) {
        String target = "10111";
        System.out.println(minFlips(target));
    }

    public static int minFlips(String target) {
        int n = target.length();
        int ans = 0;
        int flips = 0;
        while (flips < n) {
            if(target.charAt(flips) == '1'){
                flips++;
                ans++;
                while (flips < n && target.charAt(flips) == '1') flips++;
                if(flips == n) break;
                else ans++;
            }
            flips++;
        }
        return ans;
    }
}
