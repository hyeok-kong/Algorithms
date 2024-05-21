import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new int[2][26];

        for (int i=1;i<=N;i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            int now = parent - 'A';
            if (left != '.') {
                tree[0][now] = left - 'A';
            } else {
                tree[0][now] = -1;
            }

            if (right != '.') {
                tree[1][now] = right - 'A';
            } else {
                tree[1][now] = -1;
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    private static void preOrder(int i) {
        if (i == -1) return;
        System.out.print((char) (i+'A'));
        preOrder(tree[0][i]);
        preOrder(tree[1][i]);
    }

    private static void inOrder(int i) {
        if (i == -1) return;
        inOrder(tree[0][i]);
        System.out.print((char) (i+'A'));
        inOrder(tree[1][i]);
    }

    private static void postOrder(int i) {
        if (i == -1) return;
        postOrder(tree[0][i]);
        postOrder(tree[1][i]);
        System.out.print((char) (i+'A'));
    }
}