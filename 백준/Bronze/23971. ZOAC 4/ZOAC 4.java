import java.util.*;

public class Main {
    public static void main(String[] args) {
        // (1, 1) 자리에 앉아있을 때, 최대로 앉을 수 있는 사람을 구해라
        // 탐색 (DFS) 으로 풀어보자 --> 메모리 초과
        // BFS는? --> 메모리 초과

        // 탐색을 할 필요가 있을까? 그냥 세도 될듯

        Scanner sc = new Scanner(System.in);

        double H, W, N, M;
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();

        int x = (int) Math.ceil(W/(M+1));
        int y = (int) Math.ceil(H/(N+1));
//        System.out.println(x + ", " + y);
        int count = x * y;

        System.out.println(count);
    }
}