package programers.dfsbfs;

import java.util.ArrayList;

// 네트워크
public class Network {

    static ArrayList<Integer>[] arr;
    static boolean[] visit;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++)
            arr[i] = new ArrayList<>();
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    if(!arr[i].contains(j))
                        arr[i].add(j);
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
        for (int i = 0; i < arr[k].size(); i++) {
            int t = arr[k].get(i);
            if(!visit[t])
                dfs(t);
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}

/**
 * n	computers	                        return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
