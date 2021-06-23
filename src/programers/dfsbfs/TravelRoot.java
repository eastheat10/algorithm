package programers.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;

// 여행경로
public class TravelRoot {

    static String[] answer;
    static int count = 0;
    static HashMap<String, ArrayList<String>> hm;
    static HashMap<String, Boolean> visit = new HashMap<>();
    static ArrayList<String> result = new ArrayList<>();

    static HashMap<String, ArrayList<String>> input(String[][] tickets){
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            String s1 = tickets[i][0];
            String s2 = tickets[i][1];
            if (!hm.containsKey(tickets[i][0])) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s2);
                hm.put(s1, list);
            } else {
                hm.get(s1).add(s2);
            }
            visit.put(s1, visit.getOrDefault(s1, false));
            visit.put(s2, visit.getOrDefault(s2, false));
        }
        return hm;
    }

    public static String[] solution(String[][] tickets) {
        hm = input(tickets);
        answer = new String[visit.size()];

        dfs("ICN");

        return answer;
    }

    static void dfs(String airport) {
        visit.put(airport, true);
        result.add(airport);
        answer[count++] = airport;

        ArrayList<String> list = hm.get(airport);

        if (list != null) {
            if (list.size() > 1)
                list.sort((o1, o2) -> o1.compareTo(o2));
            for (String s : list) {
                if (count < visit.size()) {
                    dfs(s);
                }
            }
        }
    }

    public static void main(String[] args) {
//        for (String s : solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})) {
//            System.out.print(s + " ");
//        }
        for (String s : solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})) {
            System.out.print(s + " ");
        }
    }

    /**
     * tickets
     * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
     * return
     * ["ICN", "JFK", "HND", "IAD"]
     * tickets
     * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
     * return
     * ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
     */
}
