package programers.hash;

import java.util.HashMap;

public class Camouflage {

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> categoryCount = new HashMap<>();

        for (int i = 0; i < clothes.length; i++)
            categoryCount.put(clothes[i][1], categoryCount.getOrDefault(clothes[i][1], 0) + 1);

        for (String s : categoryCount.keySet()) {
            answer *= categoryCount.get(s) + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] answer1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(answer1));
        System.out.println();
        String[][] answer2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(answer2));
    }

    /**
     * clothes	                                                                                return
     * [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
     * [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	            3
     */

}
