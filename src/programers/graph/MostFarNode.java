package programers.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 가장 먼 노드
public class MostFarNode {

    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int max = Integer.MIN_VALUE;

    public static int solution(int n, int[][] edge) {
        input(n, edge);

         bfs();

        int cnt = 0;
        for (int i : dist) {
            if (i == max)
                cnt++;
        }

        return cnt;
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;
        dist[1] = 0;

        while (!q.isEmpty()) {
            int k = q.poll();

            for (Integer x : graph[k]) {
                if (!visit[x]) {
                    q.offer(x);
                    visit[x] = true;
                    dist[x] = dist[k] + 1;
                    max = Math.max(max, dist[x]);
                }
            }
        }

    }

    static void input(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }
    }

    public static void main(String[] args) {
        int result = solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(result);
    }
}
