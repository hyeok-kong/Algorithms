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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        PriorityQueue<Integer>[] distq = new PriorityQueue[N + 1];
        for (int i=0;i<=N;i++) {
            distq[i] = new PriorityQueue<>(K, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 < o2 ? 1 : -1;
                }
            });
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distq[1].add(0);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node node : graph[now.v]) {
                if (distq[node.v].size() < K) {
                    distq[node.v].add(now.w + node.w);
                    pq.add(new Node(node.v, now.w + node.w));
                } else if (distq[node.v].peek() > now.w + node.w) {
                    distq[node.v].poll();
                    distq[node.v].add(now.w + node.w);
                    pq.add(new Node(node.v, now.w + node.w));
                }
            }
        }

        for (int i=1;i<=N;i++) {
            if (distq[i].size() < K) {
                System.out.println(-1);
            } else {
                System.out.println(distq[i].peek());
            }
        }
    }
}