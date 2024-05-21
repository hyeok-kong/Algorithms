import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] D = new int[N+1][N+1];

        for (int i=0;i<=N;i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }
        for (int i=1;i<=N;i++) {
            for (int j=1;j<i;j++) {
                D[i][j] = (D[i-1][j] + D[i-1][j-1]) % 10_007;
            }
        }

        System.out.println(D[N][K]);
    }
}