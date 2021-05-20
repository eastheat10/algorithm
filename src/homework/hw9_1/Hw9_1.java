package homework.hw9_1;

public class Hw9_1 {

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static String lcs(String s1, String s2) {
        int len1 = s1.length(); // 첫번째 문자열 길이
        int len2 = s2.length(); // 두번째 문자열 길이
        int[][] check = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 문자열이 같으면
                    check[i][j] = check[i - 1][j - 1] + 1;
                } else {
                    check[i][j] = max(check[i - 1][j], check[i][j - 1]);
                }
            }
        }

        // LCS 문자열 찾기
        String tmp = "";
        while (check[len1][len2] != 0) { // 배열에서 0이 나올 때 까지
            // 배열의 맨 끝부터 탐색
            if (check[len1][len2] == check[len1][len2 - 1]) {
                // 현재 원소가 바로 앞의 원소와 같으면 바로 앞으로 이동
                len2--;
            }
            else if (check[len1][len2] == check[len1-1][len2]) {
                // 현재 원소가 바로 위의 원소와 같으면 바로 위로 이동
                len1--;
            }
            else {
                tmp += s1.charAt(len1 - 1);
                len1--;
                len2--;
            }
        }
        String answer = "";
        for (int l = tmp.length() - 1; l >= 0; l--) {
            // 역순으로 문자열 저장
            answer += tmp.charAt(l);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("hw9_1 : 윤동열");

        String s1 = "abcd";
        String s2 = "acbc";
        System.out.println("첫번째 문자열: " + s1);
        System.out.println("두번째 문자열: " + s2);

        String lcs = lcs(s1, s2);
        System.out.println("lcs 길이 = " + lcs.length());
        System.out.print("lcs = " + lcs + "\n\n");

        s1 = "aaa";
        s2 = "bbbb";
        System.out.println("첫번째 문자열: " + s1);
        System.out.println("두번째 문자열: " + s2);

        lcs = lcs(s1, s2);
        System.out.println("lcs 길이 = " + lcs.length());
        System.out.print("lcs = " + lcs + "\n\n");

        s1 = "this is a test. is this a test?";
        s2 = "is this a test? this is not a test.";
        System.out.println("첫번째 문자열: " + s1);
        System.out.println("두번째 문자열: " + s2);

        lcs = lcs(s1, s2);
        System.out.println("lcs 길이 = " + lcs.length());
        System.out.println("lcs = " + lcs);

    }

}
