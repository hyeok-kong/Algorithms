import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lessons = new int[N];
        int sum = 0, max = 0;

        for (int i=0; i<N; i++) {
            int len = sc.nextInt();
            lessons[i] = len;
            sum += len;
            if (max < len) {
                max = len;
            }
        }

        int result = sum;
        int start = max, end = sum;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            sum = 0;
            for (int i=0;i<N;i++) {
                sum += lessons[i];
                if (sum > mid) {
                    sum = lessons[i];
                    count++;
                }
            }
            if (sum != 0) {
                count++;
            }
            if (count <= M) {
                end = mid - 1;
                if (result > mid) {
                    result = mid;
                }
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}