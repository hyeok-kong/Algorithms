import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] D = new long[2][91];

        D[1][1] = 1;

        for (int i=2;i<=N;i++) {
            D[0][i] = D[0][i-1] + D[1][i-1];
            D[1][i] = D[0][i-1];
        }

        System.out.println(D[0][N] + D[1][N]);
    }
}