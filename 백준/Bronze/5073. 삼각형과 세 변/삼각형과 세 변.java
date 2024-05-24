import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";
    private static final String INVALID = "Invalid";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<3;i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int A = q.poll();
            int B = q.poll();
            int C = q.poll();

            if (A == 0 && B == 0 && C == 0) {
                return;
            }
            if (A + B <= C) {
                System.out.println(INVALID);
            } else {
                if (A == B && B == C && C == A) {
                    System.out.println(EQUILATERAL);
                } else if (A == B || B == C || C == A) {
                    System.out.println(ISOSCELES);
                } else {
                    System.out.println(SCALENE);
                }
            }
        }
    }
}
