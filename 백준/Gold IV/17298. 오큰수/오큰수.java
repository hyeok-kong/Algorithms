import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] M = new int[N];
        int[] O = new int[N];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        for (int i=0;i<N;i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++) {
            while (!stack.isEmpty() && M[i] > M[stack.peek()]) {
                int idx = stack.pop();
                O[idx] = M[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            O[stack.pop()] = -1;
        }

        for (int i : O) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}