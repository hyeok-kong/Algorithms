import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);

        int start, end, num, sum, count = 0;
        for (int n=0;n<N;n++) {
            num = nums[n];
            start = 0;
            end = N-1;
            while (start < end) {
                sum = nums[start] + nums[end];
                if (sum == num) {
                    if (start == n) {
                        start++;
                    } else if (end == n) {
                        end--;
                    } else {
                        count++;
                        break;
                    }
                } else if (sum < num) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}