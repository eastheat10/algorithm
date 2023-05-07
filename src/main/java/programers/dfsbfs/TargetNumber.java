package programers.dfsbfs;

public class TargetNumber {

    static int len;
    static int answer;
    static int t;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        len = numbers.length;
        t = target;

        func(0, 0, numbers);

        return answer;
    }

    static void func(int depth, int sum, int[] numbers) {
        if (depth == len) {
            if(sum == t)
                answer++;
        } else {
            func(depth + 1, sum + numbers[depth], numbers);
            func(depth + 1, sum - numbers[depth], numbers);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * numbers	        target	return
     * [1, 1, 1, 1, 1]	3   	5
     */
}
