package Easy;
import java.util.Map;
import java.util.TreeMap;

public class Question3146 {
    public static void main(String[] args) {
        String s = "abc";
        String t= "bac";
        System.out.println(findPermutationDifference(s, t));
    }
    public static int findPermutationDifference(String s, String t) {
        int n=t.length();
        Map<Character,Integer> letters1=new TreeMap<>();
        Map<Character,Integer> letters2=new TreeMap<>();
        for(int i=0;i<n;i++){
            letters1.put(s.charAt(i),i);
            letters2.put(t.charAt(i),i);
        }
        int sum=0;

        for(char str:t.toCharArray()){
            sum+=Math.abs(letters1.get(str)-letters2.get(str));
        }
        return sum;
    }
}
