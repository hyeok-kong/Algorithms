import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> roads = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

        for (int i=0;i<=N;i++) {
            roads.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];

        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            roads.get(from).add(new Node(to, weight));
            reverse.get(to).add(new Node(from, weight));
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node node : roads.get(now)) {
                indegree[node.v]--;
                result[node.v] = Math.max(result[node.v], result[now] + node.w);
                if (indegree[node.v] == 0) {
                    q.add(node.v);
                }
            }
        }

        // reverse edge
        q = new LinkedList<>();
        q.add(end);
        int count = 0;
        boolean[] visited = new boolean[N+1];
        visited[end] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node node : reverse.get(now)) {
                if (result[node.v] + node.w == result[now]) {
                    count++;
                    if (!visited[node.v]) {
                        visited[node.v] = true;
                        q.add(node.v);
                    }
                }
            }
        }

        System.out.println(result[end]);
        System.out.println(count);
    }
}