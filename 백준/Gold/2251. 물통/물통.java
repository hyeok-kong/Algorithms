import java.io.*;
import java.util.*;

public class Main {
    static class AB {
        int A;
        int B;
        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    static int[] Sender = { 0, 0, 1, 1, 2, 2 };
    static int[] Receiver = { 1, 2, 0, 2, 0, 1 };
    static boolean[][] visited;
    static boolean answer[];
    static int now[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int [3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for (int i=0;i<answer.length;i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }

    private static void BFS() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while (!q.isEmpty()) {
            AB p = q.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;
            for (int i=0;i<6;i++) {
                int[] next = { A, B, C };
                next[Receiver[i]] += next[Sender[i]];
                next[Sender[i]] = 0;
                if (next[Receiver[i]] > now[Receiver[i]]) {
                    next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                    next[Receiver[i]] = now[Receiver[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}