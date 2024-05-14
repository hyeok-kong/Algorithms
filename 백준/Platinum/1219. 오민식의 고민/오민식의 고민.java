import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Edge {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        long[] earn = new long[N];
        long[] result = new long[N];

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            earn[i] = Long.parseLong(st.nextToken());
        }

        for (int i=0;i<N;i++) {
            result[i] = Long.MIN_VALUE;
        }
        result[start] = earn[start];

        for (int i=0;i<N+100;i++) {
            for (int j=0;j<M;j++) {
                Edge edge = edges[j];
                if (result[edge.from] == Long.MIN_VALUE ) {
                    continue;
                } else if (result[edge.from] == Long.MAX_VALUE) {
                    result[edge.to] = Long.MAX_VALUE;
                } else if (result[edge.from] - edge.weight + earn[edge.to] > result[edge.to]) {
                        result[edge.to] = result[edge.from] - edge.weight + earn[edge.to];
                        if (i >= N-1) result[edge.to] = Long.MAX_VALUE;
                }
            }
        }


        if (result[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            if (result[end] == Long.MIN_VALUE) {
                System.out.println("gg");
            } else {
                System.out.println(result[end]);
            }
        }
    }
}