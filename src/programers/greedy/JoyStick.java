package programers.greedy;

// 조이스틱
public class JoyStick {

    public static int solution(String name) {
        int answer = 0;
        int len = name.length();

        int min = len - 1;

        for (int i = 0; i < len; i++) {
            // 조이스틱 상, 하 이동
            char c = name.charAt(i);
            int mov = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
            answer += mov;

            // 조이스틱 좌, 우 이동
            int nextIndex = i + 1;
            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            min = Math.min(min, (i * 2) + len - nextIndex);
        }
        answer += min;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }

}
