package programers.etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 후보키
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 */
public class CandidateKey {

    private String[][] relation;
    private Set<String> set;
    private boolean[] visit;

    public int solution(String[][] relation) {
        Arrays.asList(new int[] { 1, 2, 3, 4 });
        this.relation = relation;
        this.set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            visit = new boolean[relation[0].length];
            dfs(0, 0, i);
        }

        return set.size();
    }

    private void dfs(int depth, int cnt, int maxCnt) {
        if (cnt == maxCnt) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    sb.append(i);
                }
            }

            if (isPossible(sb.toString())) {
                set.add(sb.toString());
            }

            return;
        }

        if (depth >= visit.length) {
            return;
        }

        visit[depth] = true;
        dfs(depth + 1, cnt + 1, maxCnt);

        visit[depth] = false;
        dfs(depth + 1, cnt, maxCnt);
    }

    private boolean isPossible(String str) {

        for (String s : set) {
            boolean isMinimum = true;

            for (int i = 0; i < s.length(); i++) {
                if (!str.contains(String.valueOf(s.charAt(i)))) {
                    isMinimum = false;
                    break;
                }
            }

            if (isMinimum) {
                return false;
            }
        }

        int idx = 0;
        int[] strChecker = new int[str.length()];
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                strChecker[idx++] = i;
            }
        }

        HashSet<String> duplicationChecker = new HashSet<>();
        for (String[] r : relation) {
            StringBuilder sb = new StringBuilder();

            for (int checker : strChecker) {
                sb.append(r[checker]);
            }

            if (duplicationChecker.contains(sb.toString())) {
                return false;
            }
            duplicationChecker.add(sb.toString());
        }

        return true;
    }

}
