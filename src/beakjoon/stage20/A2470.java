package beakjoon.stage20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액
public class A2470 {
    static StringBuilder sb = new StringBuilder();
    static int num;
    static int[] solution;

    static int count(int l, int r, int x) {
        int result = r + 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (solution[mid] >= x) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    static void find() {
        int bestSum = Integer.MAX_VALUE;
        int r1 = 0;
        int r2 = 0;

        for (int i = 1; i <= num / 2; i++) {
            int bound = count(i + 1, num, -solution[i]);

            if (bound >= i + 1 && bound < num + 1 && Math.abs(solution[i] + solution[bound]) < bestSum) {
                bestSum = Math.abs(solution[i] + solution[bound]);
                r1 = solution[i];
                r2 = solution[bound];
            }
            if (bound - 1 >= i + 1 && bound - 1 < num + 1 && Math.abs(solution[i] + solution[bound - 1]) < bestSum) {
                bestSum = Math.abs(solution[i] + solution[bound - 1]);
                r1 = solution[i];
                r2 = solution[bound - 1];
            }
        }
        sb.append(r1).append(" ").append(r2).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        solution = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= num; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution, 1, num + 1);
        find();
        System.out.println(sb.toString());
    }
}
