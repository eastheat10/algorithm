package beakjoon.bruteforce;

import java.util.*;
import java.io.*;

// 일곱난장이
class Main { 

    static int[] dwarf = new int[9];
    static ArrayList<Integer> heights;
    static HashSet<Integer> visit = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) 
            dwarf[i] = Integer.parseInt(br.readLine());
    }

    static void process() {
        StringBuilder sb = new StringBuilder();

        dfs(0, 0);

        heights.sort((o1, o2) -> o1 - o2);
        for (Integer i : heights) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int sum) {
        if (depth == 7 || sum > 100) {
            if (sum == 100) {
                heights = new ArrayList<>(visit);
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (visit.contains(dwarf[i])) 
                    continue;

                visit.add(dwarf[i]);
                dfs(depth + 1, sum + dwarf[i]);
                visit.remove(dwarf[i]);
            }
        }

    }

}