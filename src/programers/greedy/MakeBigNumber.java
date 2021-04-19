package programers.greedy;

import java.util.Arrays;

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
            sb.append(max);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));

//        "1924"	    2	"94"
//        "1231234" 	3	"3234"
//        "4177252841"	4	"775841"


    }
}
