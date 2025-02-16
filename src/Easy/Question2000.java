package Easy;

public class Question2000 {
    public static void main(String[] args) {

    }

    public String reversePrefix(String word, char ch) {
        int firstIndex = word.indexOf(ch);
        if (firstIndex == -1) return word;
        StringBuilder sb = new StringBuilder(word.substring(0, firstIndex + 1));
        sb.reverse();
        for (int i = firstIndex + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    public String largestOddNumber(String num) {
        int ind=num.lastIndexOf('1');
        ind=Math.max(ind,num.lastIndexOf('3'));
        ind=Math.max(ind,num.lastIndexOf('5'));
        ind=Math.max(ind,num.lastIndexOf('7'));
        ind=Math.max(ind,num.lastIndexOf('9'));
        return (ind==-1)?"":num.substring(0,ind+1);
    }
}
