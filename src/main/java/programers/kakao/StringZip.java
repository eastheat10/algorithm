package programers.kakao;

import java.util.*;

// 2020 Kakao Blind Recruitment
// 문자열 압축
public class StringZip {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
        System.out.println(solution("s"));
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        if (len == 1) return 1;

        for (int i = len / 2; i > 0; i--)
            answer = Math.min(zip(s, i), answer);

        return answer;
    }

    static int zip(String s, int n) {

        StringBuilder sb = new StringBuilder();
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < s.length(); i += n) {
            if (i + n > s.length()) {
                list1.add(s.substring(i, s.length()));
                list2.add(1);
                continue;
            }
            String a = s.substring(i, i + n);
            if (i == 0) {
                list1.add(a);
                list2.add(1);
                continue;
            }
            if (list1.get(list1.size() - 1).equals(a)) {
                int k = list2.get(list2.size() - 1);
                list2.remove(list2.size() - 1);
                list2.add(k + 1);
            } else {
                list1.add(a);
                list2.add(1);
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list2.get(i) > 1) {
                sb.append(list2.get(i)).append(list1.get(i));
            } else {
                sb.append(list1.get(i));
            }
        }

        return sb.toString().length();
    }

    /**
     * s	                        result
     * "aabbaccc"	                7
     * "ababcdcdababcdcd"	        9
     * "abcabcdede"	                8
     * "abcabcabcabcdededededede"	14
     * "xababcdcdababcdcd"	        17
     * "s"                          1
     */
}
