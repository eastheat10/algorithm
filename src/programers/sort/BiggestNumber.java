package programers.sort;

import java.util.Arrays;
import java.util.Comparator;

// 가장 큰
public class BiggestNumber {
    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        int len = numbers.length;

        String[] s = new String[len];
        for (int i = 0; i < len; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (s[0].equals("0"))
            return "0";


        for (String s1 : s) {
            answer.append(s1);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
//    numbers	         return
//    [6, 10, 2]	     "6210"
//    [3, 30, 34, 5, 9]	 "9534330"
}
