import java.util.HashMap;

class Solution {
    private static int[][] giftArray;
    private static int[] nextMonth;
    private static HashMap<String, Integer> map;
    
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        map = new HashMap<>();

        for (int i=0;i<friends.length;i++) {
            map.put(friends[i], i);
        }
        giftArray = new int[friends.length][friends.length];
        nextMonth = new int[friends.length];
        
        for (int i=0;i<giftArray.length;i++) {
            giftArray[i][i] = -1;
        }
        
        for(String gift : gifts) {
            String[] ft = gift.split(" ");
            int from = map.get(ft[0]);
            int to = map.get(ft[1]);
            
            giftArray[from][to]++;
        }
        
        for(int i=0;i<friends.length;i++) {
            for (int j=i+1;j<friends.length;j++) {
                if (giftArray[i][j] > giftArray[j][i]) {
                    nextMonth[i]++;
                } else if (giftArray[i][j] < giftArray[j][i]) {
                    nextMonth[j]++;
                } else {
                    int iGift = getGiftNumber(i);
                    int jGift = getGiftNumber(j);
                    if (iGift > jGift) {
                        nextMonth[i]++;
                    } else if (iGift < jGift) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        
        for (int i : nextMonth) {
            if (i > answer) answer = i;
        }
        
        return answer;
    }
    
    private static int getGiftNumber(int n) {
        int result = 0;
        for (int i=0;i<giftArray[n].length;i++) {
            result = result + giftArray[n][i] - giftArray[i][n];
        }
        return result;
    }
}