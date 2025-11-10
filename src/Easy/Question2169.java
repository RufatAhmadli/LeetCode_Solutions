package Easy;

public class Question2169 {
    public int countOperations(int num1, int num2) {
        int count = 0;
        if (num1 == 0 || num2 == 0) return count;
        while (num1 != num2) {
            if (num1 > num2) num1 -= num2;
            else num2 -= num1;
            count++;
        }
        return count + 1;

    }
}
