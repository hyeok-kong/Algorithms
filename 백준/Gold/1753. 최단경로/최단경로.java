import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return weight > n.weight ? 1 : -1;
        }
    }

    static List<Node>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        visited = new boolean[V+1];
        distance = new int[V+1];
        graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i=0;i<E;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        distance[K] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.node]) {
                continue;
            }
            visited[now.node] = true;

            for (Node node : graph[now.node]) {
                if (distance[node.node] > distance[now.node] + node.weight) {
                    distance[node.node] = distance[now.node] + node.weight;
                    pq.add(new Node(node.node, distance[node.node]));
                }
            }
        }

        for (int i=1;i<=V;i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}