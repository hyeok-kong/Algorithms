import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] relations = new int[N+1][N+1];
        for (int i=0;i<N+1;i++) {
            Arrays.fill(relations[i], 1_000_001);
            relations[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            relations[s][e] = 1;
            relations[e][s] = 1;
        }

        for (int k=1; k <= N; k++) {
            for (int s=1; s<=N; s++) {
                for (int e=1; e<=N; e++) {
                    if (relations[s][e] > relations[s][k] + relations[k][e]) {
                        relations[s][e] = relations[s][k] + relations[k][e];
                        relations[e][s] = relations[s][e];
                    }
                }
            }
        }

        int[] kevin = new int[N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (relations[i][j] != 1_000_000) {
                    kevin[i] += relations[i][j];
                }
            }
        }

        int min = 1_000_000;
        for (int i=1;i<=N;i++) {
            if (kevin[i] < min) {
                min = kevin[i];
            }
        }

        for (int i=1;i<=N;i++) {
            if (kevin[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
}