import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        network = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            network[i] =  new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            network[from].add(to);
            network[to].add(from);
        }

        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int p) {
        visited[p] = true;
        for (Integer computer : network[p]) {
            if (!visited[computer]) {
                count++;
                DFS(computer);
            }
        }
    }
}