package programers.sort;

import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        boolean check = false;

        for (int i = len - 1; i >= 0; i--) {
            if (answer >= citations[i]) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));

    }

//    citations     	return
//    [3, 0, 6, 1, 5]	3

//    https://www.ibric.org/myboard/read.php?Board=news&id=270333
}
