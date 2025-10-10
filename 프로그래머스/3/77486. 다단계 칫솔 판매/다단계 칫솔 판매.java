import java.util.*;

class Solution {
    static Map<String, Person> people = new HashMap<>();
    // static Map<String, Integer> sellers = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // put center
        people.put("-", new Person(null, "-", 0));
        for (int i=0;i<enroll.length;i++) {
            String name = enroll[i];
            String pname = referral[i];
            people.put(name, new Person(people.get(pname), name, 0));
        }

        // // 중복 제거
        // for (int i=0;i<seller.length;i++) {
        //     int money = 0;
        //     if (sellers.containsKey(seller[i])) {
        //         money = sellers.get(seller[i]);
        //     }
        //     money += amount[i];
        //     sellers.put(seller[i], money);
        // }
        
        // sellers.forEach( (k,v) -> {
        //     people.get(k).distribute(v * 100);
        // });

        
        for (int i=0;i<seller.length;i++) {
            people.get(seller[i]).distribute(amount[i] * 100);
        }


        int[] answer = new int[enroll.length];
        for (int i=0;i<enroll.length;i++) {
            answer[i] = people.get(enroll[i]).amount;
        }
        
        return answer;
    }

    static class Person {
        Person parent;
        String name;
        int amount;

        public Person(Person parent, String name, int amount) {
            this.parent = parent;
            this.name = name;
            this.amount = amount;
        }

        public void distribute(int money) {
            if (this.parent == null) {
                return;
            }
            int m = money / 10;
            this.amount = amount + money - m;
            this.parent.distribute(m);
        }
    }
}
