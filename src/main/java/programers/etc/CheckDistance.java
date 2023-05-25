package programers.etc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302#fnref1
 */
public class CheckDistance {

    int[][] diagonal = { { -1, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 } };
    int[][] dir1 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, };
    int[][] dir2 = { { 2, 0 }, { 0, 2 }, { -2, 0 }, { 0, -2 } };

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    private Queue<int[]> q;

    private boolean check(String[] place) {
        q = new LinkedList<>();

        findParticipant(place);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir1) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                char newPlace = place[nx].charAt(ny);
                if (newPlace == 'P') {
                    return false;
                }
            }

            for (int[] d : dir2) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                if (place[nx].charAt(ny) == 'P' &&
                    place[(x + nx) / 2].charAt((y + ny) / 2) != 'X') {
                    return false;
                }

            }

            for (int[] d : diagonal) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }

                // int px = (x + nx) / 2;
                // int py = (y + ny) / 2;

                // if (place[px].charAt(py + 1) != 'X' || place[px + 1].charAt(py) != 'X') {
                if (place[nx].charAt(ny) == 'P'&&
                (place[x].charAt(ny) != 'X' || place[nx].charAt(y) != 'X')) {
                    return false;
                }

            }
        }

        return true;
    }

    private void findParticipant(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    q.offer(new int[] { i, j });
                }
            }
        }
    }

}
