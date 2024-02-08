import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][N+1];
        int[][] sumTable = new int[N+1][N+1];

        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                sumTable[i][j] = sumTable[i][j-1] + sumTable[i-1][j] - sumTable[i-1][j-1] + table[i][j];
            }
        }

        int x1, x2, y1, y2;
        int sum;
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

           sum = sumTable[x2][y2] - sumTable[x1-1][y2] - sumTable[x2][y1-1] + sumTable[x1-1][y1-1];
           System.out.println(sum);
        }
    }
}
