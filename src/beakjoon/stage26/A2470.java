package beakjoon.stage26;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

// 두 용액
// 투 포인터
class A2470{
    static int n;
    static int[] solution;
    static StringBuilder sb = new StringBuilder();

    static void find(){
        Arrays.sort(solution, 1, n + 1);
        int bestSum = Integer.MAX_VALUE;
        int v1 = 0;
        int v2 = 0;
        int l = 1;
        int r = n;

        while (l < r) {
            int sum = solution[l] + solution[r];
            if (Math.abs(sum) < bestSum) {
                bestSum = Math.abs(sum);
                v1 = solution[l];
                v2 = solution[r];
            }

            if(sum > 0)
                r--;
            else
                l++;

        }

        sb.append(v1).append(" ").append(v2).append("\n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solution = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            solution[i] = Integer.parseInt(st.nextToken());

        find();

        System.out.println(sb.toString());
    }
}