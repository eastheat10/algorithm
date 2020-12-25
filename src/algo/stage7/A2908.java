package algo.stage7;

//입력
//첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
//
//출력
//첫째 줄에 상수의 대답을 출력한다.

import java.util.Scanner;

public class A2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("두 수를 입력하세요: ");
		String s = sc.nextLine().trim();

		String[] number = s.split(" ");
		int a = 0;
		int b = 0;

		String s1 = "";
		String s2 = "";
		System.out.println(number[0].length() + " " + number[1].length());

		for(int i = 2; i >= 0; i--) {
			s1 += Character.toString(number[0].trim().charAt(i));
			s2 += Character.toString(number[1].trim().charAt(i));
		}

		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);

		if(a < b)
			System.out.println(b);
		else
			System.out.println(a);
	}
}
