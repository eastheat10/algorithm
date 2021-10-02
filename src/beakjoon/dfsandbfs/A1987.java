import java.util.*;
import java.io.*;

class Main {

    static int r, c, answer = 0;
    static char[][] board;
    static int[][] dist = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Set<Character> visit = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r + 1][c + 1];
        for (int i = 1; i <= r; i++){
            String s = br.readLine();
            for (int j = 1; j <= c; j++) {
                board[i][j] = s.charAt(j - 1);
            }
        }
        
    }

    static void process() {
        dfs(1, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int count) {
        if (visit.contains(board[x][y])) {
            answer = Math.max(count, answer);
            return;
        }
        visit.add(board[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(nx > 0 && ny > 0 && nx <= r && ny <= c){
                dfs(nx, ny, count + 1); 
            }
        }
        visit.remove(board[x][y]);
    }
}