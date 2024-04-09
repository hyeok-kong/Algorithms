import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        list = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0;i<N;i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i=0;i<M;i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i=0;i<N;i++) {
            DFS(i, 1);
            if (arrive) break;
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void DFS(int n, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[n] = true;
        for (int i : list[n]) {
            if (!visited[i]) {
                DFS(i, depth+1);
            }
        }
        visited[n] = false;
    }
}