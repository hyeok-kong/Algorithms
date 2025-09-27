import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        
        for (int i=0;i<cards.length;i++) {
            Set<Integer> group1 = new HashSet<>();
            if (groups.get(i) != null) {                
                group1 = groups.get(i);
            } else {
                dfs(i, cards, group1);
                for (int item : group1) {
                    groups.put(item, group1);
                }
            }
            
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
    
    
    static void printSet(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int item : set) {
            sb.append(item).append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}