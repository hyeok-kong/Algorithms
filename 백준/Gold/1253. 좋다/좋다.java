import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        long target;
        int start, end;

        for (int i=0;i<n;i++) {
            target = nums[i];
            start = 0;
            end = n-1;

            while (start < end) {
                if (target == nums[start] + nums[end]) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (target < nums[start] + nums[end]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}