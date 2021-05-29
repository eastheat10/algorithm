package beakjoon.stage23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class A1260 {

    static int n, m, v;
    static int arr[][];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start) {
        sb.append(start + " ");  // 본인 출력
        check[start] = true;  // 방문 상태로 변경

        for (int i = 1; i < n + 1; i++){
            if (i != start && arr[start][i] == 1 && check[i] == false)
                // 자식이 있고, 방문하지 않았으면
                dfs(i); // 재귀 호출 (방문)
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true; // 현재 정점 방문상태 변경

        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp + " ");

            for (int i = 1; i < n + 1; i++) {
                if (i != start && check[i] == false && arr[tmp][i] == 1) {
                    // 방문하지 않고, 자식 노드이면
                    q.offer(i); // 자식노드 추가
                    check[i] = true; // 방문상태로 만들어준다.
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 시작 점점의 번호

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(v);
        Arrays.fill(check, false);
        // dfs 탐색 이후 체크 배열 false로 초기화
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
        br.close();
    }

}
