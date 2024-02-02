import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int count = sc.nextInt();
        String number = sc.next();

        for (int i=0;i<count;i++) {
            answer += number.charAt(i) - '0';
        }

        System.out.println(answer);
    }
}
