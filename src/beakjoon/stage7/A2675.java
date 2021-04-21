package beakjoon.stage7;

//입력
//첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
//
//출력
//각 테스트 케이스에 대해 P를 출력한다.

import java.util.Scanner;

public class A2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();

		String[] s = new String[n];
		sc.nextLine();

		for(int i = 0; i < s.length; i++) {
			s[i] = sc.nextLine();
		}


		for(int i = 0; i < n; i++) {

			String[] k = s[i].split(" ");

			int a = Integer.parseInt(k[0].trim());
			String ss = k[1].trim();

			for(int j = 0; j < ss.length(); j++)
				for(int t = 0; t < a; t++)
					System.out.print(ss.charAt(j));

			System.out.println(" ");

		}
	}


}
