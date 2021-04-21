package programers.greedy;

import java.util.Stack;

// 큰 수 만들기
public class MakeBigNumber {

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int index = 0;
        int t = len - k;

        for (int i = 0; i < t; i++) {
            char max = '0';
            for (int j = index; j <= k + i; j++) {
                char tmp = number.charAt(j);
                if(max < tmp) {
                    max = tmp;
                    index = j + 1;
                }
            }
            System.out.println("max = " + max);
            sb.append(max);
        }

        return sb.toString();
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        System.out.println("k = " + k);

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }

            System.out.println("k = " + k);
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(solution2("1924", 2));
        System.out.println(solution2("1231234", 3));
        System.out.println(solution2("4177252841", 4));

//        "1924"	    2	"94"
//        "1231234" 	3	"3234"
//        "4177252841"	4	"775841"


    }
}
