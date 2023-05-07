package programers.hash;

import java.util.HashMap;
import java.util.Set;

public class Marathon {
    
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        String name = "";
        for (String player : participant) {
            if (hm.containsKey(player)) {
                hm.put(player, hm.get(player) + 1);
            } else {
                hm.put(player, 1);
            }
        }
        for (String player : completion) {
            if (hm.get(player) > 1) {
                hm.put(player, hm.get(player) - 1);
            } else {
                hm.remove(player);
            }
        }

        for (String s : hm.keySet()) {
            name = s;
        }

        return name;
    }

    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};

//        String[] completion = {"eden", "kiki"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
//        String[] completion = {"stanko", "ana", "mislav"};

        String name = solution(participant, completion);

        System.out.println("name = " + name);
    }
}
