import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean[] nums = new boolean[end+1];

        nums[1] = true;
        for (int i=2;i<=Math.sqrt(end);i++) {
            if (!nums[i]) {
                for (int j=i*2;j<=end;j+=i) {
                    nums[j] = true;
                }
            }
        }

        for (int i=start;i<=end;i++) {
            if (!nums[i]) {
                System.out.println(i);
            }
        }
    }
}