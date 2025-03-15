package Easy;

public class Question1678 {
    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));
    }
    public static String interpret(String command) {
        int i=0;
        int n=command.length();
        StringBuilder sb=new StringBuilder();
        StringBuilder res=new StringBuilder();
        while(i<n){
            char ch=command.charAt(i);
            sb.append(ch);
            String check=sb.toString();
            switch (check) {
                case "()" -> {
                    res.append("o");
                    sb = new StringBuilder();
                }
                case "G" -> {
                    res.append("G");
                    sb = new StringBuilder();
                }
                case "(al)" -> {
                    res.append("al");
                    sb = new StringBuilder();
                }
            }
            i++;
        }
        return res.toString();
    }
}
