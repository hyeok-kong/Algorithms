import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0;i<N;i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int big = Math.max(A, B);
            int small = Math.min(A, B);
            int mod = big % small;
            while (big % small != 0) {
                mod = big % small;
                big = small;
                small = mod;
            }
            System.out.println(A * B / small);
        }
    }
}