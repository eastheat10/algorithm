import java.util.*;

// 네트워크
@SuppressWarnings("unchecked")
class Main {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));    // 2
        System.out.println(solution(3, new int[][]{{1,1,0}, {1,1,1}, {0,1,1}}));    // 1
    }

    static ArrayList<Integer>[] list;
    static boolean[] visit;
    
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            list[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int k) {
        visit[k] = true;

        for (int i = 0; i < list[k].size(); i++) {
            int t = list[k].get(i);
            if (!visit[t]) {
                dfs(t);
            }
        }

    }

}