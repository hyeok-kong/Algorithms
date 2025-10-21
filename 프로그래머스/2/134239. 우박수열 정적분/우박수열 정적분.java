import java.util.*;

class Solution {
    
    static List<Double> sums;
    
    public double[] solution(int k, int[][] ranges) {
        
        sums = new ArrayList<>();
        sums.add(0.0);
        
        int before = k;
        int now;
        int n = 0;
        
        while (k > 1) {
            if (k % 2 == 1) {
                k = k * 3 + 1;
            } else {
                k /= 2;
            }
            now = k;
            sums.add(sums.get(n) + (double) (before + now) / 2);
            
            before = now;
            n++;
        }
        
        System.out.println(sums);
        System.out.println(n);
        
        double[] answer = new double[ranges.length];
        for (int i=0;i<ranges.length;i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            if (n + b < a) {
                answer[i] = -1;
            } else {
                answer[i] = sums.get(n+b) - sums.get(a);
            }
        }
        
        return answer;
    }
}