package programers.weeklychallenge;

/**
 * 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class First {

    public static long solution(int price, int money, int count) {
        long answer = -1;

        long sum = ((long) count * ((long) count + 1) / 2) * (long) price;

        answer = sum > money ? sum - (long) money : 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
        // 10
    }
}
