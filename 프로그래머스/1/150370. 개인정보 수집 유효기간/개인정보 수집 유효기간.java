import java.util.*;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> res = new ArrayList<>();
        LocalDate now = toDate(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i=0;i<privacies.length;i++) {
            String[] info = privacies[i].split(" ");
            LocalDate exp = toDate(info[0]).plusMonths(termMap.get(info[1]));
            if (now.isAfter(exp) || now.isEqual(exp)) {
                res.add(i+1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public LocalDate toDate(String date) {
        String[] ymd = date.split("[.]");
        int y = Integer.parseInt(ymd[0]);
        int m = Integer.parseInt(ymd[1]);
        int d = Integer.parseInt(ymd[2]);
        return LocalDate.of(y, m, d);
    }
}