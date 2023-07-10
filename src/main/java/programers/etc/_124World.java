package programers.etc;

/**
 * 124 나라의 숫자
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=java
 */
public class _124World {

    public String solution(int n) {
        String[] numbers = { "4", "1", "2" };
        String answer = "";

        int num = n;

        while (num > 0) {
            int rest = num % 3;
            num /= 3;

            if (rest == 0) {
                num--;
            }

            answer = numbers[rest] + answer;
        }

        return answer;
    }

}
