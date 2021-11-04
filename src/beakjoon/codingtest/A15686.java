import java.io.*;
import java.util.*;

// 치킨 배달
@SuppressWarnings("unchecked")
class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;
    static HashSet<Integer> visit = new HashSet<>();
    static ArrayList<int[]> hList = new ArrayList<>();
    static ArrayList<int[]> cList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if (x == 1)
                    hList.add(new int[]{i, j});
                if (x == 2)
                    cList.add(new int[]{i, j});
            }
        }

    }

    static void process() {
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int k) {
        if (depth == m) {
            answer = Math.min(answer, measurement());
            return;
        }

        for (int i = k; i < cList.size(); i++) {
            int[] tmp = cList.get(i);
            if (visit.contains(i)) continue;
            visit.add(i);
            dfs(depth + 1, i);
            visit.remove(i);
        }
    }

    static int measurement() {
        int sum = 0;

        for (int[] house : hList) {
            int min = Integer.MAX_VALUE;
            for (Integer i : visit){
                int[] chicken = cList.get(i);
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                min = Math.min(min, distance);
            }
            sum += min;
        }

        return sum;
    }

}