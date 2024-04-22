import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[10000001];
        for (int i=2;i<array.length;i++) {
            array[i] = i;
        }

        for (int i=2;i<Math.sqrt(array.length);i++) {
            if (array[i] == 0) continue;
            for (int j=i*2;j<array.length;j+=i) {
                array[j] = 0;
            }
        }

        for (int i=N;i<array.length;i++) {
            if (array[i] == 0) continue;
            if (check(array[i])) {
                System.out.println(array[i]);
                break;
            }
        }
    }

    public static boolean check(int number) {
        String num = Integer.toString(number);
        int front = 0, rear = num.length()-1;
        while (front < rear) {
            if (num.charAt(front++) != num.charAt(rear--)) return false;
        }
        return true;
    }
}