import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for (int i=0;i<cards.length;i++) {
            Set<Integer> group1 = new HashSet<>();
            dfs(i, cards, group1);
            
            for (int j=0;j<cards.length;j++) {
                Set<Integer> group2 = new HashSet<>(group1);
                dfs(j, cards, group2);
                
                group2.removeAll(group1);
                answer = Math.max(answer, group1.size() * group2.size());
            }
        }
        
        return answer;
    }
    
    static void dfs(int index, int[] cards, Set<Integer> set) {
        set.add(index);
        if (set.contains(cards[index]-1)) {
            return;
        }
        dfs(cards[index]-1, cards, set);
    }
    
}