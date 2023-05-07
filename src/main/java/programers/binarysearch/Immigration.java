package programers.binarysearch;

import java.util.Arrays;

// 입국심사
public class Immigration {

    public static long solution(int n, int[] times) {
        long answer = 0;
        int len = times.length;
        Arrays.sort(times);
        long l = 0;
        // r = 최대소요시간 * 총 인원 수
        long r = (long)times[len - 1] * n;
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = 0;
            for (int time : times) {
                // 합계 = 중간 값 / 시간 (중간값에서 각 시간요소 마다 몇명이 심사 받는지)
                sum += mid / time;
            }
            if (sum >= n) {
                // 계산된 총 인원수가 주어진 인원 n 보다 크다면 sum을 감소시켜야 함
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{7, 10}));

        /**
         * n	times	return
         * 6	[7, 10]	28
         */
    }
}
