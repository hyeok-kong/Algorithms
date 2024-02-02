import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");


        int sum = 0, max = 0;
        for (int i=0;i<count;i++) {
            int num = Integer.parseInt(s[i]);
            sum += num;
            if (max < num) max = num;
        }
        double avg = sum * 100.0 / max / count;
        System.out.println(avg);
    }
}
