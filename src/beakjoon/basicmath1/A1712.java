package beakjoon.stage8;


//입력
//첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.
//
//출력
//첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.

import java.util.Scanner;

public class A1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if(B >= C)
			System.out.println(-1);

		else
			System.out.println((A / (C - B)) + 1);

	}
}
