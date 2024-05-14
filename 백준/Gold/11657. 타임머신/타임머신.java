import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static class Edge {
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        long[] result = new long[N+1];

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }
        for (int i=0;i<=N;i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[1] = 0;

        for (int i=0;i<N-1;i++) {
            for (int j=0;j<M;j++) {
                Edge edge = edges[j];
                if (result[edge.start] != Integer.MAX_VALUE && result[edge.start] + edge.weight < result[edge.end]) {
                    result[edge.end] = result[edge.start] + edge.weight;
                }
            }
        }

        boolean hasCycle = false;
        for (int i=0;i<M;i++) {
            Edge edge = edges[i];
            if (result[edge.start] != Integer.MAX_VALUE && result[edge.start] + edge.weight < result[edge.end]) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println(-1);
        } else {
            for (int i=2;i<=N;i++) {
                if (result[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(result[i]);
                }
            }
        }
    }
}