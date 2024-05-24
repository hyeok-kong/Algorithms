import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i='A';i<='Z';i++) {
            map.put((char) i, 0);
        }

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
        }

        int max = -1;
        char answer = '?';

        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                answer = c;
            } else if(map.get(c) == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
