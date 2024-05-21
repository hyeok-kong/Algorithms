import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] D = new int[15][15];
        for (int i=0;i<15;i++) {
            D[0][i] = i;
            D[i][1] = 1;
        }

        for (int i=1;i<15;i++) {
            for (int j=1;j<15;j++) {
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }

        for (int i=0;i<N;i++) {
            System.out.println(D[sc.nextInt()][sc.nextInt()]);
        }
    }
}