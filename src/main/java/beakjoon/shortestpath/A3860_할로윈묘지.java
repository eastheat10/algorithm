package beakjoon.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A3860_할로윈묘지 {

    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    final static int graveFlag = -1;
    final static int ghostFlag = -2;
    final static int INF = Integer.MAX_VALUE;

    static int w, h, g, ghostCount;
    static int[] cost;
    static int[][] map;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static int[][] dir = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean nCycle;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (w == 0 && h == 0) break;
            process();
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        if (w == 0 && h == 0) return;

        map = new int[w + 2][h + 2];
        edgeList = new ArrayList<>();
        cost = new int[w * h + 1];

        g = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2, c;
        for (int i = 1; i <= g; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            map[x1 + 1][y1 + 1] = graveFlag;
        }

        ghostCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= ghostCount; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[x1 + 1][y1 + 1] = ghostFlag;
            edgeList.add(new Edge(pointToNumber(x1 + 1, y1 + 1), pointToNumber(x2 + 1, y2 + 1), c));
        }

        for (int i = 0; i <= w + 1; i++) {
            map[i][0] = graveFlag;
            map[i][h + 1] = graveFlag;
        }

        for (int i = 0; i <= h + 1; i++) {
            map[0][i] = graveFlag;
            map[w + 1][i] = graveFlag;
        }

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                cost[pointToNumber(i, j)] = INF;
                makeEdge(i, j);
            }
        }

        cost[pointToNumber(1, 1)] = 0;

    }

    static void process() {
        for (int i = 1; i <= w * h - 1; i++) {
            for (Edge edge : edgeList) {
                if (cost[edge.from] != INF) {
                    cost[edge.to] = Math.min(cost[edge.to], cost[edge.from] + edge.cost);
                }
            }
        }

        nCycle = false;
        cycleCheck:
        for (Edge now : edgeList) {
            if (cost[now.from] != INF && cost[now.to] > cost[now.from] + now.cost) {
                nCycle = true;
                break cycleCheck;
            }
        }

        if (nCycle == true) {
            sb.append("Never").append('\n');
        } else if (cost[pointToNumber(w, h)] == INF) {
            sb.append("Impossible").append('\n');
        } else {
            sb.append(cost[pointToNumber(w, h)]).append('\n');
        }
    }

    static void makeEdge(int x, int y) {
        if (map[x][y] == ghostFlag || map[x][y] == ghostFlag || (x == w && y == h)) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (map[x + dir[i][0]][y + dir[i][1]] != graveFlag) {
                edgeList.add(new Edge(pointToNumber(x, y), pointToNumber(x + dir[i][0], y + dir[i][1]), 1));
            }
        }
    }

    static int pointToNumber(int x, int y) {
        return x + (y - 1) * w;
    }
}