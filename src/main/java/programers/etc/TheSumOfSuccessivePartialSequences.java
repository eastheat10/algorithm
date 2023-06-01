package programers.etc;

/**
 * 연속된 부분 수열의 합
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class TheSumOfSuccessivePartialSequences {

    public int[] solution(int[] sequence, int k) {

        int len = sequence.length;
        int r = 0;
        int sum = 0;

        int left = 0;
        int right = len;

        for (int l = 0; l < len; l++) {
            while (sum < k && r < len) {
                sum += sequence[r++];
            }

            if (sum == k && r - l - 1 < right - left) {
                left = l;
                right = r - 1;
            }


            sum -= sequence[l];
        }

        return new int[] { left, right };
    }

}
