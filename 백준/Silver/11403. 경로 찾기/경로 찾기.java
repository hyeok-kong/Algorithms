import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int k=0;k<N;k++) {
            for (int s=0;s<N;s++) {
                for (int e=0;e<N;e++) {
                    if (matrix[s][k] + matrix[k][e] == 2) {
                        matrix[s][e] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}