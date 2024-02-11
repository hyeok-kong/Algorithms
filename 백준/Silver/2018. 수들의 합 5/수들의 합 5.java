import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1, end = 1;
        int sum = 1, count = 1;
        while (end != N) {
            if (sum > N) {
                sum -= start;
                start++;
            } else {
                if (sum == N) count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}