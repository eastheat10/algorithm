package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11657_타임머신 {

    static class City {
        int start, end, cost;

        public City(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    final static int INF = Integer.MAX_VALUE;

    static int n, m;
    static long[] dist;
    static City[] cities;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        cities = new City[m + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cities[i] = new City(a, b, c);
        }
    }

    static void process() {
        if (bellman_ford(1)) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
    }

    static boolean bellman_ford(int start) {
        dist[start] = 0;

        // n - 1회 간선 확인
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                City city = cities[j];

                // 출발지가 무한대면 continue
                if (dist[city.start] == INF) continue;

                // 최솟값 갱신
                dist[city.end] = Math.min(dist[city.end], city.cost + dist[city.start]);
            }
        }

        // 간선 확인 후 갱신 발생하면 음의 가중치 -> 무한루프
        for (int i = 1; i <= m; i++) {
            City city = cities[i];

            if (dist[city.start] == INF) continue;

            // 갱신이 발생하면 무한루프
            if (dist[city.end] > dist[city.start] + city.cost) {
                return true;
            }
        }

        return false;
    }
}
