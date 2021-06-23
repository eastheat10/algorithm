package programers.dfsbfs;

import java.util.ArrayList;

// 여행경로
public class TravelRoot {

    static boolean[] visit;
    static ArrayList<String> result = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        dfs(0,"ICN", "ICN", tickets);

        result.sort((s1, s2) -> s1.compareTo(s2));

        return result.get(0).split(" ");
    }

    static void dfs(int count, String airport, String s, String[][] tickets) {
        if (count == tickets.length) {
            result.add(s);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && airport.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(count + 1, tickets[i][1], s + " " + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        for (String s : solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})) {
            System.out.print(s + " ");
        }
        System.out.println();
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
