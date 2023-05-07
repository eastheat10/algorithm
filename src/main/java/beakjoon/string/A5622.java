package beakjoon.stage7;

//입력
//첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
//
//출력
//첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.

import java.util.Scanner;

public class A5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자를 입력하세요: ");
		String s = sc.nextLine();

	    char[][] c = new char[10][];
	    int[] num = new int[s.length()];
	    int n = 0;

	    c[0] = new char[] {' '};
	    c[1] = new char[] {'A', 'B', 'C'};
	    c[2] = new char[] {'D', 'E', 'F'};
	    c[3] = new char[] {'G', 'H', 'I'};
	    c[4] = new char[] {'J', 'K', 'L'};
	    c[5] = new char[] {'M', 'N', 'O'};
	    c[6] = new char[] {'P', 'Q', 'R', 'S'};
	    c[7] = new char[] {'T', 'U', 'V'};
	    c[8] = new char[] {'W', 'X', 'Y', 'Z'};
	    c[9] = new char[] {' '};

	    char[] s1 = new char[s.length()];

	    for(int i = 0; i < s.length(); i++) {
	    	s1[i] = s.charAt(i);
	    }

	    for(int i = 0; i < c.length; i++) {
	    	for(int j = 0; j < c[i].length; j++) {
	    		for(int k = 0; k < s.length(); k++) {
	    			if(c[i][j] == s1[k]) {
	    				num[n] = i;
	    				n++;
	    			}
	    		}
	    	}
	    }

	    int sum = 0;

	    for(int  n1 : num) {
	    	sum += (n1 + 2);
	    }

	    System.out.println(sum);

	}
}
