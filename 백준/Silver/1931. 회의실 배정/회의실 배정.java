import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] conf = new int[N][2];
        for (int i=0; i<N; i++) {
            conf[i][0] = sc.nextInt();
            conf[i][1] = sc.nextInt();
        }

        Arrays.sort(conf, new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                if (c1[1] == c2[1]) {
                    return c1[0] - c2[0];
                }
                return c1[1] - c2[1];
            }
        });

        int result = 0, end = -1;
        for (int i=0; i<N; i++) {
            if (conf[i][0] >= end) {
                result++;
                end = conf[i][1];
            }
        }
        System.out.println(result);
    }
}