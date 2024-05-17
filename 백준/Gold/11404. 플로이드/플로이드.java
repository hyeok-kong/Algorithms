import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] route = new long[N+1][N+1];
        for (int i=1;i<=N;i++) {
            Arrays.fill(route[i], Integer.MAX_VALUE);
            route[i][i] = 0;
        }

        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용
            if (c < route[a][b]) {
                route[a][b] = c;
            }
        }

        for (int k=1;k<=N;k++) {
            for (int s=1;s<=N;s++) {
                for (int e=1;e<=N;e++) {
                    if (route[s][e] > route[s][k] + route[k][e]) {
                        route[s][e] = route[s][k] + route[k][e];
                    }
                }
            }
        }

        for (int i=1;i<=N;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=1;j<=N;j++) {
                if (route[i][j] == Integer.MAX_VALUE) {
                    sb.append(0);
                } else {
                    sb.append(route[i][j]);
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}