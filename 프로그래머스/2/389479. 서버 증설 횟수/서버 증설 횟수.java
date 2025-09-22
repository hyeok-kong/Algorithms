class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] limit = new int[24];
        for (int i=0;i<24;i++) {
            limit[i] = m-1;
        }
        
        
        for (int i=0;i<24;i++) {
            while (players[i] > limit[i]) {
                answer++;
                for (int j=0;j<k;j++) {
                    if (i+j > 23) {
                        break;
                    }
                    limit[i+j] += m;
                }
            }
        }
        return answer;
    }
}