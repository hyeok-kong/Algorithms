import java.util.*;

class Solution {
    static Set<String> old;
    
    public int[] solution(int n, String[] words) {
        old = new HashSet<>();
        int cycle = 1;
        String word = words[0];
        old.add(word);
        
        if (word.length() == 1) {
            return new int[] { 1, 1 };
        }
        
        char lastChar = word.charAt(word.length()-1);
        for (int i=1;i<words.length;i++) {
            if (i % n == 0) {
                cycle++;
            }
            
            word = words[i];            
            if (!isValid(word, lastChar)) {
                return new int[] { i % n + 1, cycle };
            }
            
            old.add(word);
            lastChar = word.charAt(word.length()-1);
        }
        return new int[] { 0, 0 };
    }
    
    static boolean isValid(String word, char lastChar) {
        if (word.length() == 1) {
            return false; 
        }
        // 현재 단어의 처음 단어가 이전 단어의 마지막 단어와 다르면
        if (word.charAt(0) != lastChar) {
            return false;
        }
        
        if (old.contains(word)) {
            return false;
        }
        
        return true;
    }
}