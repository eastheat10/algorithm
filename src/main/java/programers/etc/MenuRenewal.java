package programers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 메뉴 리뉴얼
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class MenuRenewal {

    private Map<String, Integer> map;
    private Set<Integer> set;
    private List<String> list;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        set = new HashSet<>();
        list = new ArrayList<>();

        orders = sort(orders);

        for (String order : orders) {
            makeCombination(order, "", order.length(), 0);
        }

        find(course);

        list.sort(String::compareTo);

        return list.toArray(new String[0]);
    }

    private void find(int[] course) {
        Map<Integer, List<String>> maxMap = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : course) {
            set.add(i);
            maxMap.put(i, new ArrayList<>());
        }

        for (String s : map.keySet()) {
            int len = s.length();
            int cnt = map.get(s);

            if (cnt < 2 || !set.contains(len)) {
                continue;
            }
            if (!counter.containsKey(len)) {
                counter.put(len, cnt);
                maxMap.get(len).add(s);
            } else if (counter.get(len) < cnt) {
                List<String> l = new ArrayList<>();
                l.add(s);
                maxMap.put(len, l);
                counter.put(len, cnt);
            } else if (counter.get(len) == cnt) {
                maxMap.get(len).add(s);
            }
        }

        for (List<String> l : maxMap.values()) {
            list.addAll(l);
        }

    }

    private void makeCombination(String s, String cur, int len, int start) {

        for (int i = start; i < len; i++) {
            String tmp = cur + s.charAt(i);
            if (tmp.length() > 1) {
                int size = map.getOrDefault(tmp, 0) + 1;
                map.put(tmp, size);
            }
            makeCombination(s, tmp, len, i + 1);
        }

    }

    private String[] sort(String[] orders) {
        String[] sortedOrders = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            sortedOrders[i] = new String(arr);
        }

        return sortedOrders;
    }

}
