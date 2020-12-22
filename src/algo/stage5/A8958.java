package algo.stage5;

//"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
//
//"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
//
//OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class A8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();
		String[] s = new String[n];
		int[] score = new int[n];
		int temp = 0;

		for(int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}

		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[i].length(); j++) {
				String c = Character.toString(s[i].charAt(j));
				if(c.equals("O")){
					temp++;
					score[i] += temp;
				}
				else
					temp = 0;
			}
			temp = 0;
		}

		for(int result : score)
			System.out.println(result);
	}


}
