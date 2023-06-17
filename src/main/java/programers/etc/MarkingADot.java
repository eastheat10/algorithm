package programers.etc;

/**
  * 점 찍기
  *
  * https://school.programmers.co.kr/learn/courses/30/lessons/140107
  */
public class MarkingADot {

    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            int x = getX(i, d);
            answer += ((x / k) + 1);
        }

        return answer;
    }

    private int getX(int y, int d) {
        long a = (long) Math.pow(y, 2);
        long b = (long) Math.pow(d, 2);
        return (int) Math.sqrt(b - a);
    }

}
