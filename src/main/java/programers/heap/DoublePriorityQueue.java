package programers.heap;

import java.util.*;

public class DoublePriorityQueue {

    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    static void operation(String o, int n) {
        switch (o) {
            case "I":
                min.offer(n);
                max.offer(n);
                break;
            case "D":
                if (n < 0) {
                    if (!min.isEmpty()) {
                        int t = min.poll();
                        max.remove(t);
                    }
                } else {
                    if (!max.isEmpty()) {
                        int t = max.poll();
                        min.remove(t);
                    }
                }
                break;
        }
    }

    public static int[] solution(String[] operations) {
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            operation(s, n);
        }

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        if (min.size() < max.size()) {
            while (!max.isEmpty()) {
                int x = max.poll();
                int y;
                hm.put(x, hm.getOrDefault(x, 0) + 1);
                if (!min.isEmpty()) {
                    y = min.poll();
                    hm.put(y, hm.getOrDefault(y, 0) + 1);
                }
            }
        } else {
            while (!min.isEmpty()) {
                int x;
                int y = min.poll();
                hm.put(y, hm.getOrDefault(y, 0) + 1);
                if (!max.isEmpty()) {
                    x = max.poll();
                    hm.put(x, hm.getOrDefault(x, 0) + 1);
                }
            }
        }
        for (Integer integer : hm.keySet()) {
            if (hm.get(integer) >= 2) {
                list.add(integer);
            }
        }
        if (list.isEmpty())
            return new int[]{0, 0};
        list.sort((i, j) -> i - j);

        return new int[]{list.get(list.size() - 1), list.get(0)};
    }

    public static void main(String[] args) {
        for(int a : solution(new String[]{"I 16", "D 1"})){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int a : solution(new String[]{"I 7","I 5","I -5","D -1"})){
            System.out.print(a + " ");
        }
        System.out.println();
        for (int a : solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})) {
            System.out.print(a + " ");
        }

    }

    /**
     * operations	                                              return
     * ["I 16","D 1"]	                                          [0,0]
     * ["I 7","I 5","I -5","D -1"]	                              [7,5]
     * ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"] [0, 0]
     */
}
