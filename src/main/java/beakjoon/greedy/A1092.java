package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 배
public class A1092 {

    static int n, m;
    static ArrayList<Integer> cranes = new ArrayList<>();
    static ArrayList<Integer> boxes = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            cranes.add(Integer.parseInt(st.nextToken()));

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            boxes.add(Integer.parseInt(st.nextToken()));


    }

    static void greedy() {
        cranes.sort((o1, o2) -> o2 - o1);
        boxes.sort((o1, o2) -> o2 - o1);
        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int minute = 0;
        while (!boxes.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n; ) {
                if (idx == boxes.size()) {
                    break;
                } else if (cranes.get(i) >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            minute++;
        }
        System.out.println(minute);
    }

    public static void main(String[] args) throws IOException {
        input();
        greedy();
    }

}
