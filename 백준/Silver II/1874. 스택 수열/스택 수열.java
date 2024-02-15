import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = sc.nextInt();
        int[] M = new int[N];
        for (int i=0;i<N;i++) {
            M[i] = sc.nextInt();
        }
        int num = 1;
        boolean result = true;

        for (int i=0;i<N;i++) {
            if (M[i] >= num) {
                while (num <= M[i]) {
                    stack.push(num++);
                    sb.append("+\n");
                }
            }
            Integer pop = stack.pop();
            if (pop == M[i]) {
                sb.append("-\n");
            } else {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}