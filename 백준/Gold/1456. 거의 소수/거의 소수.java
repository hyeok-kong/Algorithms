import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long[] array = new long[10000001];
        for (int i=2;i<array.length;i++) {
            array[i] = i;
        }

        for (int i=2;i<Math.sqrt(array.length);i++) {
            if (array[i] == 0) continue;
            for (int j=i*2;j<array.length;j+=i) {
                array[j] = 0;
            }
        }

        int count = 0;
        for (int i=2;i<10000001;i++) {
            if (array[i] == 0) continue;
            long temp = array[i];
            while ((double)array[i] <= (double)B/temp) {
                if ((double)array[i] >= (double)A/(double)temp) {
                    count++;
                }
                temp *= array[i];
            }
        }
        System.out.println(count);
    }
}