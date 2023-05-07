package beakjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 영우는 사기꾼?
public class A14676 {

    final static String kge = "King-God-Emperor";
    final static String l = "Lier!";

    static int n, m, k;
    static ArrayList<Integer>[] lists;
    static int[] ind, count, satisfaction;
    static int[][] info;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        ind = new int[n + 1];
        count = new int[n + 1];
        satisfaction = new int[n + 1];
        info = new int[k + 1][2];
        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            lists[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lists[x].add(y);
            ind[y]++;
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            info[i][0] = x;
            info[i][1] = y;
        }
    }

    static void process() {
        boolean cheat = false;

        for (int t = 1; t <= k; t++) {
            int x = info[t][0];
            int a = info[t][1];

            if (x == 1) {
                // 노드에 입력되는 간선보다 지어진 건물의 수가 작으면 치트키 사용
                if (satisfaction[a] < ind[a])
                    cheat = true;

                count[a]++;

                if (count[a] == 1) {
                    // y 건물이 처음 지어진 것이면 a 영향을 받는 건물들에게 알려주기
                    for (Integer i : lists[a]) {
                        satisfaction[i]++;
                    }
                }

            } else {
                if (count[a] == 0)
                    // 지어지지 않았는데 부셨다면 치트키 사용
                    cheat = true;

                count[a]--;

                if (count[a] == 0) {
                    // 건물이 모두 파괴되면 영향받는 건물들에게 알려주기
                    for (Integer i : lists[a]) {
                        satisfaction[i]--;
                    }
                }
            }
        }

        if (cheat)
            System.out.println(l);
        else
            System.out.println(kge);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
