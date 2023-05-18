package programers.etc;

import java.util.LinkedList;

/**
 * 뒤에 있는 큰 수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
public class FindBigNumber {

    public int[] solution(int[] numbers) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }

}
