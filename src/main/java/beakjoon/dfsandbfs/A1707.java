package beakjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 이분 그래프
public class A1707 {

    static int k, v, e, c = 1;
    static ArrayList<Integer>[] list;
    static int[] color;   // -1, 1
    static boolean[] visit;
    static final String YES = "YES";
    static final String NO = "NO";

    static boolean bfs(int p) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(p);
        visit[p] = true;
        color[p] = c;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            c = color[tmp] * -1;
            for (int i = 0; i < list[tmp].size(); i++) {
                Integer integer = list[tmp].get(i);
                if (visit[integer]) {
                    if (color[tmp] == color[integer]) {
                        return false;
                    }
                } else {
                    color[integer] = c;
                    q.offer(integer);
                    visit[integer] = true;
                }
            }
        } // while

        return true;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list = new ArrayList[v + 1];
            visit = new boolean[v + 1];
            color = new int[v + 1];

            for (int i = 0; i <= v; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                list[a1].add(a2);
                list[a2].add(a1);
            }

            boolean result = true;
            for (int i = 1; i <= v; i++) {
                if (!visit[i]) {
                    result = bfs(i);
                    if (!result)
                        break;
                }
            }

            if (result)
                sb.append(YES);
            else
                sb.append(NO);
            sb.append('\n');
        } // for

        System.out.println(sb);
    }
}
/*
11
3 1
2 3
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
3 2
2 1
3 2
4 4
2 1
3 2
4 3
4 1
5 2
1 5
1 2
5 2
1 2
2 5
4 3
1 2
4 3
2 3
4 4
2 3
1 4
3 4
1 2
3 3
1 2
2 3
3 1
2 1
1 2

'YES', 'YES', 'NO', 'YES', 'YES', 'YES', 'YES', 'YES', 'YES', 'NO', 'YES'
*/

