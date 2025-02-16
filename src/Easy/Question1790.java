package Easy;

public class Question1790 {
    public static void main(String[] args) {
        String s1="abcd";
        String s2="adcz";
        System.out.println(areAlmostEqual(s1,s2));
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        char previous1='-';
        char previous2='-';
        char last1='-';
        char last2='-';
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(ch1!=ch2){
                count++;
                if(count==1){
                    previous1=ch1;
                    previous2=ch2;
                }
                else if(count==2){
                    last1=ch1;
                    last2=ch2;
                }
            }
        }
        if(count==0)return true;
        else if(count==2 && previous1==last2 && previous2==last1)return true;
        return false;
    }
}
