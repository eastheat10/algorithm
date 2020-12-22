package algo.stage5;


//세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
//
//예를 들어 A = 150, B = 266, C = 427 이라면
//
//A × B × C = 150 × 266 × 427 = 17037300 이 되고,
//
//계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

import java.util.Scanner;

public class A2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A, B, C;
		int[] n = new int[10];

		String s = "";

		System.out.print("A B C 입력: ");
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		int result = A * B * C;
		s = String.valueOf(result);
		char[] c = new char[s.length()];

		for(int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}

		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < 10; j++) {
				if(Character.getNumericValue(c[i]) == j)
					n[j]++;
			}
		}
		for(int k : n)
			System.out.println(k);
	}


}
