import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Node {
        int point;
        int weight;

        public Node(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{ " + point + ", " + weight + " }";
        }
    }
    static int N;
    static ArrayList<Node>[] tree;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];
        for (int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        int from, flag, w;
        for (int i=1; i<=N; i++) {
            from = sc.nextInt();
            while (true) {
                flag = sc.nextInt();
                if (flag == -1)
                    break;
                w = sc.nextInt();
                tree[from].add(new Node(flag, w));
            }
        }

        BFS(2);
        int max_idx = getMaxIndex();
        for (int i=1;i<=N;i++) {
            distance[i] = 0;
            visited[i] = false;
        }
        BFS(max_idx);
        System.out.println(distance[getMaxIndex()]);
    }

    private static int getMaxIndex() {
        int max = -1;
        int index = 0;
        for (int i=1;i<=N;i++) {
            if (distance[i] > max) {
                max = distance[i];
                index = i;
            }
        }
        return index;
    }

    private static void BFS(int from) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(from);
        visited[from] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Node n : tree[node]) {
                if (!visited[n.point]) {
                    q.add(n.point);
                    visited[n.point] = true;
                    distance[n.point] = distance[node] + n.weight;
                }
            }
        }
    }
}