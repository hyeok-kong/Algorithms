import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int now = 1;

        while (now < N) {
            now += 6 * count;
            count++;
        }

        System.out.println(count);

    }
}