import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[V+1];
        int[] distances = new int[V+1];
        for (int i=1;i<=V;i++) {
            graph[i] = new ArrayList<>();
            distances[i] = Integer.MAX_VALUE;
        }

        int start = sc.nextInt();
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        q.add(new Node(start, 0));
        distances[start] = 0;

        for (int i=0;i<E;i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Node(to, weight));
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;

            for (int i=0;i<graph[now.v].size();i++) {
                Node temp = graph[now.v].get(i);
                if (distances[temp.v] > distances[now.v] + temp.w) {
                    distances[temp.v] = distances[now.v] + temp.w;
                    q.add(new Node(temp.v, distances[temp.v]));
                }
            }
        }

        for (int i=1;i<=V;i++) {
            if (visited[i]) {
                System.out.println(distances[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}