import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[N+1];
        D[0] = 1;
        D[1] = 1;

        for (int i=2;i<=N;i++) {
            D[i] = (D[i-1] + D[i-2]) % 10_007;
        }

        System.out.println(D[N]);
    }
}