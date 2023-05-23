package programers.etc;

import java.util.LinkedList;

/**
 * 택배상자
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        int orderIdx = 0;
        int i = 1;
        LinkedList<Integer> belt = new LinkedList<>();

        while (true) {

            if (!belt.isEmpty() && order[orderIdx] == belt.peek()) {
                answer++;
                orderIdx++;
                belt.pop();
                continue;
            }

            if (order.length < i) {
                break;
            }

            if (order[orderIdx] == i) {
                answer++;
                orderIdx++;
                i++;
                continue;
            }

            belt.push(i++);
        }

        return answer;
    }
}
