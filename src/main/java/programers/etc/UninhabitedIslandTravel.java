package programers.etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 무인도 여행
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
public class UninhabitedIslandTravel {

    private static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private List<Integer> result;
    private String[] map;
    private boolean[][] visit;
    private int width, height;

    public int[] solution(String[] maps) {
        result = new ArrayList<>();
        this.map = maps;
        visit = new boolean[maps.length][maps[0].length()];
        width = maps[0].length();
        height = maps.length;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (visit[i][j] || maps[i].charAt(j) == 'X') {
                    continue;
                }
                bfs(i, j);
            }
        }

        if (result.isEmpty()) {
            return new int[] { -1 };
        }

        result.sort(Integer::compareTo);

        return result.stream()
                     .mapToInt(i -> i)
                     .toArray();
    }

    public void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        visit[a][b] = true;
        q.offer(new int[] { a, b });
        int sum = Integer.parseInt(String.valueOf(map[a].charAt(b)));

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= height || ny >= width) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (map[nx].charAt(ny) == 'X') {
                    continue;
                }

                q.offer(new int[] { nx, ny });
                visit[nx][ny] = true;
                sum += Integer.parseInt(String.valueOf(map[nx].charAt(ny)));
            }
        }

        result.add(sum);
    }

}
