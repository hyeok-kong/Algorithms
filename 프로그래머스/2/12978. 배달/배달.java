import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        long[][] graph = new long[N+1][N+1];
        
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
            graph[i][i] = 0;
        }
        
        
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            graph[from][to] = Math.min(graph[from][to], weight);
            graph[to][from] = Math.min(graph[to][from], weight);
        }
        
        for (int M=1;M<=N;M++) {
            for (int S=1;S<=N;S++) {
                for (int E=1;E<=N;E++) {
                    graph[S][E] = Math.min(graph[S][E], graph[S][M] + graph[M][E]);
                }
            }
        }
        
        for (int i=1;i<=N;i++) {
            if (graph[1][i] <= K) answer++;
        }
        return answer;
    }
}