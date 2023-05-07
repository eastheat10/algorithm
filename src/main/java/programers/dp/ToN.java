package programers.dp;

// N으로 표현
public class ToN {

    static int n, target, answer = Integer.MAX_VALUE;

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static void dfs(int cnt, int pre) {
        if (cnt > 8) {
            answer = -1;
            return;
        }
        if (pre == target) {
            answer = Math.min(answer, cnt);
            return;
        }

        int tmp = n;

        for (int i = 1; i <= 8 - cnt; i++) {
            int C = cnt + i;
            dfs(C, pre + tmp);
            dfs(C, pre - tmp);
            dfs(C, pre * tmp);
            dfs(C, pre / tmp);

            tmp = tmp * 10 + n;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }
}
