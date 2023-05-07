package beakjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액
// 이분탐색
class A2470 {
    static int n;
    static int[] solution;
    static StringBuilder sb = new StringBuilder();

    static int count(int l, int r, int x){
        int result = r + 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(solution[mid] >= x){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    static void find(){
        int bestSum = Integer.MAX_VALUE;
        int r1 = 0;
        int r2 = 0;
        for(int l = 1; l <= n; l++){
            int boundary = count(l + 1, n, -solution[l]);

            if(boundary >= l + 1 && boundary <= n && Math.abs(solution[l] + solution[boundary]) < bestSum){
                bestSum = Math.abs(solution[l] + solution[boundary]);
                r1 = solution[l];
                r2 = solution[boundary];
            }
            if(boundary - 1 >= l + 1 && boundary - 1 <= n && Math.abs(solution[l] + solution[boundary - 1]) < bestSum){
                bestSum = Math.abs(solution[l] + solution[boundary - 1]);
                r1 = solution[l];
                r2 = solution[boundary - 1];
            }
        }
        sb.append(r1).append(" ").append(r2).append("\n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solution = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            solution[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(solution, 1, n + 1);
        find();

        System.out.println(sb.toString());
    }
}