package beakjoon.stage18;

import java.io.*;
import java.util.*;

// 프린터 큐
public class A1966 {

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 9; i > 0; i--) {
            if (arr[i] != 0) {
                max = arr[i];
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            LinkedList<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] importance = new int[10];

            int n = Integer.parseInt(st.nextToken());   // 문서의 개수
            int m = Integer.parseInt(st.nextToken());   // 몇 번째로 인쇄될지 궁금한 문서의 현재 위치
            // 0 1 2 3 ... n
            int count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
                // 초기 위치, 중요도
            }

            // 케이스 별 반복문 실행
            while (!q.isEmpty()) {
                int[] front = q.poll(); // 첫번째 원소 저장
                boolean isMax = true;   // 중요도 최대값 체크

                for (int k = 0; k < q.size(); k++) {
                    if (front[1] < q.get(k)[1]) {   // 맨 앞 원소보다 뒤의 원소가 더 크면
                        q.offer(front); //첫번째 원소 큐에 저장
                        for (int l = 0; l < k; l++) {
                            q.offer(q.poll());  // 나머지 작은 원소들 큐에 다시 저장
                        }
                        isMax = false;
                        break;
                    }
                }

                if(isMax == false)
                    continue;

                count++;
                if (front[0] == m) {
                    break;
                }
            }
            sb.append(count + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}
