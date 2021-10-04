import java.io.*;
import java.util.*;

// 스타트와 링크
class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] team;
    static ArrayList<Integer> start;
    static ArrayList<Integer> link;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        team = new boolean[n + 1];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        dfs(0, 1);
        System.out.println(min);
    }

    static void dfs(int depth, int idx) {
        if (min == 0) return;

        if (depth == (n / 2)) {

            start = new ArrayList<>();
            link = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (team[i]) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }

            int result = Math.abs(sumScore(start) - sumScore(link));
            min = Math.min(result, min);
            
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (team[i]) continue;

            team[i] = true;
            dfs(depth + 1, i);
            team[i] = false;
        }
    
    }

    static int sumScore(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            for(int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                int b = list.get(j);
                sum += arr[a][b];
            }
        }
        return sum;
    }
    
}