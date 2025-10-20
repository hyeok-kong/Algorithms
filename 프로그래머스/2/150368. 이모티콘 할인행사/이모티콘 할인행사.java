import java.util.*;

class Solution {
    static int[] discountRates = {10, 20, 30, 40};
    
    static int maxSubscribers = 0;
    static int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons, new int[emoticons.length]);
        return new int[]{maxSubscribers, maxRevenue};
    }

    private void dfs(int depth, int[][] users, int[] emoticons, int[] discounts) {
        if (depth == emoticons.length) {
            evaluate(users, emoticons, discounts);
            return;
        }

        for (int rate : discountRates) {
            discounts[depth] = rate;
            dfs(depth + 1, users, emoticons, discounts);
        }
    }

    private void evaluate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int dc = user[0];
            int limit = user[1];

            int totalCost = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= dc) {
                    int price = emoticons[i] * (100 - discounts[i]) / 100;
                    totalCost += price;
                }
            }

            if (totalCost >= limit) {
                subscribers++;
            } else {
                revenue += totalCost;
            }
        }

        if (subscribers > maxSubscribers ||
            (subscribers == maxSubscribers && revenue > maxRevenue)) {
            maxSubscribers = subscribers;
            maxRevenue = revenue;
        }
    }
}