import java.util.*;

class Solution {
    List<List<Integer>> seq = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[seq.size()][2];
        
        for(int i=0;i<seq.size();i++) {
            for(int j=0;j<2;j++) {
                answer[i][j] = seq.get(i).get(j);
            }
        }
        
        return answer;
    }
    
    private void hanoi(int count, int start, int sub, int end) {
        if(count == 0) return;
        hanoi(count-1, start, end, sub);
        List<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        seq.add(l);
        hanoi(count-1, sub, start, end);
    }
}