import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            if (this.w > n.w) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i=0;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] result = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i=0;i<=N;i++) {
            result[i] = Integer.MAX_VALUE;
        }


        result[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Node node : graph[now.v]) {
                    if (!visited[node.v] && result[now.v] + node.w < result[node.v]) {
                        result[node.v] = result[now.v] + node.w;
                        q.add(new Node(node.v, result[node.v]));
                    }
                }
            }
        }
        System.out.println(result[end]);

    }
}